package py.com.fuentepy.appfinanzasBackend.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.fuentepy.appfinanzasBackend.model.DashboardModel;
import py.com.fuentepy.appfinanzasBackend.service.AhorroService;
import py.com.fuentepy.appfinanzasBackend.service.PrestamoService;
import py.com.fuentepy.appfinanzasBackend.util.TokenUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardResource {

    private static final Log LOG = LogFactory.getLog(DashboardResource.class);

    @Autowired
    private AhorroService ahorroService;

    @Autowired
    private PrestamoService prestamoService;

    @Secured({"ROLE_ADMIN"})
    @GetMapping()
    public ResponseEntity<?> getPageByUsuarioId(@RequestHeader("Authorization") String authorization) {
        Long usuarioId = TokenUtil.getIdFromToken(authorization);
        DashboardModel dashboardModel = new DashboardModel();
        Map<String, Object> response = new HashMap<>();
        try {
            dashboardModel.setTotalAhorros(ahorroService.countByTenantName(usuarioId));
            dashboardModel.setTotalPrestamos(prestamoService.countByTenantName(usuarioId));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos!");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        if (totalAhorros == null) {
//            response.put("mensaje", "No existen ahorros en la base de datos!");
//            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//        }
        response.put("dashboard", dashboardModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
