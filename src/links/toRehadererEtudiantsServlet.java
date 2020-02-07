package links;

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
 * Servlet implementation class toRehadererEtudiantsServlet
 */
public class toRehadererEtudiantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public toRehadererEtudiantsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		if(session.getAttribute("agent") !=null) {
			if(session.getAttribute("agent") != null) {
				
				List<Etudiant> exEtudiants =CrudEtudiant.getExpiredEtudiants();
				session.setAttribute("exEtudiants", exEtudiants);
				

				System.out.println("from database :   *****************************************");
				for (int i = 0; i < exEtudiants.size(); i++) {
					System.out.println(exEtudiants.get(i).getId());
				}
				
				
				List<Etudiant> exEtudiants1 =(List<Etudiant>) session.getAttribute("exEtudiants");

				System.out.println("session :   *****************************************");
				for (int i = 0; i < exEtudiants1.size(); i++) {
					System.out.println(exEtudiants1.get(i).getId());
				}
				
				
				getServletContext().getRequestDispatcher("/rejoinEtudiant.jsp").forward(request, response);
				
			}else {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
		
			}
			else {
		
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		
		
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
