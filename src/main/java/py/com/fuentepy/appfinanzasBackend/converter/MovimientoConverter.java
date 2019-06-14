package py.com.fuentepy.appfinanzasBackend.converter;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.fuentepy.appfinanzasBackend.entity.*;
import py.com.fuentepy.appfinanzasBackend.model.MovimientoModel;

import java.util.ArrayList;
import java.util.List;

@CommonsLog
@Component("movimientoConverter")
public class MovimientoConverter {

    private static final Log LOG = LogFactory.getLog(MovimientoConverter.class);

    public static Movimiento modelToEntity(MovimientoModel model) {
        Concepto concepto = new Concepto();
        concepto.setId(model.getId());
        concepto.setNombre(model.getConceptoNombre());
        Moneda moneda = new Moneda();
        moneda.setId(model.getMonedaId());
        moneda.setNombre(model.getMonedaNombre());
        moneda.setCodigo(model.getMonedaCodigo());
        Usuario usuario = new Usuario();
        usuario.setId(model.getUsuarioId());
        Movimiento entity = new Movimiento();
        entity.setId(model.getId());
        entity.setMonto(model.getMonto());
        entity.setConceptoId(concepto);
        entity.setMonedaId(moneda);
        entity.setUsuarioId(usuario);
        return entity;
    }

    public static MovimientoModel entityToModel(Movimiento entity) {
        MovimientoModel model = new MovimientoModel();
        model.setId(entity.getId());
        model.setMonto(entity.getMonto());
        model.setConceptoId(entity.getConceptoId().getId());
        model.setConceptoNombre(entity.getConceptoId().getNombre());
        model.setMonedaId(entity.getMonedaId().getId());
        model.setMonedaNombre(entity.getMonedaId().getNombre());
        model.setMonedaCodigo(entity.getMonedaId().getCodigo());
        model.setUsuarioId(entity.getUsuarioId().getId());
        return model;
    }

    public static List<MovimientoModel> listEntitytoListModel(List<Movimiento> listEntity) {
        List<MovimientoModel> listModel = new ArrayList<>();
        for (Movimiento entity : listEntity) {
            listModel.add(entityToModel(entity));
        }
        return listModel;
    }

    static List<MovimientoModel> mapEntitiesIntoDTOs(Iterable<Movimiento> entities) {
        List<MovimientoModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(entityToModel(e)));
        return dtos;
    }

    public static Page<MovimientoModel> pageEntitytoPageModel(Pageable pageable, Page<Movimiento> pageEntity) {
        List<MovimientoModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
