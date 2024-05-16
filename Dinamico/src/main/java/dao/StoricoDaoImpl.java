package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Storico;

public class StoricoDaoImpl implements StoricoDao{

private List<Storico> listaStorici = new ArrayList<>();
	
@Override
	public Storico ricercaPerId(int id) {
		for(int i = 0; i< listaStorici.size(); i++) {
			Storico s = listaStorici.get(i);
			if (s.getIdStorico() == id) {
				return s;
			}
		}
		return null;
	}
	
@Override
	public void inserisci(Storico i) {
		listaStorici.add(i);
	}
	
@Override
	public boolean aggiorna(Storico s2) {
		for (int y = 0; y < listaStorici.size(); y++) {
            Storico s = listaStorici.get(y);
            if (s.getIdStorico() == (s2.getIdStorico())) {
                s.setDataInizio(s2.getDataInizio());
                s.setDataFine(s2.getDataFine());
                s.setIdRuolo(s2.getIdRuolo());
                s.setMatricola(s2.getMatricola());
                
                return true;
            }
        }
        return false;
	}
	@Override
	public boolean elimina(int idStorico) {
		for (int i = 0; i < listaStorici.size(); i++) {
            Storico s = listaStorici.get(i);
            if (s.getIdStorico() == idStorico) {
                listaStorici.remove(i);
                return true;
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		StoricoDao rDao= new StoricoDaoImpl();
		Storico s = new Storico();
		s.setDataInizio(new Date());
		s.setDataFine(new Date());
		s.setMatricola(22);
		s.setIdRuolo(4);
		s.setIdStorico(5);
		
		rDao.inserisci(s);
		
		Storico s1 = new Storico();
		s1.setDataInizio(new Date());
		s1.setDataFine(new Date());
		s1.setMatricola(2131);
		s1.setIdRuolo(3);
		rDao.aggiorna(s1);
		
		rDao.elimina(1);
		Storico g = rDao.ricercaPerId(1);
		if(g != null) 
			System.out.println("trovato" + g.getMatricola());
		else 
			System.out.println("non trovato");
		
		
	}
}
