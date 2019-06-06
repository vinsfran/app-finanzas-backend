package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;

public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Integer> {

    Page<EntidadFinanciera> findAllByOrderByIdAsc(Pageable pageable);

    Page<EntidadFinanciera> findAll(Pageable pageable);
}
