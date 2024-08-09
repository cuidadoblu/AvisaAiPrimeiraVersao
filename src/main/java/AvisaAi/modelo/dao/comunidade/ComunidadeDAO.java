package AvisaAi.modelo.dao.comunidade;

import java.util.List;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.localidade.Localidade;

public interface ComunidadeDAO {
	
	void inserirComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);
	
	void atualizarComunidade(Comunidade comunidade);
	
	Comunidade consultarComunidadeBairro(Localidade localidade);
	
	List<Comunidade> recuperarComunidades();

}
