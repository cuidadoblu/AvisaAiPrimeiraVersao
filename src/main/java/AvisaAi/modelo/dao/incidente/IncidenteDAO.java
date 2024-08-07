package AvisaAi.modelo.dao.incidente;

import java.util.List;

public interface IncidenteDAO {
	
	void inserirIncidente(Incidente incidente);
	
	void deletarIncidente(Incidente incidente);
	
	void atualizarIncidente(Incidente incidente);
	
	List<Incidente> recuperarIncidente();

}
