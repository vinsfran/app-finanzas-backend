package py.com.fuentepy.appfinanzasBackend.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.fuentepy.appfinanzasBackend.entity.Concepto;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;
import py.com.fuentepy.appfinanzasBackend.model.ConceptoModel;

import java.util.ArrayList;
import java.util.List;

@Component("conceptoConverter")
public class ConceptoConverter {

    public static Concepto modeltoEntity(ConceptoModel model) {
        Usuario usuario = new Usuario();
        usuario.setId(model.getUsuarioId());
        Concepto entity = new Concepto();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setSigno(model.getSigno());
        entity.setUsuarioId(usuario);
        return entity;
    }

    public static ConceptoModel entitytoModel(Concepto entity) {
        ConceptoModel model = new ConceptoModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setSigno(entity.getSigno());
        model.setUsuarioId(entity.getUsuarioId().getId());
        return model;
    }

    public static List<ConceptoModel> listEntitytoListModel(List<Concepto> listEntity) {
        List<ConceptoModel> listModel = new ArrayList<>();
        for (Concepto entity : listEntity) {
            listModel.add(entitytoModel(entity));
        }
        return listModel;
    }

    static List<ConceptoModel> mapEntitiesIntoDTOs(Iterable<Concepto> entities) {
        List<ConceptoModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(entitytoModel(e)));
        return dtos;
    }

    public static Page<ConceptoModel> pageEntitytoPageModel(Pageable pageable, Page<Concepto> pageEntity) {
        List<ConceptoModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}