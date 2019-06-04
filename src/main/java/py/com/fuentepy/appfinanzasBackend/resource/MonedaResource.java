package py.com.fuentepy.appfinanzasBackend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import py.com.fuentepy.appfinanzasBackend.entity.Moneda;
import py.com.fuentepy.appfinanzasBackend.sevice.MonedaService;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MonedaResource {

    @Autowired
    private MonedaService monedaService;

    @GetMapping("/monedas")
    public List<Moneda> index() {
        return monedaService.findAll();
    }

    @GetMapping("/monedas/page")
    public ResponseEntity<?> index(@ApiIgnore Pageable pageable) {
        Page<Moneda> monedas = null;
        Map<String, Object> response = new HashMap<>();
        try {
            monedas = monedaService.findAll(pageable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (monedas == null) {
            response.put("mensaje", "No existen monedas en la base de datos!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("page", monedas);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/monedas/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Moneda moneda = null;
        Map<String, Object> response = new HashMap<>();
        try {
            moneda = monedaService.findById(id);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if (moneda == null) {
            response.put("mensaje", "El moneda ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(moneda, HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/monedas")
    public ResponseEntity<?> create(@Valid @RequestBody Moneda moneda, BindingResult result) {
        Moneda monedaNew = null;
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
            monedaNew = monedaService.save(moneda);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El moneda ha sido creado con éxito!");
        response.put("moneda", monedaNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/monedas/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Moneda moneda, BindingResult result, @PathVariable Long id) {
        Moneda monedaActual = monedaService.findById(id);
        Moneda monedaUpdated = null;
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
        if (monedaActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el moneda ID: ".concat(id.toString()).concat(" no existe en la base de datos!"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            monedaActual.setDescripcion(moneda.getDescripcion());
            monedaActual.setCodigo(moneda.getCodigo());
            monedaUpdated = monedaService.save(monedaActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el insert en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El moneda ha sido actualizado con éxito!");
        response.put("moneda", monedaUpdated);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/monedas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            monedaService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el moneda de la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El moneda eliminado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
//    @PostMapping("/monedas/upload")

//    @GetMapping("/uploads/img/{nombreFoto:.+}")

//    @Secured({"ROLE_ADMIN"})
//    @GetMapping("/monedas/regiones")
}