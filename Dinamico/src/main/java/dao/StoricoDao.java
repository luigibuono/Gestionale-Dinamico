package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Storico;

public interface StoricoDao {

	public Storico ricercaPerId(int id);
	public void inserisci(Storico i);
	public boolean aggiorna(Storico s2);
	public boolean elimina (int idStorico);
}
