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
public class PrestamoPagoModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @JsonProperty("numeroCuota")
    @SerializedName("numeroCuota")
    private Integer numeroCuota;

    @JsonProperty("fechaPago")
    @SerializedName("fechaPago")
    private Date fechaPago;

    @JsonProperty("montoPagado")
    @SerializedName("montoPagado")
    private Long montoPagado;

    @JsonProperty("prestamoId")
    @SerializedName("prestamoId")
    private Long prestamoId;

    @JsonProperty("tipoPagoId")
    @SerializedName("tipoPagoId")
    private Integer tipoPagoId;

    @JsonProperty("usuarioId")
    @SerializedName("usuarioId")
    private Long usuarioId;

}
