package AvisaAi.modelo.dao.resposta;

public interface RespostaDAO {
	
	void inserirResposta(Resposta resposta);

	void deletarResposta(Resposta resposta);

	void atualizarResposta(Resposta resposta);

	List<Resposta> recuperarRespostas();

}
