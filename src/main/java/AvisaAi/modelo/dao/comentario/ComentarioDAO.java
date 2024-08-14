package AvisaAi.modelo.dao.comentario;

import java.util.List;

import AvisaAi.modelo.entidade.comentario.Comentario;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.usuario.Usuario;

public interface ComentarioDAO {
	
	void inserirComentario(Comentario comentario);

	void deletarComentario(Comentario comentario);

	void atualizarComentario(Comentario comentario);
	
	List<Comentario> recuperarComentarios();
	
	List<Comentario> consultarComentarioIncidente(Incidente incidente);
	
	List<Comentario> consultarComentarioUsuario(Usuario usuario);
}