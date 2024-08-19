package AvisaAi.modelo.dao.foto;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import AvisaAi.modelo.entidade.foto.Foto;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class FotoDAOImpl implements FotoDAO {
	
		private final SessionFactory fabrica = ConexaoFactory.getConexao();
	    
	    public void inserirFoto(Foto foto) {
	    	
	        Session sessao = null;
	        
	        try {
	        	
	        	sessao = fabrica.openSession();
	            sessao.beginTransaction();
	            
	            sessao.save(foto);
	            
	            sessao.getTransaction().commit();
	            
	        } catch (Exception sqlException) {
	        	
	            if (sessao.getTransaction() != null) {
	                sessao.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	            
	        } finally {
	        	
	            if (sessao != null) {
	                sessao.close();
	            }
	        }
	    }

	    public void deletarFoto(Foto foto) {
	    	
	        Session sessao = null;
	        
	        try {
	        	
	        	sessao = fabrica.openSession();
	            sessao.beginTransaction();
	            
	            sessao.remove(foto);
	            
	            sessao.getTransaction().commit();
	            
	        } catch (Exception sqlException) {
	        	
	            if (sessao.getTransaction() != null) {
	                sessao.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	            
	        } finally {
	        	
	            if (sessao != null) {
	                sessao.close();
	            }
	        }
	    }

	    public void atualizarFoto(Foto foto) {
	    	
	        Session sessao = null;
	        
	        try {
	        	
	        	sessao = fabrica.openSession();
	            sessao.beginTransaction();
	            
	            sessao.update(foto);
	            
	            sessao.getTransaction().commit();
	            
	        } catch (Exception sqlException) {
	        	
	            if (sessao.getTransaction() != null) {
	                sessao.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	            
	        } finally {
	        	
	            if (sessao != null) {
	                sessao.close();
	            }
	        }
	    }

	    public List<Foto> recuperarFotos() {
	    	
	        Session sessao = null;
	        List<Foto> fotos = null;
	        
	        try {
	        	
	        	sessao = fabrica.openSession();
	            sessao.beginTransaction();
	            
	            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	            CriteriaQuery<Foto> criteria = construtor.createQuery(Foto.class);
	            
	            Root<Foto> raizFoto = criteria.from(Foto.class);
	            criteria.select(raizFoto);
	            
	            fotos = sessao.createQuery(criteria).getResultList();
	            sessao.getTransaction().commit();
	            
	        } catch (Exception sqlException) {
	        	
	            if (sessao.getTransaction() != null) {
	                sessao.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	            
	        } finally {
	        	
	            if (sessao != null) {
	                sessao.close();
	            }
	        }
	        
	        return fotos;
	    }

	    public Foto consultarFotoId(Long id) {
	    	
	        Session sessao = null;
	        Foto foto = null;
	        
	        try {
	        	
	            sessao = fabrica.openSession();
	            sessao.beginTransaction();
	            foto = sessao.get(Foto.class, id);
	            sessao.getTransaction().commit();
	            
	        } catch (Exception sqlException) {
	        	
	            if (sessao.getTransaction() != null) {
	                sessao.getTransaction().rollback();
	            }
	            sqlException.printStackTrace();
	            
	        } finally {
	        	
	            if (sessao != null) {
	                sessao.close();
	            }
	        }
	        
	        return foto;
	    }
}