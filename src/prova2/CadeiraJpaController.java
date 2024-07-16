/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import prova2.entities.Cadeira;
import prova2.exceptions.NonexistentEntityException;

/**
 *
 * @author aluno
 */
public class CadeiraJpaController implements Serializable {

    public CadeiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cadeira cadeira) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cadeira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cadeira cadeira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cadeira = em.merge(cadeira);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cadeira.getId();
                if (findCadeira(id) == null) {
                    throw new NonexistentEntityException("The cadeira with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cadeira cadeira;
            try {
                cadeira = em.getReference(Cadeira.class, id);
                cadeira.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cadeira with id " + id + " no longer exists.", enfe);
            }
            em.remove(cadeira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cadeira> findCadeiraEntities() {
        return findCadeiraEntities(true, -1, -1);
    }

    public List<Cadeira> findCadeiraEntities(int maxResults, int firstResult) {
        return findCadeiraEntities(false, maxResults, firstResult);
    }

    private List<Cadeira> findCadeiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cadeira.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cadeira findCadeira(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cadeira.class, id);
        } finally {
            em.close();
        }
    }

    public int getCadeiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cadeira> rt = cq.from(Cadeira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
