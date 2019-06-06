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
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;
import py.com.fuentepy.appfinanzasBackend.sevice.EntidadFinancieraService;
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
public class EntidadFinancieraResource {

    private static final Log LOG = LogFactory.getLog(EntidadFinancieraResource.class);

    @Autowired
    private EntidadFinancieraService entidadFinancieraService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/entidadesFinancieras")
    public List<EntidadFinanciera> index() {
        return entidadFinancieraService.findAll();
    }

    @GetMapping("/entidadesFinancieras/page")
    public ResponseEntity<?> index(@ApiIgnore Pageable pageable) {
        Page<EntidadFinanciera> entidadesFinancieras = null;
        Map<String, Object> response = new HashMap<>();
        try {
            entidadesFinancieras = entidadFinancieraService.findAll(pageable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (entidadesFinancieras == null) {
            response.put("mensaje", "No existen entidadesFinancieras en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("page", entidadesFinancieras);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/entidadesFinancieras/{id}")
    public ResponseEntity<?> show(@PathVariable Integer id) {
        EntidadFinanciera entidadFinanciera = null;
        Map<String, Object> response = new HashMap<>();
        try {
            entidadFinanciera = entidadFinancieraService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (entidadFinanciera == null) {
            response.put("mensaje", "La Entidad Financiera ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entidadFinanciera, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/entidadesFinancieras")
    public ResponseEntity<?> create(@RequestHeader("Authorization") String authorization,
                                    @Valid @RequestBody EntidadFinanciera entidadFinanciera, BindingResult result) {


        Long id = TokenUtil.getIdFromToken(authorization);
        LOG.info("id: " + id);
        EntidadFinanciera entidadFinancieraNew = null;
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
            entidadFinancieraNew = entidadFinancieraService.save(entidadFinanciera, id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La Entidad Financiera ha sido creada con éxito!");
        response.put("entidadFinanciera", entidadFinancieraNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/entidadesFinancieras/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody EntidadFinanciera entidadFinanciera, BindingResult result, @PathVariable Integer id) {
        EntidadFinanciera entidadFinancieraActual = entidadFinancieraService.findById(id);
        EntidadFinanciera entidadFinancieraUpdated = null;
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
        if (entidadFinancieraActual == null) {
            response.put("mensaje", "Error: no se pudo editar, la Entidad Financiera ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            entidadFinancieraActual.setNombre(entidadFinanciera.getNombre());
            entidadFinancieraUpdated = entidadFinancieraService.save(entidadFinancieraActual, null);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La Entidad Financiera ha sido actualizado con éxito!");
        response.put("entidadFinanciera", entidadFinancieraUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/entidadesFinancieras/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            entidadFinancieraService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar la Entidad Financiera de la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La Entidad Financiera eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    @PostMapping("/entidadesFinancieras/upload")

//    @GetMapping("/uploads/img/{nombreFoto:.+}")

//    @Secured({"ROLE_ADMIN"})
//    @GetMapping("/entidadesFinancieras/regiones")
}
