package py.com.fuentepy.appfinanzasBackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query("select u from Usuario u where u.username=?1")
    Usuario findByUsername2(String username);

    @Query("select u from Usuario u where u.id=?1")
    Usuario findById2(Long usuarioId);
}
