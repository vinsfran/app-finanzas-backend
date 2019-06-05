package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.entity.Moneda;
import py.com.fuentepy.appfinanzasBackend.repository.MonedaRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.MonedaService;

import java.util.List;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> findAll() {
        return (List<Moneda>) monedaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Moneda> findAll(Pageable pageable) {
        return monedaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Moneda findById(Integer id) {
        return monedaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Moneda save(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        monedaRepository.deleteById(id);
    }
}
