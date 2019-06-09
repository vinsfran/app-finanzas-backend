package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.model.PrestamoPagoModel;

import java.util.List;

public interface PrestamoPagoService {

    List<PrestamoPagoModel> findAll();

    Page<PrestamoPagoModel> findAll(Pageable pageable);

    PrestamoPagoModel findById(Long id);

    PrestamoPagoModel save(PrestamoPagoModel prestamoPagoModel);

    void delete(Long id);
}
