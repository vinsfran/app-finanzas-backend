package py.com.fuentepy.appfinanzasBackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import py.com.fuentepy.appfinanzasBackend.entity.EntidadFinanciera;
import py.com.fuentepy.appfinanzasBackend.model.EntidadFinancieraModel;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface EntidadFinancieraMapper {

    /**
     * The interface declares a member INSTANCE, providing clients access to the mapper implementation,
     * which is the file target\generated-sources\com\company\springapp\dto\mappers\MapperImpl.java
     * (automatically generated when compiling the project).
     */
//    AuditMapper INSTANCE = Mappers.getMapper(EntidadFinancieraMapper.class);

    /**
     * Convert entity to DTO.
     * Mappings are used to 'bind' entity fields to DTO fields (for the mapper's implementation).
     *
     * @param entity
     * @return
     */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre")
    })
    EntidadFinancieraModel entidadFinancieraToEntityEntidadFinancieraModel(EntidadFinanciera entity);

    /**
     * Convert entities' list to DTOs' list.
     *
     * @param entities
     * @return
     */
    List<EntidadFinancieraModel> entitiesToEntityDTOs(List<EntidadFinanciera> entities);
}
