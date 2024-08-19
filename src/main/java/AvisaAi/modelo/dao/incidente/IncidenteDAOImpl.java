package AvisaAi.modelo.dao.incidente;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.comunidade.Comunidade_;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.incidente.Incidente_;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.entidade.localidade.Localidade_;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.entidade.usuario.Usuario_;
import AvisaAi.modelo.enumeracao.categoria.Categoria;
import AvisaAi.modelo.enumeracao.situacao.Situacao;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class IncidenteDAOImpl implements IncidenteDAO{
	

	private final SessionFactory fabrica = ConexaoFactory.getConexao();
	
	
	public void inserirIncidente(Incidente incidente) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.openSession();
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
			
			sessao = fabrica.openSession();
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
			
			sessao = fabrica.openSession();
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

	public List<Incidente> consultarIncidentesComunidade(Comunidade comunidade) {
		
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
			Join<Incidente, Comunidade> juncaoComunidade = raizIncidente.join(Incidente_.comunidade);
//			
			ParameterExpression<Long> idComunidade = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoComunidade.get(Comunidade_.id), idComunidade));
			
			incidentes = sessao.createQuery(criteria).setParameter(idComunidade, comunidade.getId()).getResultList();
			
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
		
		return incidentes;
	
	}

	public List<Incidente> consultarIncidentesCategoria(Incidente incidente) {
		
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
			Join<Incidente, Categoria> juncaoCategoria = raizIncidente.join(Incidente_.categoria);
			
			Predicate predicadoCategoriaIncidente = construtor.equal(juncaoCategoria.get(Incidente_.categoria), incidente.getCategoria());
			
			criteria.where(predicadoCategoriaIncidente);
			
			incidentes = sessao.createQuery(criteria).getResultList();
			
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
		
		return incidentes;

	}

	public List<Incidente> consultarIncidentesUsuarioPorData(Usuario usuario, Incidente incidente) {

		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
			Join<Incidente, Usuario> juncaoUsuario = raizIncidente.join(Incidente_.usuario);
			
			Predicate predicadoIdUsuario = construtor.equal(juncaoUsuario.get(Usuario_.id), usuario.getId());
			
			Predicate predicadoDataHoraIncidente = construtor.equal(raizIncidente.get(Incidente_.dataHora), incidente.getDataHora());
			
			Predicate predicadoResultado = construtor.and(predicadoIdUsuario, predicadoDataHoraIncidente);
			criteria.where(predicadoResultado);
			
			incidentes = sessao.createQuery(criteria).getResultList();
			
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
		
		return incidentes;

	}

	public List<Incidente> consultarIncidentesLogradouroPorData(Localidade localidade, Incidente incidente) {
		
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
			Join<Incidente, Localidade> juncaoLocalidade = raizIncidente.join(Incidente_.localidade);
			
			Predicate predicadoLogradouroLocalidade = construtor.equal(juncaoLocalidade.get(Localidade_.logradouro), localidade.getLogradouro());
			
			Predicate predicadoDataHoraIncidente = construtor.equal(raizIncidente.get(Incidente_.dataHora), incidente.getDataHora());
			
			Predicate predicadoResultado = construtor.and(predicadoLogradouroLocalidade, predicadoDataHoraIncidente);
			criteria.where(predicadoResultado);
			
			incidentes = sessao.createQuery(criteria).getResultList();
			
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
		
		return incidentes;
		
	}

	public List<Incidente> consultarIncidentesSituacao(Incidente incidente) {
		
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
			Join<Incidente, Situacao> juncaoSituacao = raizIncidente.join(Incidente_.situacao);
			
			Predicate predicadoSituacaoIncidente = construtor.equal(juncaoSituacao.get(Incidente_.situacao), incidente.getSituacao());
			
			criteria.where(predicadoSituacaoIncidente);
			
			incidentes = sessao.createQuery(criteria).getResultList();
			
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
		
		return incidentes;

	}

}
