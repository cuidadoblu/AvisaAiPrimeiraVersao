import java.time.LocalDateTime;

import AvisaAi.modelo.dao.comentario.ComentarioDAO;
import AvisaAi.modelo.dao.comentario.ComentarioDAOImpl;
import AvisaAi.modelo.dao.comunidade.ComunidadeDAO;
import AvisaAi.modelo.dao.comunidade.ComunidadeDAOImpl;
import AvisaAi.modelo.dao.contato.ContatoDAO;
import AvisaAi.modelo.dao.contato.ContatoDAOImpl;
import AvisaAi.modelo.dao.foto.FotoDAO;
import AvisaAi.modelo.dao.foto.FotoDAOImpl;
import AvisaAi.modelo.dao.incidente.IncidenteDAO;
import AvisaAi.modelo.dao.incidente.IncidenteDAOImpl;
import AvisaAi.modelo.dao.localidade.LocalidadeDAO;
import AvisaAi.modelo.dao.localidade.LocalidadeDAOImpl;
import AvisaAi.modelo.dao.resposta.RespostaDAO;
import AvisaAi.modelo.dao.resposta.RespostaDAOImpl;
import AvisaAi.modelo.dao.usuario.UsuarioDAO;
import AvisaAi.modelo.dao.usuario.UsuarioDAOImpl;
import AvisaAi.modelo.entidade.comentario.Comentario;
import AvisaAi.modelo.entidade.comentario.resposta.Resposta;
import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.foto.Foto;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.entidade.usuario.contato.Contato;
import AvisaAi.modelo.enumeracao.categoria.Categoria;
import AvisaAi.modelo.enumeracao.situacao.Situacao;

public class Principal {
	
	public static void main (String[] args) {
		
		ContatoDAO contatoDAO = new ContatoDAOImpl();
//		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
//		LocalidadeDAO localidadeDAO = new LocalidadeDAOImpl();
//		ComunidadeDAO comunidadeDAO = new ComunidadeDAOImpl();
//		IncidenteDAO incidenteDAO = new IncidenteDAOImpl();
//		FotoDAO fotoDAO = new FotoDAOImpl();
//		ComentarioDAO comentarioDAO = new ComentarioDAOImpl();
//		RespostaDAO respostaDAO = new RespostaDAOImpl();
		
		Contato contato1 = new Contato("012 1234-1234", "emailteste@gmail.com");
		contatoDAO.inserirContato(contato1);
		
//		Usuario usuario1 = new Usuario("Gabriel Andrei", "Junges", "12345", contato1);
//		usuarioDAO.inserirUsuario(usuario1);
//		
//		Localidade localidade1 = new Localidade("Rua Vendelino Krauss", "Fortaleza", "Blumenau", "SC", "Loja de Materiais de Construção");
//		localidadeDAO.inserirLocalidade(localidade1);
//		
//		Foto fotoComunidade = new Foto(null, null); //Não sei o que ficará nessas colunas da foto
//		fotoDAO.inserirFoto(fotoComunidade);
//		
//		Comunidade comunidade1 = new Comunidade("Comunidade da Fortaleza", localidade1, fotoComunidade);
//		comunidadeDAO.inserirComunidade(comunidade1);
//		
//		Foto fotoIncidente = new Foto(null, null); //Idem fotoComunidade, tenho que ver como implementar Lista de fotos, por isso Incidente está como null em foto
//		fotoDAO.inserirFoto(fotoIncidente);
//		
//		Incidente incidente1 = new Incidente("Alagamento na Beira Rio", "Beira Rio em baixo d'água", LocalDateTime.now(), Categoria.ALAGAMENTO, comunidade1, usuario1, localidade1, Situacao.ATIVO, null);
//		incidenteDAO.inserirIncidente(incidente1);
//		
//		Comentario comentario1Incidente1 = new Comentario("A água já está baixando", LocalDateTime.now(), usuario1, incidente1);
//		comentarioDAO.inserirComentario(comentario1Incidente1);
//		
//		Resposta respostaComentario1Incidente1 = new Resposta("A água na verdade está mais alta que antes", LocalDateTime.now(), usuario1, comentario1Incidente1);
//		respostaDAO.inserirResposta(respostaComentario1Incidente1);
//		
	}

}
