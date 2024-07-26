package AvisaAi.modelo.dao.contato;

public interface ContatoDAO {
	
	void inserirContato(Contato contato);
	
	void deletarContato(Contato contato);
	
	void atualizarContato(Contato contato);
	
	List<Contato> recuperarContato();
	
	Contato recuperarContatoUsuario(Usuario usuario);

}
