package dao;

import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpiegatoDaoImpl implements ImpiegatoDao {

    private List<Impiegato> listaImpiegato = new ArrayList<>();

    @Override
    public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
        for (Impiegato imp : listaImpiegato) {
            if (imp.getCodiceFiscale().equals(codiceFiscale)) {
                return imp;
            }
        }
        return null;
    }

    @Override
    public void inserisci(Impiegato i) {
        listaImpiegato.add(i);
    }

    @Override
    public boolean aggiorna(Impiegato imp2) {
        for (int y = 0; y < listaImpiegato.size(); y++) {
            Impiegato imp = listaImpiegato.get(y);
            if (imp.getCodiceFiscale().equals(imp2.getCodiceFiscale())) {
                imp.setCognome(imp2.getCognome());
                imp.setNome(imp2.getNome());
                imp.setMatricola(imp2.getMatricola());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean elimina(String codiceFiscale) {
        for (int i = 0; i < listaImpiegato.size(); i++) {
            Impiegato imp = listaImpiegato.get(i);
            if (imp.getCodiceFiscale().equals(codiceFiscale)) {
                listaImpiegato.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ImpiegatoDao impDao = new ImpiegatoDaoImpl();
        Impiegato imp = new Impiegato();
        imp.setCodiceFiscale("BNUL");
        imp.setNome("Luigi");
        imp.setCognome("Buono");
        imp.setMatricola(1234);

        impDao.inserisci(imp);

        Impiegato imp3 = new Impiegato();
        imp3.setCodiceFiscale("BNUL");
        imp3.setNome("Luigi");
        imp3.setCognome("Rossi");
        imp3.setMatricola(1234);

        impDao.aggiorna(imp3);

        Impiegato res = impDao.ricercaPerCodiceFiscale("BNUL");
        if (res != null)
            System.out.println("Impiegato trovato: " + res.getCognome());
        else
            System.out.println("Impiegato non trovato");
    }
}
