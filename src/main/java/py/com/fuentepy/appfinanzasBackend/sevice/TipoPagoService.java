package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.TipoPago;

import java.util.List;

public interface TipoPagoService {

    List<TipoPago> findAll();

    Page<TipoPago> findAll(Pageable pageable);

    TipoPago findById(Long id);

    TipoPago save(TipoPago tipoCobro);

    void delete(Long id);
}
