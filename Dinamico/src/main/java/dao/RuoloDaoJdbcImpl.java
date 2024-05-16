package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Ruolo;

public class RuoloDaoJdbcImpl implements RuoloDao {

	@Override
	public Ruolo ricercaPerId(int id) {
		Ruolo r = null;
		try {

			// QUERY
			// Carichiamo un driver di tipo 1 (bridge jdbc-odbc)
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
			int idc = 1;

			String qry = "SELECT * FROM ruolo WHERE id= ?  ";

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
				r = new Ruolo();
				r.setIdRuolo(id);
				r.setDescrizione(res.getString("descrizione"));

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("sdgfsda");

			e.printStackTrace();
		}

		return r;

	}

	@Override
	public void inserisci(Ruolo i) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
			String updateTableSQL = "INSERT INTO ruolo(id, descrizione) VALUES(?,?)";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1, i.getIdRuolo());
			cmd.setString(2, i.getDescrizione());

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

	}

	@Override
	public boolean aggiorna(Ruolo r2) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/Gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
			String updateTableSQL = "update ruolo set descrizione = ? where id = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setString(1, r2.getDescrizione());
			cmd.setInt(2, r2.getIdRuolo());

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
	public boolean elimina(int idRuolo) {

		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;

		try {
			String driver = "com.mysql.jdbc.Driver";

			Class.forName(driver);

			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3307/gestionale?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

			// Otteniamo una connessione con username e password
			Connection con = DriverManager.getConnection(url, "Luigi", "Buono");
			String updateTableSQL = "delete from ruolo  where id = ?";

			cmd = dbConnection.prepareStatement(updateTableSQL);

			cmd.setInt(1,idRuolo);
			

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
		RuoloDao rDao = new RuoloDaoJdbcImpl();

//		Ruolo r = new Ruolo();
//		r.setDescrizione("prova DUEEEEE");
//		r.setIdRuolo(1);

		rDao.elimina(1);

		Ruolo g = rDao.ricercaPerId(1);
		if (g != null)
			System.out.println("ruolo trovato: " + g.getDescrizione());
		else
			System.out.println("ruolo non trovato");

	}
}
