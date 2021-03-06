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
import py.com.fuentepy.appfinanzasBackend.model.TarjetaModel;
import py.com.fuentepy.appfinanzasBackend.service.TarjetaService;
import py.com.fuentepy.appfinanzasBackend.service.UsuarioService;
import py.com.fuentepy.appfinanzasBackend.util.TokenUtil;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaResource {

    private static final Log LOG = LogFactory.getLog(TarjetaResource.class);

    @Autowired
    private TarjetaService tarjetaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public List<TarjetaModel> getAll(@RequestHeader("Authorization") String authorization) {
        Long usuarioId = TokenUtil.getIdFromToken(authorization);
        return tarjetaService.findByUsuarioId(usuarioId);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPageByUsuarioId(@RequestHeader("Authorization") String authorization,
                                   @ApiIgnore Pageable pageable) {
        Long usuarioId = TokenUtil.getIdFromToken(authorization);
        Page<TarjetaModel> tarjetas = null;
        Map<String, Object> response = new HashMap<>();
        try {
            tarjetas = tarjetaService.findByUsuarioId(usuarioId, pageable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (tarjetas == null) {
            response.put("mensaje", "No existen tarjetas en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("page", tarjetas);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        TarjetaModel tarjeta = null;
        Map<String, Object> response = new HashMap<>();
        try {
            tarjeta = tarjetaService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (tarjeta == null) {
            response.put("mensaje", "El Tarjeta ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tarjeta, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody TarjetaModel tarjetaModel, BindingResult result) {

        System.out.println("create: " + tarjetaModel.toString());

        TarjetaModel tarjetaNew = null;
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
            tarjetaNew = tarjetaService.save(tarjetaModel);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Tarjeta ha sido creada con éxito!");
        response.put("tarjeta", tarjetaNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping()
    public ResponseEntity<?> update(@Valid @RequestBody TarjetaModel tarjetaModel, BindingResult result) {
        Long id = tarjetaModel.getId();
        TarjetaModel tarjetaUpdated = null;
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


        if (tarjetaService.findById(id) == null) {
            response.put("mensaje", "Error: no se pudo editar, el Tarjeta Nro: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            tarjetaUpdated = tarjetaService.save(tarjetaModel);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Tarjeta ha sido actualizado con éxito!");
        response.put("tarjeta", tarjetaUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            tarjetaService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el Tarjeta de la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Tarjeta eliminada con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    @PostMapping("/tarjetas/upload")

//    @GetMapping("/uploads/img/{nombreFoto:.+}")

//    @Secured({"ROLE_ADMIN"})
//    @GetMapping("/tarjetas/regiones")
}
