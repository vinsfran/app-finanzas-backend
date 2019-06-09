package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.converter.PrestamoConverter;
import py.com.fuentepy.appfinanzasBackend.entity.Prestamo;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.model.PrestamoModel;
import py.com.fuentepy.appfinanzasBackend.repository.PrestamoRepository;
import py.com.fuentepy.appfinanzasBackend.repository.UsuarioRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.PrestamoService;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private static final Log LOG = LogFactory.getLog(PrestamoServiceImpl.class);

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoModel> findAll() {
        return PrestamoConverter.listEntitytoListModel(prestamoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PrestamoModel> findAll(Pageable pageable) {
        return PrestamoConverter.pageEntitytoPageModel(pageable, prestamoRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public PrestamoModel findById(Long id) {
        PrestamoModel prestamoModel = null;
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(id);
        if (prestamoOptional.isPresent()) {
            prestamoModel = PrestamoConverter.entitytoModel(prestamoOptional.get());
        }
        return prestamoModel;
    }

    @Override
    @Transactional
    public PrestamoModel save(PrestamoModel prestamoModel) {
//        Usuario usuario = usuarioRepository.findById2(prestamoModel.getUsuarioId());
        Prestamo prestamo = PrestamoConverter.modeltoEntity(prestamoModel);
//        prestamo.setUsuarioId(usuario);
        return PrestamoConverter.entitytoModel(prestamoRepository.save(prestamo));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        prestamoRepository.deleteById(id);
    }
}
