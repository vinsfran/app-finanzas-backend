package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author vinsfran
 */
@Data
public class DashboardModel {

    @JsonProperty("totalAhorros")
    @SerializedName("totalAhorros")
    private Long totalAhorros;

    @JsonProperty("totalPrestamos")
    @SerializedName("totalPrestamos")
    private Long totalPrestamos;
}
