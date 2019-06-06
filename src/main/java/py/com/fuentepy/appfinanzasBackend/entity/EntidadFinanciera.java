package py.com.fuentepy.appfinanzasBackend.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "entidades_financieras")
public class EntidadFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadeFinancieraId")
    private List<Credito> creditoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadeFinancieraId")
    private List<Ahorro> ahorroList;

    public EntidadFinanciera() {
    }

    public EntidadFinanciera(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof EntidadFinanciera)) {
            return false;
        }
        EntidadFinanciera other = (EntidadFinanciera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.EntidadFinanciera[ id=" + id + " ]";
    }
    
}
