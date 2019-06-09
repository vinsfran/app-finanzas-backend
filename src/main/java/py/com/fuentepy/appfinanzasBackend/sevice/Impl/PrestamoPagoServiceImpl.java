package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.converter.PrestamoPagoConverter;
import py.com.fuentepy.appfinanzasBackend.entity.PrestamoPago;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.model.PrestamoPagoModel;
import py.com.fuentepy.appfinanzasBackend.repository.PrestamoPagoRepository;
import py.com.fuentepy.appfinanzasBackend.repository.UsuarioRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.PrestamoPagoService;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoPagoServiceImpl implements PrestamoPagoService {

    private static final Log LOG = LogFactory.getLog(PrestamoPagoServiceImpl.class);

    @Autowired
    private PrestamoPagoRepository prestamoPagoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PrestamoPagoModel> findAll() {
        return PrestamoPagoConverter.listEntitytoListModel(prestamoPagoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PrestamoPagoModel> findAll(Pageable pageable) {
        return PrestamoPagoConverter.pageEntitytoPageModel(pageable, prestamoPagoRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public PrestamoPagoModel findById(Long id) {
        PrestamoPagoModel prestamoPagoModel = null;
        Optional<PrestamoPago> prestamoPagoOptional = prestamoPagoRepository.findById(id);
        if (prestamoPagoOptional.isPresent()) {
            prestamoPagoModel = PrestamoPagoConverter.entitytoModel(prestamoPagoOptional.get());
        }
        return prestamoPagoModel;
    }

    @Override
    @Transactional
    public PrestamoPagoModel save(PrestamoPagoModel prestamoPagoModel) {
        Usuario usuario = usuarioRepository.findById2(prestamoPagoModel.getUsuarioId());
        PrestamoPago prestamoPago = PrestamoPagoConverter.modeltoEntity(prestamoPagoModel);
        prestamoPago.setUsuarioId(usuario);
        return PrestamoPagoConverter.entitytoModel(prestamoPagoRepository.save(prestamoPago));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        prestamoPagoRepository.deleteById(id);
    }
}
