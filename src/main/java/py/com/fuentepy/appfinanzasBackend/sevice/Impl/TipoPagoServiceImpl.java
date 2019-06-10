package py.com.fuentepy.appfinanzasBackend.sevice.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.fuentepy.appfinanzasBackend.converter.TipoPagoConverter;
import py.com.fuentepy.appfinanzasBackend.entity.TipoPago;
import py.com.fuentepy.appfinanzasBackend.model.TipoPagoModel;
import py.com.fuentepy.appfinanzasBackend.repository.TipoPagoRepository;
import py.com.fuentepy.appfinanzasBackend.sevice.TipoPagoService;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagoServiceImpl implements TipoPagoService {

    @Autowired
    private TipoPagoRepository tipoPagoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoPagoModel> findAll() {
        return TipoPagoConverter.listEntitytoListModel(tipoPagoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<TipoPagoModel> findAll(Pageable pageable) {
        return TipoPagoConverter.pageEntitytoPageModel(pageable, tipoPagoRepository.findAll(pageable));
    }

    @Override
    @Transactional(readOnly = true)
    public TipoPagoModel findById(Integer id) {
        TipoPagoModel model = null;
        Optional<TipoPago> optional = tipoPagoRepository.findById(id);
        if (optional.isPresent()) {
            model = TipoPagoConverter.entitytoModel(optional.get());
        }
        return model;
    }

    @Override
    @Transactional
    public TipoPagoModel save(TipoPagoModel model) {
        //        Usuario usuario = usuarioRepository.findById2(prestamoModel.getUsuarioId());
        TipoPago entity = TipoPagoConverter.modeltoEntity(model);
//        prestamo.setUsuarioId(usuario);
        return TipoPagoConverter.entitytoModel(tipoPagoRepository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        tipoPagoRepository.deleteById(id);
    }
}
