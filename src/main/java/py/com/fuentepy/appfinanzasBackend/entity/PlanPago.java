package py.com.fuentepy.appfinanzasBackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vinsfran
 */
@Entity
@Table(name = "planes_pagos")
public class PlanPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected PlanPagoPK planPagoPK;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPago")
    private List<Pago> pagoList;

    public PlanPago() {
    }

    public PlanPago(PlanPagoPK planPagoPK) {
        this.planPagoPK = planPagoPK;
    }

    public PlanPago(PlanPagoPK planPagoPK, Date fechaVto, Date fechaInicio, String pagosId) {
        this.planPagoPK = planPagoPK;
        this.fechaVto = fechaVto;
        this.fechaInicio = fechaInicio;
        this.pagosId = pagosId;
    }

    public PlanPago(int nroCuota, int nroCredito) {
        this.planPagoPK = new PlanPagoPK(nroCuota, nroCredito);
    }

    public PlanPagoPK getPlanPagoPK() {
        return planPagoPK;
    }

    public void setPlanPagoPK(PlanPagoPK planPagoPK) {
        this.planPagoPK = planPagoPK;
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

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planPagoPK != null ? planPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanPago)) {
            return false;
        }
        PlanPago other = (PlanPago) object;
        if ((this.planPagoPK == null && other.planPagoPK != null) || (this.planPagoPK != null && !this.planPagoPK.equals(other.planPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiappfinanza.PlanPago[ planPagoPK=" + planPagoPK + " ]";
    }
    
}
