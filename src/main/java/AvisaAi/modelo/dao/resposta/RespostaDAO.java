package AvisaAi.modelo.dao.resposta;

import java.util.List;

import AvisaAi.modelo.entidade.comentario.Comentario;
import AvisaAi.modelo.entidade.comentario.resposta.Resposta;
import AvisaAi.modelo.entidade.usuario.Usuario;

public interface RespostaDAO {
	
	void inserirResposta(Resposta resposta);

	void deletarResposta(Resposta resposta);

	void atualizarResposta(Resposta resposta);

	List<Resposta> recuperarRespostas();
	
	List<Resposta> consultarRespostaComentarioOrigem(Comentario comentario);
	
	List<Resposta> consultarComentarioUsuario(Usuario usuario);

}
