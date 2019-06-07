package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "pagos")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

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

    @JoinColumn(name = "planes_pagos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PlanPago planPagoId;

    @JoinColumn(name = "tipos_pagos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPago tipoPagoId;

    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

}
