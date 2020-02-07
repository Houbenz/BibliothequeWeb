package servlets;

import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudAgent;
import crud.CrudAnnee;
import crud.CrudEtudiant;
import entities.Agent;
import entities.Annee;
import entities.Etudiant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//doGet(request, response);
	
		

		Calendar calendar =Calendar.getInstance();	
		String now = String.valueOf(calendar.get(Calendar.YEAR) - 1+"-"+(calendar.get(Calendar.YEAR)));
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		boolean isLogged = CrudAgent.authentifier(email, password);
			
		if(isLogged) {
			
			HttpSession session = request.getSession();
			String url="/home.jsp";
		
			Annee annee =CrudAnnee.getAnnee(now);
			
			if( annee != null && annee.getOuvert() == 1) {
				session.setAttribute("open", true);
				session.setAttribute("annee", annee);

			}else 
				session.setAttribute("open", false);
			
			System.out.println("this is open : "+request.getAttribute("open"));
			
			session.setAttribute("agent",CrudAgent.getAgent(email, password) );
			getServletContext().getRequestDispatcher(url)
									.forward(request, response);
			
			
		}else {
			String url="/index.jsp";
			request.setAttribute("msg", "aucun utilisateur trouvé !");
			getServletContext().getRequestDispatcher(url)
									.forward(request, response);
		}
		
	}

}
