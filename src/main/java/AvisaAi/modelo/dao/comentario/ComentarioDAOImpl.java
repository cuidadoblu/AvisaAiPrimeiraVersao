package AvisaAi.modelo.dao.comentario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import AvisaAi.modelo.entidade.comentario.Comentario;
import AvisaAi.modelo.entidade.incidente.Incidente;
import AvisaAi.modelo.entidade.usuario.Usuario;
import AvisaAi.modelo.factory.conexao.ConexaoFactory;

public class ComentarioDAOImpl implements ComentarioDAO {

    private ConexaoFactory fabrica;

    public ComentarioDAOImpl() {
        fabrica = new ConexaoFactory();
    }

    public void inserirComentario(Comentario comentario) {
    	
        Session sessao = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            sessao.save(comentario);
            
            sessao.getTransaction().commit();
            
        } catch (Exception sqlException) {
        	
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
        	
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void deletarComentario(Comentario comentario) {
    	
        Session sessao = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            sessao.remove(comentario);
            
            sessao.getTransaction().commit();
            
        } catch (Exception sqlException) {
        	
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
        	
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void atualizarComentario(Comentario comentario) {
    	
        Session sessao = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            sessao.update(comentario);
            
            sessao.getTransaction().commit();
            
        } catch (Exception sqlException) {
        	
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
        	
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public List<Comentario> recuperarComentarios() {
    	
        Session sessao = null;
        List<Comentario> comentarios = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            
            CriteriaQuery<Comentario> criteria = construtor.createQuery(Comentario.class);
            Root<Comentario> raizComentario = criteria.from(Comentario.class);
            
            criteria.select(raizComentario);
            
            comentarios = sessao.createQuery(criteria).getResultList();
            
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
        return comentarios;
    }

    public List<Comentario> consultarComentarioIncidente(Incidente incidente) {
    	
        Session sessao = null;
        List<Comentario> comentarios = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            
            CriteriaQuery<Comentario> criteria = construtor.createQuery(Comentario.class);
            Root<Comentario> raizComentario = criteria.from(Comentario.class);

            Join<Comentario, Incidente> juncaoIncidente = raizComentario.join("incidente");
            criteria.where(construtor.equal(juncaoIncidente.get("id"), incidente.getId()));

            comentarios = sessao.createQuery(criteria).getResultList();
            
            sessao.getTransaction().commit();
            
        } catch (Exception sqlException) {
        	
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
        	
            if (sessao != null) {
                sessao.close();
            }
        }
        return comentarios;
    }
    
    public List<Comentario> consultarComentarioUsuario(Usuario usuario) {
    	

        Session sessao = null;
        List<Comentario> comentarios = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Comentario> criteria = construtor.createQuery(Comentario.class);
            Root<Comentario> raizComentario = criteria.from(Comentario.class);

            Join<Comentario, Usuario> juncaoUsuario = raizComentario.join("id_usuario");
            criteria.where(construtor.equal(juncaoUsuario.get("id"), usuario.getId()));

            comentarios = sessao.createQuery(criteria).getResultList();
            sessao.getTransaction().commit();
            
        } catch (Exception sqlException) {
        	
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }
        } finally {
        	
            if (sessao != null) {
                sessao.close();
            }
        }
        return comentarios;
    }

	public Comentario consultarComentarioId(String id) {
		
		Session sessao = null;
        Comentario comentario = null;
        
        try {
        	
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();
            
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            
            CriteriaQuery<Comentario> criteria = construtor.createQuery(Comentario.class);
            Root<Comentario> raizComentario = criteria.from(Comentario.class);
            
            criteria.select(raizComentario).where(construtor.equal(raizComentario.get("id"), id));
            
            comentario = sessao.createQuery(criteria).getSingleResult();
            
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
        return comentario;
    }
}
