package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;

import java.util.List;

public interface CreditoService {

    List<Credito> findAll();

    Page<Credito> findAll(Pageable pageable);

    Credito findById(Integer id);

    Credito save(Credito cliente);

    void delete(Integer id);
}
