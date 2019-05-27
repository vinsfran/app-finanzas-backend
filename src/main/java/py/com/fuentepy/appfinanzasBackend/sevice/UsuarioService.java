package py.com.fuentepy.appfinanzasBackend.sevice;

import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

public interface UsuarioService {

    Usuario findByUsername(String username);
}
