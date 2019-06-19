package py.com.fuentepy.appfinanzasBackend.service.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.converter.AhorroConverter;
import py.com.fuentepy.appfinanzasBackend.entity.Ahorro;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.model.AhorroModel;
import py.com.fuentepy.appfinanzasBackend.repository.AhorroRepository;
import py.com.fuentepy.appfinanzasBackend.service.AhorroService;

import java.util.List;
import java.util.Optional;

@Service
public class AhorroServiceImpl implements AhorroService {

    private static final Log LOG = LogFactory.getLog(AhorroServiceImpl.class);

    @Autowired
    private AhorroRepository ahorroRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AhorroModel> findAll() {
        return AhorroConverter.listEntitytoListModel(ahorroRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AhorroModel> findByUsuarioId(Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return AhorroConverter.listEntitytoListModel(ahorroRepository.findByUsuarioId(usuario));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AhorroModel> findAll(Pageable pageable) {
        return AhorroConverter.pageEntitytoPageModel(pageable, ahorroRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AhorroModel> findByUsuarioId(Long usuarioId, Pageable pageable) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return AhorroConverter.pageEntitytoPageModel(pageable, ahorroRepository.findByUsuarioId(usuario, pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public AhorroModel findById(Long id) {
        AhorroModel model = null;
        Optional<Ahorro> optional = ahorroRepository.findById(id);
        if (optional.isPresent()) {
            model = AhorroConverter.entityToModel(optional.get());
        }
        return model;
    }

    @Override
    @Transactional
    public AhorroModel save(AhorroModel ahorroModel) {
        Ahorro entity = AhorroConverter.modelToEntity(ahorroModel);
        return AhorroConverter.entityToModel(ahorroRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ahorroRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countByTenantName(Long usuarioId) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        return ahorroRepository.countByUsuarioId(usuario);
    }
}
