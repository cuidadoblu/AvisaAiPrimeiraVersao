package AvisaAi.modelo.dao.usuario;

import java.util.List;

import AvisaAi.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {
	
	void inserirUsuario(Usuario usuario); 

	void deletarUsuario(Usuario usuario); 

	void atualizarUsuario(Usuario usuario); 

	List<Usuario> recuperarUsuarios(); 

}
