package AvisaAi.modelo.dao.comentario;

public interface ComentarioDAO {
	
	void inserirComentario(Comentario comentario); 

	void deletarComentario(Comentario comentario); 

	void atualizarComentario(Comentario comentario); 

	List<Comentario> recuperarComentarios(); 
	
}