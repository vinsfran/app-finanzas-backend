package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.entity.TipoPago;
import py.com.fuentepy.appfinanzasBackend.repository.TipoPagoRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.TipoPagoService;

import java.util.List;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoPago> findAll() {
        return (List<TipoPago>) tipoPagoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TipoPago> findAll(Pageable pageable) {
        return tipoPagoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoPago findById(Integer id) {
        return tipoPagoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoPago save(TipoPago tipoPago) {
        return tipoPagoRepository.save(tipoPago);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tipoPagoRepository.deleteById(id);
    }
}
