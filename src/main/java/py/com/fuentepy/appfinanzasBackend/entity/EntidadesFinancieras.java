package py.com.fuentepy.appfinanzasBackend.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "entidades_financieras")
@NamedQueries({
    @NamedQuery(name = "EntidadesFinancieras.findAll", query = "SELECT e FROM EntidadesFinancieras e")})
public class EntidadesFinancieras implements Serializable {

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
    private Usuarios usuarioId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadeFinancieraId")
    private List<Credito> creditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadeFinancieraId")
    private List<Ahorros> ahorrosList;

    public EntidadesFinancieras() {
    }

    public EntidadesFinancieras(Integer id) {
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

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<Credito> getCreditoList() {
        return creditoList;
    }

    public void setCreditoList(List<Credito> creditoList) {
        this.creditoList = creditoList;
    }

    public List<Ahorros> getAhorrosList() {
        return ahorrosList;
    }

    public void setAhorrosList(List<Ahorros> ahorrosList) {
        this.ahorrosList = ahorrosList;
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
        if (!(object instanceof EntidadesFinancieras)) {
            return false;
        }
        EntidadesFinancieras other = (EntidadesFinancieras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.EntidadesFinancieras[ id=" + id + " ]";
    }
    
}
