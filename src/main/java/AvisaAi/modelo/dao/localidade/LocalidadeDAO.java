package AvisaAi.modelo.dao.localidade;

import java.util.List;

import AvisaAi.modelo.entidade.localidade.Localidade;

public interface LocalidadeDAO {

	void inserirLocalidade(Localidade localidade); 

	void deletarLocalidade(Localidade localidade); 

	void atualizarLocalidade(Localidade localidade); 

	List<Localidade> recuperarLocalidades();

	List<Localidade> consultarLocalidadePorLogradouro(String logradouro);

	List<Localidade> consultarLocalidadePorCidade(String cidade);

	List<Localidade> consultarLocalidadePorBairro(String bairro); 
}
