package py.com.fuentepy.appfinanzasBackend.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;
import py.com.fuentepy.appfinanzasBackend.model.EntidadFinancieraModel;

import java.util.ArrayList;
import java.util.List;

@Component("entidadFinancieraConverter")
public class EntidadFinancieraConverter {

//    @Autowired
//    private EntidadFinancieraMapper mapper;

    public static EntidadFinanciera modeltoEntity(EntidadFinancieraModel model) {
        EntidadFinanciera entity = new EntidadFinanciera();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        return entity;
    }

    public static EntidadFinancieraModel entitytoModel(EntidadFinanciera entity) {
        EntidadFinancieraModel model = new EntidadFinancieraModel();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        return model;
    }

    public static List<EntidadFinancieraModel> listEntitytoListModel(List<EntidadFinanciera> listEntity) {
        List<EntidadFinancieraModel> listModel = new ArrayList<>();
        for (EntidadFinanciera entity : listEntity) {
            listModel.add(entitytoModel(entity));
        }
        return listModel;
    }

    static List<EntidadFinancieraModel> mapEntitiesIntoDTOs(Iterable<EntidadFinanciera> entities) {
        List<EntidadFinancieraModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(entitytoModel(e)));
        return dtos;
    }

    public static Page<EntidadFinancieraModel> pageEntitytoPageModel(Pageable pageable, Page<EntidadFinanciera> pageEntity) {
        List<EntidadFinancieraModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
