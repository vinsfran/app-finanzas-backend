package py.com.fuentepy.appfinanzasBackend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "credito")
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_credito")
    private Integer nroCredito;
    @Lob
    @Size(max = 16777215)
    @Column(name = "monto_desembolsado")
    private String montoDesembolsado;
    @Lob
    @Size(max = 16777215)
    @Column(name = "total_capital")
    private String totalCapital;
    @Lob
    @Size(max = 16777215)
    @Column(name = "total_interes")
    private String totalInteres;
    @Lob
    @Size(max = 16777215)
    @Column(name = "taza_tan")
    private String tazaTan;
    @Lob
    @Size(max = 16777215)
    @Column(name = "taza_tae")
    private String tazaTae;
    @Column(name = "fecha_desembolso")
    @Temporal(TemporalType.DATE)
    private Date fechaDesembolso;
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "plazo_total")
    private Integer plazoTotal;
    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;
    @Size(max = 255)
    @Column(name = "producto_descripcion")
    private String productoDescripcion;
    @Size(max = 255)
    @Column(name = "destino_credito")
    private String destinoCredito;
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credito")
    private List<PlanesPagos> planesPagosList;
    @JoinColumn(name = "entidade_financiera_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntidadesFinancieras entidadeFinancieraId;
    @JoinColumn(name = "moneda_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Monedas monedaId;

    public Credito() {
    }

    public Credito(Integer nroCredito) {
        this.nroCredito = nroCredito;
    }

    public Integer getNroCredito() {
        return nroCredito;
    }

    public void setNroCredito(Integer nroCredito) {
        this.nroCredito = nroCredito;
    }

    public String getMontoDesembolsado() {
        return montoDesembolsado;
    }

    public void setMontoDesembolsado(String montoDesembolsado) {
        this.montoDesembolsado = montoDesembolsado;
    }

    public String getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(String totalCapital) {
        this.totalCapital = totalCapital;
    }

    public String getTotalInteres() {
        return totalInteres;
    }

    public void setTotalInteres(String totalInteres) {
        this.totalInteres = totalInteres;
    }

    public String getTazaTan() {
        return tazaTan;
    }

    public void setTazaTan(String tazaTan) {
        this.tazaTan = tazaTan;
    }

    public String getTazaTae() {
        return tazaTae;
    }

    public void setTazaTae(String tazaTae) {
        this.tazaTae = tazaTae;
    }

    public Date getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(Date fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getPlazoTotal() {
        return plazoTotal;
    }

    public void setPlazoTotal(Integer plazoTotal) {
        this.plazoTotal = plazoTotal;
    }

    public Integer getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(Integer cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getProductoDescripcion() {
        return productoDescripcion;
    }

    public void setProductoDescripcion(String productoDescripcion) {
        this.productoDescripcion = productoDescripcion;
    }

    public String getDestinoCredito() {
        return destinoCredito;
    }

    public void setDestinoCredito(String destinoCredito) {
        this.destinoCredito = destinoCredito;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<PlanesPagos> getPlanesPagosList() {
        return planesPagosList;
    }

    public void setPlanesPagosList(List<PlanesPagos> planesPagosList) {
        this.planesPagosList = planesPagosList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroCredito != null ? nroCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.nroCredito == null && other.nroCredito != null) || (this.nroCredito != null && !this.nroCredito.equals(other.nroCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.Credito[ nroCredito=" + nroCredito + " ]";
    }
    
}
