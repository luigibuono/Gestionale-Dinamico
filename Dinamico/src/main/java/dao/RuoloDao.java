package dao;

import model.Ruolo;

public interface RuoloDao {

	public Ruolo ricercaPerId(int Id);
	public void inserisci(Ruolo i);
	public boolean aggiorna(Ruolo r2);
	public boolean elimina(int idRuolo);
	
	
}

