package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.converter.ConceptoConverter;
import py.com.fuentepy.appfinanzasBackend.entity.Concepto;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.model.ConceptoModel;
import py.com.fuentepy.appfinanzasBackend.repository.ConceptoRepository;
import py.com.fuentepy.appfinanzasBackend.repository.UsuarioRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.ConceptoService;

import java.util.List;
import java.util.Optional;

@Service
public class ConceptoServiceImpl implements ConceptoService {

    private static final Log LOG = LogFactory.getLog(ConceptoServiceImpl.class);

    @Autowired
    private ConceptoRepository ahorroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ConceptoModel> findAll() {
        return ConceptoConverter.listEntitytoListModel(ahorroRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ConceptoModel> findByUsuarioId(Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return ConceptoConverter.listEntitytoListModel(ahorroRepository.findByUsuarioId(usuario));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConceptoModel> findAll(Pageable pageable) {
        return ConceptoConverter.pageEntitytoPageModel(pageable, ahorroRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConceptoModel> findByUsuarioId(Long usuarioId, Pageable pageable) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return ConceptoConverter.pageEntitytoPageModel(pageable, ahorroRepository.findByUsuarioId(usuario, pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public ConceptoModel findById(Integer id) {
        ConceptoModel model = null;
        Optional<Concepto> optional = ahorroRepository.findById(id);
        if (optional.isPresent()) {
            model = ConceptoConverter.entitytoModel(optional.get());
        }
        return model;
    }

    @Override
    @Transactional
    public ConceptoModel save(ConceptoModel ahorroModel) {
        Concepto entity = ConceptoConverter.modeltoEntity(ahorroModel);
        return ConceptoConverter.entitytoModel(ahorroRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ahorroRepository.deleteById(id);
    }
}
