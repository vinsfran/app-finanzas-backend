package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;

public interface CreditoRepository extends JpaRepository<Credito, Integer> {

    Page<Credito> findAll(Pageable pageable);

    Credito findByNroCredito(Integer nroCredito);
}
