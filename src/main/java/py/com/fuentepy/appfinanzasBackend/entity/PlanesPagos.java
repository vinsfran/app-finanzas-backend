package py.com.fuentepy.appfinanzasBackend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "planes_pagos")
@NamedQueries({
    @NamedQuery(name = "PlanesPagos.findAll", query = "SELECT p FROM PlanesPagos p")})
public class PlanesPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PlanesPagosPK planesPagosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vto")
    @Temporal(TemporalType.DATE)
    private Date fechaVto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
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
    @Column(name = "impuesto")
    private String impuesto;
    @Lob
    @Size(max = 16777215)
    @Column(name = "plazo")
    private String plazo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "capital_saldo")
    private String capitalSaldo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "interes_saldo")
    private String interesSaldo;
    @Column(name = "estado")
    private Boolean estado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "pagos_id")
    private String pagosId;
    @JoinColumn(name = "nro_credito", referencedColumnName = "nro_credito", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Credito credito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planesPagos")
    private List<Pagos> pagosList;

    public PlanesPagos() {
    }

    public PlanesPagos(PlanesPagosPK planesPagosPK) {
        this.planesPagosPK = planesPagosPK;
    }

    public PlanesPagos(PlanesPagosPK planesPagosPK, Date fechaVto, Date fechaInicio, String pagosId) {
        this.planesPagosPK = planesPagosPK;
        this.fechaVto = fechaVto;
        this.fechaInicio = fechaInicio;
        this.pagosId = pagosId;
    }

    public PlanesPagos(int nroCuota, int nroCredito) {
        this.planesPagosPK = new PlanesPagosPK(nroCuota, nroCredito);
    }

    public PlanesPagosPK getPlanesPagosPK() {
        return planesPagosPK;
    }

    public void setPlanesPagosPK(PlanesPagosPK planesPagosPK) {
        this.planesPagosPK = planesPagosPK;
    }

    public Date getFechaVto() {
        return fechaVto;
    }

    public void setFechaVto(Date fechaVto) {
        this.fechaVto = fechaVto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
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

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getCapitalSaldo() {
        return capitalSaldo;
    }

    public void setCapitalSaldo(String capitalSaldo) {
        this.capitalSaldo = capitalSaldo;
    }

    public String getInteresSaldo() {
        return interesSaldo;
    }

    public void setInteresSaldo(String interesSaldo) {
        this.interesSaldo = interesSaldo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPagosId() {
        return pagosId;
    }

    public void setPagosId(String pagosId) {
        this.pagosId = pagosId;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planesPagosPK != null ? planesPagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanesPagos)) {
            return false;
        }
        PlanesPagos other = (PlanesPagos) object;
        if ((this.planesPagosPK == null && other.planesPagosPK != null) || (this.planesPagosPK != null && !this.planesPagosPK.equals(other.planesPagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.PlanesPagos[ planesPagosPK=" + planesPagosPK + " ]";
    }
    
}
