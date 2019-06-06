package py.com.fuentepy.appfinanzasBackend.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "pagos")
public class Pago implements Serializable {

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
    private PlanPago planPago;

    @JoinColumn(name = "tipo_pago_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPago tipoPagoId;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Pago() {
    }

    public Pago(Integer nroPago) {
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

    public PlanPago getPlanPago() {
        return planPago;
    }

    public void setPlanPago(PlanPago planPago) {
        this.planPago = planPago;
    }

    public TipoPago getTipoPagoId() {
        return tipoPagoId;
    }

    public void setTipoPagoId(TipoPago tipoPagoId) {
        this.tipoPagoId = tipoPagoId;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
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
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.nroPago == null && other.nroPago != null) || (this.nroPago != null && !this.nroPago.equals(other.nroPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.Pago[ nroPago=" + nroPago + " ]";
    }
    
}
