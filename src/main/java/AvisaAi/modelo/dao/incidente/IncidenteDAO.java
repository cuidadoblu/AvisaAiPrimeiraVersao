package AvisaAi.modelo.dao.incidente;

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
	
	Incidente consultarIncidenteComunidade(Comunidade comunidade);
	
	Incidente consultarIncidenteCategoria(Categoria categoria);
	
	Incidente consultarIncidenteUsuarioPorData(Usuario usuario);
	
	Incidente consultarIncidenteLogradouroPorData(Localidade localidade);
	
	Incidente consultarIncidenteSituacao(Situacao situacao);	

}
