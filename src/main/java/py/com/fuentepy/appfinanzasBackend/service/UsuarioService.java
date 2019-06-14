package py.com.fuentepy.appfinanzasBackend.service;

import py.com.fuentepy.appfinanzasBackend.entity.Usuario;

public interface UsuarioService {

    Usuario findByUsername(String username);
}
