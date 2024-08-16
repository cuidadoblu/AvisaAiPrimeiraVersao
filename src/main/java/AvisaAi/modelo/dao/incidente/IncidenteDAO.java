package AvisaAi.modelo.dao.incidente;

import java.util.List;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.enumeracao.categoria.Categoria;
import AvisaAi.modelo.enumeracao.situacao.Situacao;

public interface IncidenteDAO {
	
	void inserirIncidente(Incidente incidente);
	
	void deletarIncidente(Incidente incidente);
	
	void atualizarIncidente(Incidente incidente);
	
	List<Incidente> consultarIncidenteComunidade(Comunidade comunidade);
	
	List<Incidente> consultarIncidenteCategoria(Categoria categoria);
	
	List<Incidente> consultarIncidenteUsuarioPorData(Usuario usuario, Incidente incidente);
	
	List<Incidente> consultarIncidenteLogradouroPorData(Localidade localidade, Incidente incidente);
	
	List<Incidente> consultarIncidenteSituacao(Situacao situacao);	

}
