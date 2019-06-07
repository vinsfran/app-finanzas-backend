package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

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
@Data
@Entity
@Table(name = "ahorros")
public class Ahorro implements Serializable {

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

    @JoinColumn(name = "entidades_financieras_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntidadFinanciera entidadFinancieraId;

    @JoinColumn(name = "monedas_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaId;

    @JoinColumn(name = "tipos_ahorros_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoAhorro tipoAhorroId;

    @JoinColumn(name = "tipos_cobros_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCobro tipoCobroId;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
}
