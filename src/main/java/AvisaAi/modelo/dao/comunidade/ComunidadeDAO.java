package AvisaAi.modelo.dao.comunidade;

import java.util.List;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;

public interface ComunidadeDAO {
	
	void inserirComunidade(Comunidade comunidade);
	
	void deletarComunidade(Comunidade comunidade);
	
	void atualizarComunidade(Comunidade comunidade);
	
	Comunidade consultarComunidadeBairro(Localidade localidade);
	
	List<Usuario> consultarQuantidadeUsuariosComunidade(Comunidade comunidade);
	
	List<Comunidade> recuperarComunidades();

}
