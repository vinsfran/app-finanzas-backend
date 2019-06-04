package py.com.fuentepy.appfinanzasBackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "monedas")
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monedaId")
    private List<Credito> creditoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "monedaId")
    private List<Ahorro> ahorroList;

    public Moneda() {
    }

    public Moneda(Integer id) {
        this.id = id;
    }

    public Moneda(Integer id, String descripcion, String codigo) {
        this.id = id;
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    public List<Ahorro> getAhorroList() {
        return ahorroList;
    }

    public void setAhorroList(List<Ahorro> ahorroList) {
        this.ahorroList = ahorroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.Moneda[ id=" + id + " ]";
    }
    
}
