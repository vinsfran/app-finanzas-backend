package py.com.fuentepy.appfinanzasBackend.repository;

import py.com.fuentepy.appfinanzasBackend.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByOrderByIdAsc(Pageable pageable);
}
