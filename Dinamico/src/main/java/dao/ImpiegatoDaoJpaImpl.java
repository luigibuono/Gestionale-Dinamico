package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modeljpa.Impiegato;



public class ImpiegatoDaoJpaImpl  {

	EntityManagerFactory emf;
	EntityManager em;

	public ImpiegatoDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("Hib4PU");
		em = emf.createEntityManager();

	}


	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
		Query q1 = em.createQuery("from Impiegato c where c.codicefiscale = :codicefiscale");
		q1.setParameter("codicefiscale", codiceFiscale);
		Impiegato res = (Impiegato) q1.getSingleResult();

		return res;
	}


	public List<Impiegato> ricercaPerCognome(String cognome) {
		Query q1 = em.createQuery("from Impiegato c where c.cognome = :cognome");
		q1.setParameter("cognome", cognome);
		List<Impiegato> res = q1.getResultList();

		return res;
	}


	public void inserisci(Impiegato i) {
		em.getTransaction().begin();

		em.persist(i);

		em.getTransaction().commit();
	}


	public boolean aggiorna(Impiegato imp2) {
		em.getTransaction().begin();

		em.merge(imp2);

		em.getTransaction().commit();
		return true;
	}


	public boolean elimina(int matricola) {
		em.getTransaction().begin();

		Impiegato u = em.find(Impiegato.class, matricola);
		em.remove(u);

		em.getTransaction().commit();
		return true;
	}

}
