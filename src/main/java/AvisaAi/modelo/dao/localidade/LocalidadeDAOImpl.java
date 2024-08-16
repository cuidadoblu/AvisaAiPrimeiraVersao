package AvisaAi.modelo.dao.localidade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import AvisaAi.modelo.entidade.localidade.Localidade;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;


public class LocalidadeDAOImpl implements LocalidadeDAO {
	
	private final ConexaoFactory conexaoFactory;

	public LocalidadeDAOImpl() {
		this.conexaoFactory = new ConexaoFactory();
	}

	@Override
	public void inserirLocalidade(Localidade localidade) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(localidade);

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
	public void deletarLocalidade(Localidade localidade) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.remove(localidade);

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
    public List<Localidade> consultarLocalidadePorBairro(String bairro) {
        EntityManager entityManager = conexaoFactory.getConexao().createEntityManager();
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Localidade> query = criteriaBuilder.createQuery(Localidade.class);
        Root<Localidade> root = query.from(Localidade.class);
        
        query.select(root).where(
            criteriaBuilder.and(
//                criteriaBuilder.equal(root.get(Localidade_.bairro))
            )
        );
        
        List<Localidade> localidades = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return localidades;
    }
    
    @Override
    public List<Localidade> consultarLocalidadePorCidade(String cidade) {
        EntityManager entityManager = conexaoFactory.getConexao().createEntityManager();
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Localidade> query = criteriaBuilder.createQuery(Localidade.class);
        Root<Localidade> root = query.from(Localidade.class);
        
        query.select(root).where(
            criteriaBuilder.and(
//                criteriaBuilder.equal(root.get(Localidade_.cidade))
            )
        );
        
        List<Localidade> localidades = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return localidades;
    }
    
    @Override
    public List<Localidade> consultarLocalidadePorLogradouro(String logradouro) {
        EntityManager entityManager = conexaoFactory.getConexao().createEntityManager();
        
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        
        CriteriaQuery<Localidade> query = criteriaBuilder.createQuery(Localidade.class);
        Root<Localidade> root = query.from(Localidade.class);
        
        query.select(root).where(
            criteriaBuilder.and(
//                criteriaBuilder.equal(root.get(Localidade_.logradouro))
            )
        );
        
        List<Localidade> localidades = entityManager.createQuery(query).getResultList();
        entityManager.close();
        return localidades;
    }

	@Override
	public void atualizarLocalidade(Localidade localidade) {
		Session sessao = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(localidade);

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
	public List<Localidade> recuperarLocalidades() {
		Session sessao = null;
		List<Localidade> localidades = null;

		try {

			sessao = conexaoFactory.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Localidade> criteria = construtor.createQuery(Localidade.class);
			Root<Localidade> raizLocalidade = criteria.from(Localidade.class);

			criteria.select(raizLocalidade);

			localidades = sessao.createQuery(criteria).getResultList();

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

		return localidades;
	}
}
