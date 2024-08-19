package AvisaAi.modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuracao = new Configuration();
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comentario.Comentario.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comentario.resposta.Resposta.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.comunidade.Comunidade.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.incidente.Incidente.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.foto.Foto.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.localidade.Localidade.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.usuario.Usuario.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.usuario.contato.Contato.class);
			configuracao.addAnnotatedClass(AvisaAi.modelo.entidade.usuario.Papel.class);

			configuracao.configure("hibernate.cfg.xml");

			ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();
			sessionFactory = configuracao.buildSessionFactory(servico);
		} catch (Throwable exception) {
			throw new ExceptionInInitializerError(exception);
		}
	}

	public static SessionFactory getConexao() {
		return sessionFactory;
	}
}