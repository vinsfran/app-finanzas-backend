package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author vinsfran
 */
@Data
public class MovimientoModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @JsonProperty("fechaMovimiento")
    @SerializedName("fechaMovimiento")
    private Date fechaMovimiento;

    @JsonProperty("monto")
    @SerializedName("monto")
    private Long monto;

    @JsonProperty("conceptoId")
    @SerializedName("conceptoId")
    private Integer conceptoId;

    @JsonProperty("conceptoNombre")
    @SerializedName("conceptoNombre")
    private String conceptoNombre;

    @JsonProperty("monedaId")
    @SerializedName("monedaId")
    private Integer monedaId;

    @JsonProperty("monedaNombre")
    @SerializedName("monedaNombre")
    private String monedaNombre;

    @JsonProperty("monedaCodigo")
    @SerializedName("monedaCodigo")
    private String monedaCodigo;

    @JsonProperty("usuarioId")
    @SerializedName("usuarioId")
    private Long usuarioId;

}
