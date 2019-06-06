package py.com.fuentepy.appfinanzasBackend.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;
import py.com.fuentepy.appfinanzasBackend.sevice.CreditoService;
import py.com.fuentepy.appfinanzasBackend.sevice.UsuarioService;
import py.com.fuentepy.appfinanzasBackend.util.TokenUtil;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CreditoResource {

    private static final Log LOG = LogFactory.getLog(CreditoResource.class);

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/creditos")
    public List<Credito> index() {
        return creditoService.findAll();
    }

    @GetMapping("/creditos/page")
    public ResponseEntity<?> index(@ApiIgnore Pageable pageable) {
        Page<Credito> creditos = null;
//        Page<CreditoModel> creditosModels = null;
        Map<String, Object> response = new HashMap<>();
        try {
            creditos = creditoService.findAll(pageable);
//            creditosModels = CreditoConverter.pageEntitytoPageModel(pageable, creditos);
//            creditos.getTotalPages()
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (creditos == null) {
            response.put("mensaje", "No existen creditos en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("page", creditos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/creditos/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        Credito credito = null;
        Map<String, Object> response = new HashMap<>();
        try {
            credito = creditoService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (credito == null) {
            response.put("mensaje", "El Credito ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(credito, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/creditos")
    public ResponseEntity<?> create(@RequestHeader("Authorization") String authorization,
                                    @Valid @RequestBody Credito credito, BindingResult result) {


        Long id = TokenUtil.getIdFromToken(authorization);
        LOG.info("id: " + id);
        Credito creditoNew = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
//            List<String> errors = new ArrayList<>();
//            for (FieldError err : result.getFieldErrors()) {
//                errors.add("El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage()));
//            }

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> {
                        return "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage());
                    })
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            creditoNew = creditoService.save(credito);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Credito ha sido creada con éxito!");
        response.put("credito", creditoNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/creditos/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Credito credito, BindingResult result, @PathVariable Integer id) {
        Credito creditoActual = creditoService.findById(id);
        Credito creditoUpdated = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
//            List<String> errors = new ArrayList<>();
//            for (FieldError err : result.getFieldErrors()) {
//                errors.add("El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage()));
//            }

            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> {
                        return "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage());
                    })
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        if (creditoActual == null) {
            response.put("mensaje", "Error: no se pudo editar, la Entidad Financiera ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            creditoActual.setCantidadCuotas(credito.getCantidadCuotas());
            creditoUpdated = creditoService.save(creditoActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Credito ha sido actualizado con éxito!");
        response.put("credito", creditoUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/creditos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            creditoService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la Entidad Financiera de la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Credito eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    @PostMapping("/creditos/upload")

//    @GetMapping("/uploads/img/{nombreFoto:.+}")

//    @Secured({"ROLE_ADMIN"})
//    @GetMapping("/creditos/regiones")
}
