package py.com.fuentepy.appfinanzasBackend.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vinsfran
 */
@Embeddable
public class PlanesPagosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_cuota")
    private int nroCuota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_credito")
    private int nroCredito;

    public PlanesPagosPK() {
    }

    public PlanesPagosPK(int nroCuota, int nroCredito) {
        this.nroCuota = nroCuota;
        this.nroCredito = nroCredito;
    }

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public int getNroCredito() {
        return nroCredito;
    }

    public void setNroCredito(int nroCredito) {
        this.nroCredito = nroCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nroCuota;
        hash += (int) nroCredito;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanesPagosPK)) {
            return false;
        }
        PlanesPagosPK other = (PlanesPagosPK) object;
        if (this.nroCuota != other.nroCuota) {
            return false;
        }
        if (this.nroCredito != other.nroCredito) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.PlanesPagosPK[ nroCuota=" + nroCuota + ", nroCredito=" + nroCredito + " ]";
    }
    
}
