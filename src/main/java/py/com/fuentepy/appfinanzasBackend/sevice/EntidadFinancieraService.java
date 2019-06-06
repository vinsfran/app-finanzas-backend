package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;

import java.util.List;

public interface EntidadFinancieraService {

    List<EntidadFinanciera> findAll();

    Page<EntidadFinanciera> findAll(Pageable pageable);

    EntidadFinanciera findById(Integer id);

    EntidadFinanciera save(EntidadFinanciera cliente, Long usuarioId);

    void delete(Integer id);
}
