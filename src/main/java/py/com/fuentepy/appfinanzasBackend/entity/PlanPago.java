package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "planes_pagos")
public class PlanPago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_cuota")
    private Integer nroCuota;

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

    @JoinColumn(name = "creditos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Credito creditoId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planPagoId")
    private List<Pago> pagoList;

}
