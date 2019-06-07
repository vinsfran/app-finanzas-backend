package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "entidades_financieras")
public class EntidadFinanciera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;

    @JoinColumn(name = "usuarios_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadFinancieraId")
    private List<Credito> creditoList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entidadFinancieraId")
    private List<Ahorro> ahorroList;

}
