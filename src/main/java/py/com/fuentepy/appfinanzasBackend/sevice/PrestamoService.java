package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.Prestamo;
import py.com.fuentepy.appfinanzasBackend.model.PrestamoModel;

import java.util.List;

public interface PrestamoService {

    List<PrestamoModel> findAll();

    Page<PrestamoModel> findAll(Pageable pageable);

    PrestamoModel findById(Long id);

    PrestamoModel save(PrestamoModel prestamoModel);

    void delete(Long id);
}
