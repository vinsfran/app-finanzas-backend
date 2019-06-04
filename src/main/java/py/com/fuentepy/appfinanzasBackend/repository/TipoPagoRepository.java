package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.com.fuentepy.appfinanzasBackend.entity.TipoPago;

public interface TipoPagoRepository extends JpaRepository<TipoPago, Long> {

    Page<TipoPago> findAllByOrderByIdAsc(Pageable pageable);

    Page<TipoPago> findAll(Pageable pageable);
}
