package ctr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RuoloDao;
import dao.RuoloDaoJpaImpl;
import modeljpa.Ruolo;

/**
 * Servlet implementation class RuoloSrv
 */
@WebServlet("/RuoloSrv")
public class RuoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RuoloSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RuoloDaoJpaImpl ruoloDao = new RuoloDaoJpaImpl();

		String tipoOp = request.getParameter("tipoOperazione");
		System.out.println("tipoOperazione=" + tipoOp);

		if (tipoOp != null && tipoOp.equals("inserisci")) {
			String descr = request.getParameter("descrizione");

			Ruolo r = new Ruolo();
			r.setDescrizione(descr);
			ruoloDao.inserisci(r);
			request.getRequestDispatcher("/inserisciRuoloOK.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("aggiorna")) {
			String descr = request.getParameter("descrizione");
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);
			
			Ruolo r = new Ruolo();
			r.setDescrizione(descr);
			r.setId(idR);
			ruoloDao.aggiorna(r);
			request.getRequestDispatcher("/aggiornaRuoloOk.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("elimina")) {
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);
			ruoloDao.elimina(idR);
		}

		if (tipoOp != null && tipoOp.equals("ricercaperid")) {
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);

			Ruolo imp = ruoloDao.ricercaPerId(idR);
			System.out.println("Ruolo trovato:" + imp.getDescrizione());
			
			
			request.getSession().setAttribute("ruoloTrovato", imp);
			
			request.getRequestDispatcher("/aggiornaRuolo.jsp").forward(request, response);

		}

		response.getWriter().append("HELLOOOOOOOOO: ").append(request.getContextPath());
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
