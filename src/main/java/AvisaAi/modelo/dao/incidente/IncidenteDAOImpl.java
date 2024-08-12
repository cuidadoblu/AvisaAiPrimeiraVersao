package AvisaAi.modelo.dao.incidente;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.enumeracao.categoria.Categoria;
import AvisaAi.modelo.enumeracao.situacao.Situacao;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class IncidenteDAOImpl implements IncidenteDAO{
	
	private ConexaoFactory fabrica;
	
	public IncidenteDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirIncidente(Incidente incidente) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(incidente);
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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
	
	public void deletarIncidente(Incidente incidente) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.remove(incidente);
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		} finally {
			
			if (sessao != null) {
				sessao.clear();
			}
		}
		
	}
	
	public void atualizarIncidente(Incidente incidente) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.update(incidente);
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

	public Incidente consultarIncidenteComunidade(Comunidade comunidade) {
		
		Session sessao = null;
		Incidente incidente = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			Join<Incidente, Comunidade> juncaoComunidade = raizIncidente.join(Incidente_.comunidade);
			
			ParameterExpression<Long> idComunidade = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoComunidade.get(Comunidade_.id_comunidade), idComunidade));
			
			incidente = sessao.createQuery(criteria).setParameter(idComunidade, incidente.getId()).getSingleResult();
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

	public Incidente consultarIncidenteCategoria(Categoria categoria) {
		//CORRIGIR PARA ACEITAR CATEGORIA, VERIFICAR COMO O WHERE VAI IDENTIFICAR O ENUM
		Session sessao = null;
		Incidente incidente = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			Join<Incidente, Categoria> juncaoCategoria = raizIncidente.join(Incidente_.categoria);
			
			ParameterExpression<Categoria> categoriaIncidente = construtor.parameter(Categoria.class);
//			criteria.where(construtor.equal(juncaoCategoria.get(Categoria_.categoria), categoriaIncidente));
			
//			incidente = sessao.createQuery(criteria).setParameter(categoriaIncidente, categoria.getCategoria);
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

	public Incidente consultarIncidenteUsuarioPorData(Usuario usuario) {
		//FAZER POR DATA
		Session sessao = null;
		Incidente incidente = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			Join<Incidente, Usuario> juncaoUsuario = raizIncidente.join(Incidente_.usuario);
			
			ParameterExpression<Long> idUsuario = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoUsuario.get(Usuario_.id), idUsuario));
			
			incidente = sessao.createQuery(criteria).setParameter(idUsuario, usuario.getId()).getSingleResult();
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

	public Incidente consultarIncidenteLogradouroPorData(Localidade localidade) {
//FAZER POR DATA
		Session sessao = null;
		Incidente incidente = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			Join<Incidente, Localidade> juncaoLocalidade = raizIncidente.join(Incidente_.localidade);
			
			ParameterExpression<String> logradouroLocalidade = construtor.parameter(String.class);
			criteria.where(construtor.equal(juncaoLocalidade.get(Localidade_.logradouro), logradouroLocalidade));
			
			incidente = sessao.createQuery(criteria).setParameter(logradouroLocalidade, localidade.getLogradouro()).getSingleResult();
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

	public Incidente consultarIncidenteSituacao(Situacao situacao) {
		
		Session sessao = null;
		Incidente incidente = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			Join<Incidente, Situacao> juncaoSituacao = raizIncidente.join(Incidente_.situacao);
			
			ParameterExpression<Situacao> situacaoIncidente = construtor.parameter(Situacao.class);
//			criteria.where(construtor.equal(juncaoSituacao.get(Situacao_.situacao), situacaoIncidente));
			
//			incidente = sessao.createQuery(criteria).setParameter(situacaoIncidente, situacao.getSituacao);
			
			sessao.getTransaction().commit();
			
		} catch(Exception sqlException) {
			
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

}
