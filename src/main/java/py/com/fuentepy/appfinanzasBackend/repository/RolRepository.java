package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.com.fuentepy.appfinanzasBackend.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Page<Rol> findAllByOrderByIdAsc(Pageable pageable);

    Page<Rol> findAll(Pageable pageable);
}
