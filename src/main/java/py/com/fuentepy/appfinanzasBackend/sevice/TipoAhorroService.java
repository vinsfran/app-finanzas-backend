package py.com.fuentepy.appfinanzasBackend.sevice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.fuentepy.appfinanzasBackend.entity.TipoAhorro;

import java.util.List;

public interface TipoAhorroService {

    List<TipoAhorro> findAll();

    Page<TipoAhorro> findAll(Pageable pageable);

    TipoAhorro findById(Long id);

    TipoAhorro save(TipoAhorro tipoAhorro);

    void delete(Long id);
}
