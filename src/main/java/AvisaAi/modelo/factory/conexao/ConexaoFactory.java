package AvisaAi.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import AvisaAi.modelo.entidade.foto.Foto;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.entidade.usuario.contato.Contato;

public class ConexaoFactory {
	
	public SessionFactory getConexao() {
		
		Configuration configuracao = new Configuration();
		
		configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comentario.Comentario.class);
		configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comentario.resposta.Resposta.class);
		configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comunidade.Comunidade.class);
		configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.incidente.Incidente.class);
		
		configuracao.addAnnotatedClass(Foto.class);
		configuracao.addAnnotatedClass(Localidade.class);
		configuracao.addAnnotatedClass(Usuario.class);
		configuracao.addAnnotatedClass(Contato.class);
		
		configuracao.configure("hibernate.cfg.xml");
		
		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
		
		return fabricaSessao;
	}

}
