package AvisaAi.modelo.dao.foto;

public interface FotoDAO {
	
	void inserirFoto(Foto foto); 

	void deletarFoto(Foto foto); 

	void atualizarFoto(Foto foto); 

	List<Foto> recuperarFotos(); 
	
}
