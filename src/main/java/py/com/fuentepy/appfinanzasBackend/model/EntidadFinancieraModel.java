package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import py.com.fuentepy.appfinanzasBackend.entity.Ahorro;
import py.com.fuentepy.appfinanzasBackend.entity.Credito;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinsfran
 */
@Data
public class EntidadFinancieraModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Integer id;

    @JsonProperty("nombre")
    @SerializedName("nombre")
    private String nombre;
    
}
