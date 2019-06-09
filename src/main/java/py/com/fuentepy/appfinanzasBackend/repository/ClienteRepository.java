package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.stereotype.Repository;
import py.com.fuentepy.appfinanzasBackend.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByOrderByIdAsc(Pageable pageable);

    Page<Cliente> findAll(Pageable pageable);
}
