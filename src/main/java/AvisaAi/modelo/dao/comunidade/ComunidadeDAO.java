package AvisaAi.modelo.dao.comunidade;

import java.util.List;

public interface ComunidadeDAO {
	
	void inserirComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);
	
	void atualizarComunidade(Comunidade comunidade);
	
	List<Comunidade> recuperarComunidades();

}
