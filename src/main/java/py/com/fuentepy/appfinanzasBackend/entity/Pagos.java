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
import javax.persistence.JoinColumns;
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
@Table(name = "pagos")
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_pago")
    private Integer nroPago;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Lob
    @Size(max = 16777215)
    @Column(name = "capital")
    private String capital;
    @Lob
    @Size(max = 16777215)
    @Column(name = "interes")
    private String interes;
    @Lob
    @Size(max = 16777215)
    @Column(name = "impuestos")
    private String impuestos;
    @JoinColumns({
        @JoinColumn(name = "nro_cuota", referencedColumnName = "nro_cuota")
        , @JoinColumn(name = "nro_credito", referencedColumnName = "nro_credito")})
    @ManyToOne(optional = false)
    private PlanesPagos planesPagos;
    @JoinColumn(name = "tipo_pago_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TiposPagos tipoPagoId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Pagos() {
    }

    public Pagos(Integer nroPago) {
        this.nroPago = nroPago;
    }

    public Integer getNroPago() {
        return nroPago;
    }

    public void setNroPago(Integer nroPago) {
        this.nroPago = nroPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public PlanesPagos getPlanesPagos() {
        return planesPagos;
    }

    public void setPlanesPagos(PlanesPagos planesPagos) {
        this.planesPagos = planesPagos;
    }

    public TiposPagos getTipoPagoId() {
        return tipoPagoId;
    }

    public void setTipoPagoId(TiposPagos tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroPago != null ? nroPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.nroPago == null && other.nroPago != null) || (this.nroPago != null && !this.nroPago.equals(other.nroPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.Pagos[ nroPago=" + nroPago + " ]";
    }
    
}
