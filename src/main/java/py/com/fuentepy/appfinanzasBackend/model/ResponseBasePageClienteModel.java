package py.com.fuentepy.appfinanzasBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import org.springframework.data.domain.Page;
import py.com.fuentepy.appfinanzasBackend.entity.Cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ResponseBasePageClienteModel extends ResponseBaseModel {

    @NotNull
    @NotBlank
    @JsonProperty("page")
    @SerializedName("page")
    private Page<Cliente> clientes;

    public ResponseBasePageClienteModel() {
    }

    public ResponseBasePageClienteModel(Integer code, boolean status, String message, @NotNull @NotBlank Page<Cliente> clientes) {
        super(code, status, message);
        this.clientes = clientes;
    }

    public Page<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Page<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "ResponseBasePageClienteModel{" +
                "clientes=" + clientes +
                '}';
    }
}