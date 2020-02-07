package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudEtudiant;
import entities.Etudiant;

/**
 * Servlet implementation class DeleteEtudiantServlet
 */
public class DeleteEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEtudiantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		
		if(session.getAttribute("agent") !=null) {
			

		int id= Integer.parseInt(request.getParameter("id"));
		boolean isRemoved =CrudEtudiant.expireEtudiant(id);
		String msg="";
		String url="/supprimerEtudiant.jsp";
		
		session.setAttribute("isRemoved", isRemoved);
		if(isRemoved) {
			
			msg="la souscription ID : "+id+" est terminé";
			session.setAttribute("msg1", msg);
			List<Etudiant> adEtudiants =CrudEtudiant.getAdheredEtudiants();
			session.setAttribute("adEtudiants", adEtudiants);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
		}else {

			getServletContext().getRequestDispatcher(url).forward(request, response);
			session.setAttribute("msg1", msg);
			msg="Aucun etudiant correspand  a id : "+id;
		}
		}
		else {

			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
