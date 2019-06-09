package py.com.fuentepy.appfinanzasBackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author vinsfran
 */
@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;

    private String nombre;

    private String apellido;

    @Column(unique = true)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<EntidadFinanciera> entidadFinancieraList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<Ahorro> ahorroList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuarios_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"usuarios_id", "roles_id"})})
    private List<Rol> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioId")
    private List<PrestamoPago> prestamoPagoList;

}
