package AvisaAi.modelo.dao.incidente;

import java.util.List;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;

public interface IncidenteDAO {
	
	void inserirIncidente(Incidente incidente);
	
	void deletarIncidente(Incidente incidente);
	
	void atualizarIncidente(Incidente incidente);
	
	List<Incidente> consultarIncidentesComunidade(Comunidade comunidade);
	
	List<Incidente> consultarIncidentesCategoria(Incidente incidente);
	
	List<Incidente> consultarIncidentesUsuarioPorData(Usuario usuario, Incidente incidente);
	
	List<Incidente> consultarIncidentesLogradouroPorData(Localidade localidade, Incidente incidente);
	
	List<Incidente> consultarIncidentesSituacao(Incidente incidente);	

}
