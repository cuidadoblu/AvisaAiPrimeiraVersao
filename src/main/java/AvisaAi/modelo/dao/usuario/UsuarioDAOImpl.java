package AvisaAi.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private final ConexaoFactory conexaoFactory;
	
	public UsuarioDAOImpl() {
		this.conexaoFactory = new ConexaoFactory();
	}

	@Override
	public void inserirUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	@Override
	public void deletarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.remove(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(usuario);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	@Override
	public List<Usuario> recuperarUsuarios() {
		Session sessao = null;
		List<Usuario> usuarios = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario);

			usuarios = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
		return usuarios;
	}
}
