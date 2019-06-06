package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.repository.EntidadFinancieraRepository;
import py.com.fuentepy.appfinanzasBackend.repository.UsuarioRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.EntidadFinancieraService;

import java.util.List;

@Service
public class EntidadFinancieraServiceImpl implements EntidadFinancieraService {

    private static final Log LOG = LogFactory.getLog(EntidadFinancieraServiceImpl.class);

    @Autowired
    private EntidadFinancieraRepository entidadFinancieraRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EntidadFinanciera> findAll() {
        return (List<EntidadFinanciera>) entidadFinancieraRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EntidadFinanciera> findAll(Pageable pageable) {
        return entidadFinancieraRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public EntidadFinanciera findById(Integer id) {
        return entidadFinancieraRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public EntidadFinanciera save(EntidadFinanciera entidadFinanciera, Long usuarioId) {
        Usuario usuario = usuarioRepository.findById2(usuarioId);
        LOG.info(usuario.getId());
        entidadFinanciera.setUsuarioId(usuario);
        return entidadFinancieraRepository.save(entidadFinanciera);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entidadFinancieraRepository.deleteById(id);
    }
}
