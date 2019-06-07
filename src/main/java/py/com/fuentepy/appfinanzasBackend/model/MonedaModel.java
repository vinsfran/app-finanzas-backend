package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author vinsfran
 */
@Data
public class MonedaModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Integer id;

    @JsonProperty("descripcion")
    @SerializedName("descripcion")
    private String descripcion;

    @JsonProperty("codigo")
    @SerializedName("codigo")
    private String codigo;

}
