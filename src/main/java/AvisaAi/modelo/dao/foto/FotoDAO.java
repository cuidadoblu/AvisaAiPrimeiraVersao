package AvisaAi.modelo.dao.foto;

import java.util.List;

import AvisaAi.modelo.entidade.foto.Foto;

public interface FotoDAO {
	
	void inserirFoto(Foto foto);

	void deletarFoto(Foto foto);

	void atualizarFoto(Foto foto);

	List<Foto> recuperarFotos();
	
	Foto consultarFotoId(Long id);
	
}
