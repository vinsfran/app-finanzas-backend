package py.com.fuentepy.appfinanzasBackend.converter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;
import py.com.fuentepy.appfinanzasBackend.entity.Moneda;
import py.com.fuentepy.appfinanzasBackend.model.CreditoModel;

import java.util.ArrayList;
import java.util.List;

@Component("creditoConverter")
public class CreditoConverter {

//    @Autowired
//    private CreditoMapper mapper;

    public static Credito modeltoEntity(CreditoModel model) {
        Credito entity = new Credito();
        entity.setNroCredito(model.getNroCredito());
        entity.setMontoDesembolsado(model.getMontoDesembolsado());
        entity.setTotalCapital(model.getTotalCapital());
        entity.setTotalInteres(model.getTotalInteres());
        entity.setTazaTan(model.getTazaTan());
        entity.setTazaTae(model.getTazaTae());
        entity.setFechaDesembolso(model.getFechaDesembolso());
        entity.setFechaVencimiento(model.getFechaVencimiento());
        entity.setPlazoTotal(model.getPlazoTotal());
        entity.setCantidadCuotas(model.getCantidadCuotas());
        entity.setProductoDescripcion(model.getProductoDescripcion());
        entity.setDestinoCredito(model.getDestinoCredito());
        entity.setEstado(model.getEstado());
        EntidadFinanciera entidadFinanciera = new EntidadFinanciera();
        entidadFinanciera.setId(model.getEntidadeFinancieraId());
        entity.setEntidadeFinancieraId(entidadFinanciera);
        Moneda moneda = new Moneda();
        moneda.setId(model.getMonedaId());
        entity.setMonedaId(moneda);
        return entity;
    }

    public static CreditoModel entitytoModel(Credito entity) {
        CreditoModel model = new CreditoModel();
        model.setNroCredito(entity.getNroCredito());
        model.setMontoDesembolsado(entity.getMontoDesembolsado());
        model.setTotalCapital(entity.getTotalCapital());
        model.setTotalInteres(entity.getTotalInteres());
        model.setTazaTan(entity.getTazaTan());
        model.setTazaTae(entity.getTazaTae());
        model.setFechaDesembolso(entity.getFechaDesembolso());
        model.setFechaVencimiento(entity.getFechaVencimiento());
        model.setPlazoTotal(entity.getPlazoTotal());
        model.setCantidadCuotas(entity.getCantidadCuotas());
        model.setProductoDescripcion(entity.getProductoDescripcion());
        model.setDestinoCredito(entity.getDestinoCredito());
        model.setEstado(entity.getEstado());
        model.setEntidadeFinancieraId(entity.getEntidadeFinancieraId().getId());
        model.setMonedaId(entity.getMonedaId().getId());
        return model;
    }

    public static List<CreditoModel> listEntitytoListModel(List<Credito> listEntity) {
        List<CreditoModel> listModel = new ArrayList<>();
        for (Credito entity : listEntity) {
            listModel.add(entitytoModel(entity));
        }
        return listModel;
    }

    static List<CreditoModel> mapEntitiesIntoDTOs(Iterable<Credito> entities) {
        List<CreditoModel> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(entitytoModel(e)));
        return dtos;
    }

    public static Page<CreditoModel> pageEntitytoPageModel(Pageable pageable, Page<Credito> pageEntity) {
        List<CreditoModel> models = mapEntitiesIntoDTOs(pageEntity.getContent());
        return new PageImpl<>(models, pageable, pageEntity.getTotalElements());
    }
}
