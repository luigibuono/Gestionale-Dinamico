package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Ruolo;
import model.Storico;

public class StoricoDaoJdbcImpl implements StoricoDao{

	@Override
	public Storico ricercaPerId(int id) {
		Storico r = null;
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

			String qry = "SELECT * FROM storico WHERE idstorico= ?  ";

			// Creiamo un oggetto PrepareStatement per poter interrogare il db
			PreparedStatement cmd = con.prepareStatement(qry);

			cmd.setInt(1, id);

			// Eseguiamo una query e immagazziniamone i risu3ltati
			// in un oggetto ResultSet
			ResultSet res = cmd.executeQuery();

			boolean esiste = res.next();// ---> la prima riga
			// --> seconda riga

			// Stampiamone i risultati riga per riga

			if (esiste) {
				r = new Storico();
				r.setIdStorico(id);
				r.setIdRuolo(res.getInt("idRuolo"));
				r.setDataFine(res.getDate("datafine"));
				r.setDataInizio(res.getDate("datainizio"));
				r.setMatricola(res.getInt("matricola"));
	
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}

		return r;

	}

	@Override
	public void inserisci(Storico i) {
	    Connection dbConnection = null;
	    java.sql.PreparedStatement cmd = null;

	    try {
	        String driver = "com.mysql.jdbc.Driver";

	        Class.forName(driver);

	        // Creiamo la stringa di connessione
	        String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	        // Otteniamo una connessione con username e password
	        Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
	        String updateTableSQL = "INSERT INTO storico(matricola, datainizio,datafine,idruolo) VALUES(?,?,?,?)";

	        cmd = con.prepareStatement(updateTableSQL);

	        cmd.setInt(1, i.getMatricola());
	        java.sql.Date dateI = new java.sql.Date(i.getDataInizio().getTime());
	        cmd.setDate(2, dateI);
	        java.sql.Date dateF = new java.sql.Date(i.getDataFine().getTime());
	        cmd.setDate(3, dateF);
	        cmd.setInt(4, i.getIdRuolo());
	        // execute update SQL stetement
	        cmd.executeUpdate();

	        System.out.println("Record is updated to DBUSER table!");

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Chiudi le risorse
	        if (cmd != null) {
	            try {
	                cmd.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


	@Override
	public boolean aggiorna(Storico st2) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
			String updateTableSQL = "update storico set matricola=?, datainizio=?,datafine=?,idruolo=? where idstorico =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, st2.getMatricola());
			java.sql.Date dateI = new java.sql.Date(st2.getDataInizio().getTime()); 
			cmd.setDate(2, dateI);
			java.sql.Date dateF = new java.sql.Date(st2.getDataFine().getTime()); 
			cmd.setDate(3, dateF);
			cmd.setInt(4, st2.getIdRuolo());
			cmd.setInt(5, st2.getIdStorico());
			
			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		return true;
	}

	@Override
	public boolean elimina(int id) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "Luigi", "Buono");

			String updateTableSQL = "delete from storico where idstorico =?";

			cmd = dbConnection.prepareStatement(updateTableSQL);


			cmd.setInt(1, id);
			
			// execute update SQL stetement
			cmd.executeUpdate();

			System.out.println("Record is updated to DBUSER table!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		return true;
	}
	public static void main(String[] args) {
		
		StoricoDao stDao = new StoricoDaoJdbcImpl();
		
//		Storico s = new Storico();
//		s.setDataFine(new Date());
//		s.setDataInizio(new Date());
//		s.setIdRuolo(1);
//		s.setIdStorico(1);
//		s.setMatricola(1);
//		
//		stDao.inserisci(s);
	
		Storico s1 = new Storico();
		s1.setDataFine(new Date());
		s1.setDataInizio(new Date());
		s1.setIdRuolo(1);
		s1.setIdStorico(4);
		s1.setMatricola(1);
		
//		stDao.aggiorna(s1);
//		
		stDao.elimina(4);
//		
		Storico res = stDao.ricercaPerId(5);

		if (res != null)
			System.out.println("storico trovato:" + res.getMatricola());
		else
			System.out.println("storico non trovato");
	}
}
