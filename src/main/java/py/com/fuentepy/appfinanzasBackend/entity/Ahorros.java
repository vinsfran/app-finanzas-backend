package py.com.fuentepy.appfinanzasBackend.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "ahorros")
@NamedQueries({
    @NamedQuery(name = "Ahorros.findAll", query = "SELECT a FROM Ahorros a")})
public class Ahorros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_vto")
    @Temporal(TemporalType.DATE)
    private Date fechaVto;
    @Lob
    @Size(max = 16777215)
    @Column(name = "monto_capital")
    private String montoCapital;
    @Lob
    @Size(max = 16777215)
    @Column(name = "monto_interes_total")
    private String montoInteresTotal;
    @Lob
    @Size(max = 16777215)
    @Column(name = "tasa")
    private String tasa;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "plazo")
    private Integer plazo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "monto_interes_cuota")
    private String montoInteresCuota;
    @Lob
    @Size(max = 16777215)
    @Column(name = "cantidad_cobro")
    private String cantidadCobro;
    @Column(name = "total_cuotas")
    private Integer totalCuotas;
    @JoinColumn(name = "entidade_financiera_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntidadesFinancieras entidadeFinancieraId;
    @JoinColumn(name = "moneda_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monedas monedaId;
    @JoinColumn(name = "tipos_ahorros_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposAhorros tiposAhorrosId;
    @JoinColumn(name = "tipo_cobro_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposCobros tipoCobroId;
    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuariosId;

    public Ahorros() {
    }

    public Ahorros(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    public String getMontoCapital() {
        return montoCapital;
    }

    public void setMontoCapital(String montoCapital) {
        this.montoCapital = montoCapital;
    }

    public String getMontoInteresTotal() {
        return montoInteresTotal;
    }

    public void setMontoInteresTotal(String montoInteresTotal) {
        this.montoInteresTotal = montoInteresTotal;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public String getMontoInteresCuota() {
        return montoInteresCuota;
    }

    public void setMontoInteresCuota(String montoInteresCuota) {
        this.montoInteresCuota = montoInteresCuota;
    }

    public String getCantidadCobro() {
        return cantidadCobro;
    }

    public void setCantidadCobro(String cantidadCobro) {
        this.cantidadCobro = cantidadCobro;
    }

    public Integer getTotalCuotas() {
        return totalCuotas;
    }

    public void setTotalCuotas(Integer totalCuotas) {
        this.totalCuotas = totalCuotas;
    }

    public EntidadesFinancieras getEntidadeFinancieraId() {
        return entidadeFinancieraId;
    }

    public void setEntidadeFinancieraId(EntidadesFinancieras entidadeFinancieraId) {
        this.entidadeFinancieraId = entidadeFinancieraId;
    }

    public Monedas getMonedaId() {
        return monedaId;
    }

    public void setMonedaId(Monedas monedaId) {
        this.monedaId = monedaId;
    }

    public TiposAhorros getTiposAhorrosId() {
        return tiposAhorrosId;
    }

    public void setTiposAhorrosId(TiposAhorros tiposAhorrosId) {
        this.tiposAhorrosId = tiposAhorrosId;
    }

    public TiposCobros getTipoCobroId() {
        return tipoCobroId;
    }

    public void setTipoCobroId(TiposCobros tipoCobroId) {
        this.tipoCobroId = tipoCobroId;
    }

    public Usuarios getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(Usuarios usuariosId) {
        this.usuariosId = usuariosId;
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
        if (!(object instanceof Ahorros)) {
            return false;
        }
        Ahorros other = (Ahorros) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.Ahorros[ id=" + id + " ]";
    }
    
}
