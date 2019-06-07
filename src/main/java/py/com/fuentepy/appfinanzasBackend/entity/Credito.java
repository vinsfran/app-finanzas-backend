package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

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
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "credito")
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nro_credito")
    private Integer nroCredito;

    @Column(name = "monto_desembolsado")
    private Long montoDesembolsado;

    @Column(name = "total_capital")
    private Long totalCapital;

    @Column(name = "total_interes")
    private Long totalInteres;

    @Column(name = "taza_tan")
    private Long tazaTan;

    @Column(name = "taza_tae")
    private Long tazaTae;

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
    private List<PlanPago> planPagoList;

    @JoinColumn(name = "entidade_financiera_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EntidadFinanciera entidadeFinancieraId;

    @JoinColumn(name = "moneda_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaId;

}
