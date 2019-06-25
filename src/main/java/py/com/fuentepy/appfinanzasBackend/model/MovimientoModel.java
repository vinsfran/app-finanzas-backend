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

    @JsonProperty("numeroComprobante")
    @SerializedName("numeroComprobante")
    private String numeroComprobante;

    @JsonProperty("fechaMovimiento")
    @SerializedName("fechaMovimiento")
    private Date fechaMovimiento;

    @JsonProperty("monto")
    @SerializedName("monto")
    private Long monto;

    @JsonProperty("nombreEntidad")
    @SerializedName("nombreEntidad")
    private String nombreEntidad;

    @JsonProperty("conceptoId")
    @SerializedName("conceptoId")
    private Integer conceptoId;

    @JsonProperty("conceptoNombre")
    @SerializedName("conceptoNombre")
    private String conceptoNombre;

    @JsonProperty("tipoConcepto")
    @SerializedName("tipoConcepto")
    private String tipoConcepto;

    @JsonProperty("monedaId")
    @SerializedName("monedaId")
    private Integer monedaId;

    @JsonProperty("monedaNombre")
    @SerializedName("monedaNombre")
    private String monedaNombre;

    @JsonProperty("monedaCodigo")
    @SerializedName("monedaCodigo")
    private String monedaCodigo;

    @JsonProperty("tipoPagoId")
    @SerializedName("tipoPagoId")
    private Integer tipoPagoId;

    @JsonProperty("tipoPagoNombre")
    @SerializedName("tipoPagoNombre")
    private String tipoPagoNombre;

    @JsonProperty("usuarioId")
    @SerializedName("usuarioId")
    private Long usuarioId;

}
