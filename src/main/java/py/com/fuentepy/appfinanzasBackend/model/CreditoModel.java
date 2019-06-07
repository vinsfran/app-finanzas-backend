package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author vinsfran
 */
@Data
public class CreditoModel implements Serializable {

    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @JsonProperty("nroCredito")
    @SerializedName("nroCredito")
    private Integer nroCredito;

    @JsonProperty("montoDesembolsado")
    @SerializedName("montoDesembolsado")
    private Long montoDesembolsado;

    @JsonProperty("totalCapital")
    @SerializedName("totalCapital")
    private Long totalCapital;

    @JsonProperty("totalInteres")
    @SerializedName("totalInteres")
    private Long totalInteres;

    @JsonProperty("tazaTan")
    @SerializedName("tazaTan")
    private Long tazaTan;

    @JsonProperty("tazaTae")
    @SerializedName("tazaTae")
    private Long tazaTae;

    @JsonProperty("fechaDesembolso")
    @SerializedName("fechaDesembolso")
    private Date fechaDesembolso;

    @JsonProperty("fechaVencimiento")
    @SerializedName("fechaVencimiento")
    private Date fechaVencimiento;

    @JsonProperty("plazoTotal")
    @SerializedName("plazoTotal")
    private Integer plazoTotal;

    @JsonProperty("cantidadCuotas")
    @SerializedName("cantidadCuotas")
    private Integer cantidadCuotas;

    @JsonProperty("productoDescripcion")
    @SerializedName("productoDescripcion")
    private String productoDescripcion;

    @JsonProperty("destinoCredito")
    @SerializedName("destinoCredito")
    private String destinoCredito;

    @JsonProperty("estado")
    @SerializedName("estado")
    private Boolean estado;

    @JsonProperty("entidadFinancieraId")
    @SerializedName("entidadFinancieraId")
    private Integer entidadFinancieraId;

    @JsonProperty("entidadFinancieraNombre")
    @SerializedName("entidadFinancieraNombre")
    private String entidadFinancieraNombre;

    @JsonProperty("monedaId")
    @SerializedName("monedaId")
    private Integer monedaId;

    @JsonProperty("monedaDescripcion")
    @SerializedName("monedaDescripcion")
    private String monedaDescripcion;

    @JsonProperty("monedaCodigo")
    @SerializedName("monedaCodigo")
    private String monedaCodigo;

}
