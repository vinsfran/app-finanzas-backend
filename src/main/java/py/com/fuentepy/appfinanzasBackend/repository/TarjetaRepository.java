package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.fuentepy.appfinanzasBackend.entity.Tarjeta;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

import java.util.Date;
import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {

    List<Tarjeta> findByUsuarioId(Usuario usuario);

    Page<Tarjeta> findByUsuarioId(Usuario usuario, Pageable pageable);

    Long countByUsuarioId(Usuario usuario);

    @Query(value = "select u from Tarjeta u where u.usuarioId = :usuario and u.fechaVencimiento BETWEEN :startDate and :endDate")
    List<Tarjeta> findByUsuarioIdRangoFecha(@Param("usuario") Usuario usuario, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

//    @Query(value = "select u from Tarjeta u where u.usuarioId = :usuario")
//    List<Tarjeta> findByUsuarioId(@Param("usuario") Usuario usuario);
}
