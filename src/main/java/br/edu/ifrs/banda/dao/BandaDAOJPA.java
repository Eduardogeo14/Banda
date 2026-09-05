package br.edu.ifrs.banda.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import br.edu.ifrs.banda.dominio.*;
import java.util.List;
public class BandaDAOJPA implements BandaDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("banda-pu");

	public void salvar(Banda banda) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(banda);
		em.getTransaction().commit();
		em.close();
	}
	
	public Banda buscarPorId(Long id) {
		
		EntityManager em = emf.createEntityManager();
		Banda banda = em.find(Banda.class, id);
		em.close();
		return banda;
	}
	
	public List<Banda> listarTodos(){
		EntityManager em = emf.createEntityManager();
		List<Banda> bandas = em.createQuery("From Banda", Banda.class).getResultList();
		em.close();
		return bandas;
		
	}
		
	public void atualizar(Banda banda) {
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(banda);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Banda banda = em.find(Banda.class, id);
		if(banda != null) {
			em.remove(banda);
		}
		em.close();
	}
	
	public List<Banda> listarPorGenero(String genero) {
	    EntityManager em = emf.createEntityManager();
	    
	    TypedQuery<Banda> query = em.createQuery(
	        "SELECT b FROM Banda b WHERE b.genero = :genero", Banda.class);
	    query.setParameter("genero", genero);
	    
	    List<Banda> bandas = query.getResultList();
	    em.close();
	    return bandas;
	}
}
