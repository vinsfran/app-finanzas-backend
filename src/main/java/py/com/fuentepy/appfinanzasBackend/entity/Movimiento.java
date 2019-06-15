package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author vinsfran
 */
@Data
@CommonsLog
@Entity
@Table(name = "movimientos")
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_movimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMovimiento;

    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private Long monto;

    @JoinColumn(name = "concepto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Concepto conceptoId;

    @JoinColumn(name = "moneda_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Moneda monedaId;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
}
