package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.repository.CreditoRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.CreditoService;

import java.util.List;

@Service
public class CreditoServiceImpl implements CreditoService {

    private static final Log LOG = LogFactory.getLog(CreditoServiceImpl.class);

    @Autowired
    private CreditoRepository creditoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Credito> findAll() {
        return (List<Credito>) creditoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Credito> findAll(Pageable pageable) {
        return creditoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Credito findByNroCredito(Integer nroCredito) {
        return creditoRepository.findByNroCredito(nroCredito);
    }

    @Override
    @Transactional
    public Credito save(Credito credito) {
        return creditoRepository.save(credito);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        creditoRepository.deleteById(id);
    }
}
