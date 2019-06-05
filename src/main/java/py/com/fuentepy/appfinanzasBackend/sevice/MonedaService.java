package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.Moneda;

import java.util.List;

public interface MonedaService {

    List<Moneda> findAll();

    Page<Moneda> findAll(Pageable pageable);

    Moneda findById(Integer id);

    Moneda save(Moneda moneda);

    void delete(Integer id);
}
