package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modeljpa.Impiegato;
import modeljpa.Ruolo;

public class RuoloDaoJpaImpl {
	EntityManagerFactory emf ;
	EntityManager em;
	
	public RuoloDaoJpaImpl() {
		 emf = Persistence.createEntityManagerFactory("Hib4PU");
		 em = emf.createEntityManager();

	}
	

	public Ruolo ricercaPerId(int id) {
		em.getTransaction().begin();
		
		Ruolo u = em.find(Ruolo.class, id);
	
		
		em.getTransaction().commit();
		return u;
	}


	public void inserisci(Ruolo i) {
		em.getTransaction().begin();

		em.persist(i);

		em.getTransaction().commit();
		
	}


	public boolean aggiorna(Ruolo r2) {
		em.getTransaction().begin();

		em.merge(r2);

		em.getTransaction().commit();
		return true;
	}


	public boolean elimina(int idRuolo) {
		em.getTransaction().begin();

		Ruolo u = em.find(Ruolo.class, idRuolo);
		em.remove(u);

		em.getTransaction().commit();
		return true;
	}

}
