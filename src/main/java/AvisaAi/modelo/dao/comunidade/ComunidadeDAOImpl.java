package AvisaAi.modelo.dao.comunidade;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import AvisaAi.modelo.entidade.comunidade.Comunidade;
import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class ComunidadeDAOImpl implements ComunidadeDAO {
	
	private ConexaoFactory fabrica;
	
	public ComunidadeDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirComunidade(Comunidade comunidade) {
	
		Session sessao  = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.save(comunidade);
			
			sessao.getTransaction().commit();
			
		}	catch (Exception sqlException){
			
			sqlException.printStackTrace();
			
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		}	finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	
	}
	
	public void deletarComunidade(Comunidade comunidade) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.remove(comunidade);
			
			sessao.getTransaction().commit();
			
		}	catch (Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		}	finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarComunidade(Comunidade comunidade) {
		
		Session sessao = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			sessao.update(comunidade);
			
			sessao.getTransaction().commit();
			
		}	catch (Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		}	finally {
			if (sessao != null) {
				sessao.close();
			}
		}
	}
	
	public List<Comunidade> recuperarComunidades() {
		
		Session sessao = null;
		List<Comunidade> comunidades = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();		
			
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);
			
			criteria.select(raizComunidade);
			
			comunidades = sessao.createQuery(criteria).getResultList();
			
			sessao.getTransaction().commit();
			
		}	catch(Exception sqlException) {
			
				sqlException.printStackTrace();
				
				if (sessao.getTransaction() != null) {
					sessao.getTransaction().rollback();
				}
				
		}	finally {
			
			if (sessao != null) {
				sessao.close();
			}
		}
		
		return comunidades;
	}
	
	public Comunidade consultarComunidadeBairro(Localidade localidade) {
		
		Session sessao = null;
		Comunidade comunidade = null;
		
		try {
			
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();
			
			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			
			CriteriaQuery<Comunidade> criteria = construtor.createQuery(Comunidade.class);
			Root<Comunidade> raizComunidade = criteria.from(Comunidade.class);
			
//			Join<Comunidade, Localidade> juncaoLocalidade = raizComunidade.join(Comunidade_.localidade);
			
			ParameterExpression<String> bairro = construtor.parameter(String.class);
//			criteria.where(construtor.equal(juncaoLocalidade.get(Localidade_.bairro), bairro));
			
			comunidade = sessao.createQuery(criteria).setParameter(bairro, localidade.getBairro()).getSingleResult();
			
			sessao.getTransaction().commit();
			
		}	catch (Exception sqlException) {
			
			sqlException.printStackTrace();
			
			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}
			
		}	finally {
			if (sessao != null) {
				sessao.close();
			}
		}
		return comunidade;
	}
}
