package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.Rol;

import java.util.List;

public interface RolService {

    List<Rol> findAll();

    Page<Rol> findAll(Pageable pageable);

    Rol findById(Long id);

    Rol save(Rol cliente);

    void delete(Long id);
}
