package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Impiegato;

public class ImpiegatoDaoJdbcImpl implements ImpiegatoDao {

	public void inserisci(Impiegato i) {
	    Connection dbConnection = null;
	    PreparedStatement cmd = null;

	    try {
	        String driver = "com.mysql.jdbc.Driver";
	        Class.forName(driver);

	        // Creiamo la stringa di connessione
	        String url = "jdbc:mysql://localhost:3307/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	        // Otteniamo una connessione con username e password
	        dbConnection = DriverManager.getConnection(url, "Luigi", "Buono");

	        String updateTableSQL = "INSERT INTO impiegato(matricola, nome, cognome, codicefiscale) VALUES(?, ?, ?, ?)";

	        cmd = dbConnection.prepareStatement(updateTableSQL);
	        cmd.setInt(1, i.getMatricola());
	        cmd.setString(2, i.getNome());
	        cmd.setString(3, i.getCognome());
	        cmd.setString(4, i.getCodiceFiscale());
	        // execute update SQL statement
	        cmd.executeUpdate();

	        System.out.println("Record is inserted into impiegato table!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (cmd != null) {
	            try {
	                cmd.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        if (dbConnection != null) {
	            try {
	                dbConnection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	@Override
	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
		Impiegato imp = null;
		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");

			int idc = 1;

			String qry = "SELECT * FROM impiegato WHERE codicefiscale= ?  ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setString(1, codiceFiscale);

			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			if (esiste) {
				imp = new Impiegato();
				imp.setCodiceFiscale(codiceFiscale);
				imp.setCognome(res.getString("cognome"));
				imp.setNome(res.getString("nome"));
				imp.setMatricola(res.getInt("matricola"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}

		return imp;
	}

	@Override
	public boolean aggiorna(Impiegato imp2) {
		Impiegato res = ricercaPerCodiceFiscale(imp2.getCodiceFiscale());
		
		if(res != null)
		{
			
			try {

				// QUERY
				// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
				String driver = "com.mysql.jdbc.Driver";

				Class.forName(driver);

				// Creiamo la stringa di connessione
				String url = "jdbc:mysql://localhost:3307/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

				// Otteniamo una connessione con username e password
				Connection con = DriverManager.getConnection(url, "Luigi", "Buono");

				int idc = 1;

				String qry = "update  impiegato set matricola =?, nome=?, cognome=? WHERE codicefiscale= ?  ";

				// Creiamo un oggetto PrepareStatement per poter interrogare il db
				PreparedStatement cmd = con.prepareStatement(qry);

				cmd.setInt(1, imp2.getMatricola());
				cmd.setString(2, imp2.getNome());
				cmd.setString(3, imp2.getCognome());
				cmd.setString(4, imp2.getCodiceFiscale());

				cmd.execute();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("sdgfsda");

				e.printStackTrace();
			}
			
			
			return true;
		}
		
		return false;

	}

	@Override
	public boolean elimina(String codiceFiscale) {
	Impiegato res = ricercaPerCodiceFiscale(codiceFiscale);
		
		if(res != null)
		{
			
			try {

				// QUERY
				// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
				String driver = "com.mysql.jdbc.Driver";

				Class.forName(driver);

				// Creiamo la stringa di connessione
				String url = "jdbc:mysql://localhost:3306/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

				// Otteniamo una connessione con username e password
				Connection con = DriverManager.getConnection(url, "root", "1234");

				int idc = 1;

				String qry = "delete from impiegato WHERE codicefiscale= ?  ";

				// Creiamo un oggetto PrepareStatement per poter interrogare il db
				PreparedStatement cmd = con.prepareStatement(qry);

				cmd.setString(1, codiceFiscale);
				
				cmd.execute();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println("sdgfsda");

				e.printStackTrace();
			}
			
			
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ImpiegatoDao impDao = new ImpiegatoDaoJdbcImpl();

		Impiegato imp = new Impiegato();
		imp.setCodiceFiscale("ggg");
		imp.setCognome("Pagano");
		imp.setNome("Antonio");
		// imp.setMatricola(124);

		//impDao.inserisci(imp);
		

//		Impiegato imp3 = new Impiegato();
//		imp3.setCodiceFiscale("ggg");
//		imp3.setCognome("Rossi");
//		imp3.setNome("Mario");
//		imp3.setMatricola(124);
//		
//		boolean risultato = impDao.aggiorna(imp3);
//		System.out.println(risultato);
		
		
		impDao.elimina("ggg");
		Impiegato res = impDao.ricercaPerCodiceFiscale("ggg");

		if (res != null)
			System.out.println("impiegato trovato:" + res.getCognome());
		else
			System.out.println("impiegato non trovato");
	

	}

}
