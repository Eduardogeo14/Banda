package br.edu.ifrs.banda;

import br.edu.ifrs.banda.dominio.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("banda-pu");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Banda banda = new Banda("Metalica", GeneroEnum.METAL);
		
		
		Integrante james = new Integrante("James Hetfield");
        Integrante lars = new Integrante("Lars Ulrich");
        
        banda.adicionarIntegrante(lars);
        banda.adicionarIntegrante(james);
        
        Album album = new Album("Master of Puppets", 1986);
        
        Musica m1 = new Musica("Master of Puppets", 480);
        Musica m2 = new Musica("Sanitarium", 400);
        
        banda.adicionarAlbum(album);
        album.adicionarMusica(m1);
        album.adicionarMusica(m2);
        
        em.persist(banda);
        em.persist(james);
        em.persist(lars);
        em.persist(album);
        em.persist(m1);
        em.persist(m2);
        
        
        em.getTransaction().commit();
        System.out.println("Dados persistidos com sucesso");
        
        
        System.out.println("Banda: " + banda.getNome());
        
        em.close();
        emf.close();

	}

}
