package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.fuentepy.appfinanzasBackend.entity.PrestamoPago;

@Repository
public interface PrestamoPagoRepository extends JpaRepository<PrestamoPago, Long> {

    Page<PrestamoPago> findAll(Pageable pageable);
}
