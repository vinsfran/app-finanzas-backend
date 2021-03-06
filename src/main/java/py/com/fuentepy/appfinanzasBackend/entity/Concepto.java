package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author vinsfran
 */
@Data
@CommonsLog
@Entity
@Table(name = "conceptos")
public class Concepto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_concepto")
    private String tipoConcepto;

    @Column(name = "global_enable")
    private Boolean globalEnable;

    @Size(min = 1, max = 45)
    @Column(name = "codigo_concepto")
    private String codigoConcepto;

    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;
    
}
