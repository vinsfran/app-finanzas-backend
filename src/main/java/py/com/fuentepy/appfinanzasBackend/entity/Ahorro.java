package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "ahorros")
public class Ahorro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "monto_capital")
    private Long montoCapital;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(name = "plazo_total")
    private Integer plazoTotal;

    @Column(name = "interes")
    private Long interes;

    @Column(name = "tasa")
    private Long tasa;

    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;

    @Column(name = "cantidad_cuotas_pagadas")
    private Integer cantidadCuotasPagadas;

    @Column(name = "monto_cuota")
    private Long montoCuota;

    @Column(name = "monto_interes_cuota")
    private Long montoInteresCuota;

    @Column(name = "cantidad_cobro")
    private Long cantidadCobro;

    @Column(name = "monto_pagado")
    private Long montoPagado;

    @Column(name = "monto_ultimo_pago")
    private Long montoUltimoPago;

    @Column(name = "estado")
    private Boolean estado;

    @JoinColumn(name = "tipos_ahorros_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAhorro tipoAhorroId;

    @JoinColumn(name = "monedas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaId;

    @JoinColumn(name = "entidades_financieras_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntidadFinanciera entidadFinancieraId;

    @JoinColumn(name = "tipos_cobros_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCobro tipoCobroId;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
}
