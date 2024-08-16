package AvisaAi.modelo.dao.incidente;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
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

	public List<Incidente> consultarIncidenteComunidade(Comunidade comunidade) {
//		Gerar metadados e consertar
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
//			Join<Incidente, Comunidade> juncaoComunidade = raizIncidente.join(Incidente_.comunidade);
//			
//			ParameterExpression<Long> idComunidade = construtor.parameter(Long.class);
//			criteria.where(construtor.equal(juncaoComunidade.get(Comunidade_.id), idComunidade));
			
//			incidentes = sessao.createQuery(criteria).setParameter(idComunidade, comunidade.getId()).getResultList();
			
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

	public List<Incidente> consultarIncidenteCategoria(Categoria categoria) {
		//Gerar metadados e posteriormente consertar aqui com o resultado
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
//			Join<Incidente, Categoria> juncaoCategoria = raizIncidente.join(Incidente_.categoria);
			
			ParameterExpression<Categoria> categoriaIncidente = construtor.parameter(Categoria.class);
//			criteria.where(construtor.equal(juncaoCategoria.get(Categoria_.?), categoriaIncidente));
			
//			incidente = sessao.createQuery(criteria).setParameter(categoriaIncidente, categoria.?).getResultList();
			
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

	public List<Incidente> consultarIncidenteUsuarioPorData(Usuario usuario, Incidente incidente) {
//		Gerar metadados e consertar
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
//			Join<Incidente, Usuario> juncaoUsuario = raizIncidente.join(Incidente_.usuario);
//			
//			Predicate predicadoIdUsuario = construtor.equal(juncaoUsuario.get(Usuario_.id));
//			
//			Predicate predicadoDataHoraIncidente = construtor.equal(raizIncidente.get(Incidente_.dataHora));
			
//			Predicate predicadoResultado = construtor.and(predicadoIdUsuario, predicadoDataHoraIncidente);
//			criteria.where(predicadoResultado);
			
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

	public List<Incidente> consultarIncidenteLogradouroPorData(Localidade localidade, Incidente incidente) {
//		Gerar metadados e consertar
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
//			Join<Incidente, Localidade> juncaoLocalidade = raizIncidente.join(Incidente_.localidade);
//			
//			Predicate predicadoLogradouroLocalidade = construtor.equal(juncaoLocalidade.get(Localidade_.logradouro));
//			
//			Predicate predicadoDataHoraIncidente = construtor.equal(raizIncidente.get(Incidente_.dataHora));
			
//			Predicate predicadoResultado = construtor.equal(predicadoLogradouroLocalidade, predicadoDataHoraIncidente);
//			criteria.where(predicadoResultado);
			
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

	public List<Incidente> consultarIncidenteSituacao(Situacao situacao) {
		
		Session sessao = null;
		List<Incidente> incidentes = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Incidente> criteria = construtor.createQuery(Incidente.class);
			Root<Incidente> raizIncidente = criteria.from(Incidente.class);
			
			criteria.select(raizIncidente);
			
//			Join<Incidente, Situacao> juncaoSituacao = raizIncidente.join(Incidente_.situacao);
			
			ParameterExpression<Situacao> situacaoIncidente = construtor.parameter(Situacao.class);
//			criteria.where(construtor.equal(juncaoSituacao.get(Situacao_.?), situacaoIncidente));
//			
//			incidentes = sessao.createQuery(criteria).setParameter(situacaoIncidente, situacao.?).getResultList();
			
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
