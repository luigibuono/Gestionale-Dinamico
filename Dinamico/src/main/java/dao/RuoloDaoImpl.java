package dao;

import java.util.ArrayList;
import java.util.List;

import model.Ruolo;


public class RuoloDaoImpl implements RuoloDao{
	
private List<Ruolo> listaRuoli = new ArrayList<>();
	
	@Override
	public Ruolo ricercaPerId(int id) {
		for(int i = 0; i< listaRuoli.size(); i++) {
			Ruolo r = listaRuoli.get(i);
			if (r.getIdRuolo() == id) {
				return r;
			}
		}
		return null;
	}
	
	@Override
	public void inserisci(Ruolo i) {
		listaRuoli.add(i);
	}
	
	@Override
	public boolean aggiorna(Ruolo r2) {
		for (int y = 0; y < listaRuoli.size(); y++) {
            Ruolo r = listaRuoli.get(y);
            if (r.getIdRuolo() == (r2.getIdRuolo())) {
                r.setDescrizione(r2.getDescrizione());
                return true;
            }
        }
        return false;
	}
	
	@Override
	public boolean elimina(int idRuolo) {
		for (int i = 0; i < listaRuoli.size(); i++) {
            Ruolo r = listaRuoli.get(i);
            if (r.getIdRuolo() == idRuolo) {
                listaRuoli.remove(i);
                return true;
            }
        }
        return false;
	}
	
	
	public static void main(String[] args) {
		RuoloDao rDao= new RuoloDaoImpl();
		Ruolo r = new Ruolo();
		r.setDescrizione("prova");
		r.setIdRuolo(1);
		
		rDao.inserisci(r);
		
		Ruolo r1 = new Ruolo();
		r1.setDescrizione("prova2");
		r1.setIdRuolo(3);
		rDao.aggiorna(r1);
		
		rDao.elimina(1);
		Ruolo g = rDao.ricercaPerId(1);
		if(g != null) 
			System.out.println("trovato" + g.getDescrizione());
		else 
			System.out.println("non trovato");		
	}


}
