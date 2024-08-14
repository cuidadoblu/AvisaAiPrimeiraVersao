package AvisaAi.modelo.dao.contato;

import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.entidade.usuario.contato.Contato;

public interface ContatoDAO {
	
	void inserirContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	void atualizarContato(Contato contato);
	
	Contato recuperarContatoUsuario(Usuario usuario);

}
