package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImpiegatoDaoJpaImpl;
import dao.StoricoDaoJpaImpl;
import modeljpa.Impiegato;
import modeljpa.Storico;

/**
 * Servlet implementation class ImpiegatoSrv
 */
@WebServlet("/ImpiegatoSrv")
public class ImpiegatoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
// si puo anche usare questa annotazione qua	
//	 @PersistenceContext(unitName = "Hib4PU")
//	    private EntityManager em;
	 

	/**
	 * Default constructor.
	 */
	public ImpiegatoSrv() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ImpiegatoDaoJpaImpl impDao = new ImpiegatoDaoJpaImpl();

		String tipoOp = request.getParameter("tipoOperazione");
		System.out.println("tipoOperazione=" + tipoOp);

		if (tipoOp != null && tipoOp.equals("inserisci")) {
			String cf = request.getParameter("cf");
			String cogn = request.getParameter("cognome");
			String nom = request.getParameter("nome");

			Impiegato imp = new Impiegato();

			imp.setCodicefiscale(cf);
			imp.setCognome(cogn);
			imp.setNome(nom);

			impDao.inserisci(imp);
			request.getRequestDispatcher("/inserimentoImpiegatoOk.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("aggiorna")) {
			String cf = request.getParameter("cf");
			String cogn = request.getParameter("cognome");
			String nom = request.getParameter("nome");
			String matr = request.getParameter("matr");
			int matricola = Integer.parseInt(matr);

			Impiegato imp = new Impiegato();

			imp.setCodicefiscale(cf);
			imp.setCognome(cogn);
			imp.setMatricola(matricola);
			imp.setNome(nom);

			impDao.aggiorna(imp);
			request.getRequestDispatcher("/aggiornaImpiegatoOK.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("elimina")) {
			String cf = request.getParameter("cf");
			String matr = request.getParameter("matr");
			String cognome = request.getParameter("cognome");
			Integer matricola = Integer.parseInt(matr);
			// eliminare eventuali righe su storico
			// che riguardano l impiegato con quel
			// codice fiscale
			StoricoDaoJpaImpl sDao = new StoricoDaoJpaImpl();
			List<Storico> res = sDao.ricercaPerMatricola(matricola);
			if (res != null && res.size() > 0)
				for (Storico storico : res) {
					sDao.elimina(storico.getIdstorico());
				}

			impDao.elimina(matricola);

			// ritorno alla pagina di origine
			List<Impiegato> imp = impDao.ricercaPerCognome(cognome);
			if (imp != null && imp.size() > 0) {
				System.out.println("impiegati trovati:" + imp.size());
				request.getSession().setAttribute("impiegatiTrovati", imp);
				request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognome.jsp").forward(request, response);
			} else
				request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognomeKo.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("ricercaCF")) {
			String cf = request.getParameter("cf");

			Impiegato imp = impDao.ricercaPerCodiceFiscale(cf);
			if (imp != null) {
				System.out.println("impiegato trovato:" + imp.getMatricola());
				request.getSession().setAttribute("impiegatoTrovato", imp);
				request.getRequestDispatcher("/aggiornaImpiegato.jsp").forward(request, response);
			} else
				request.getRequestDispatcher("/ricercaImpiegatoKo.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("ricercaCognome")) {
			String cf = request.getParameter("cognome");

			List<Impiegato> imp = impDao.ricercaPerCognome(cf);
			if (imp != null && imp.size() > 0) {
				System.out.println("impiegati trovati:" + imp.size());
				request.getSession().setAttribute("impiegatiTrovati", imp);
				request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognome.jsp").forward(request, response);
			} else
				request.getRequestDispatcher("/risultatiRicercaImpiegatoPerCognomeKo.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
