package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.fuentepy.appfinanzasBackend.entity.Prestamo;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    List<Prestamo> findByUsuarioId(Usuario usuario);

    Page<Prestamo> findByUsuarioId(Usuario usuario, Pageable pageable);

    Long countByUsuarioId(Usuario usuario);
}
