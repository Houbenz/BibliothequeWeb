package links;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import crud.CrudEtudiant;
import crud.CrudInscrit;
import entities.Annee;
import entities.Etudiant;

/**
 * Servlet implementation class ToDeleteEtudiantsServlet
 */
public class ToDeleteEtudiantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ToDeleteEtudiantsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("agent") !=null) {
			
			
			
			if(session.getAttribute("agent") != null) {
				
				Annee annee =(Annee) session.getAttribute("annee");
				List<Etudiant> adEtudiants =CrudInscrit.getEtudiantsInscrit(annee.getId());//CrudEtudiant.getAdheredEtudiants();
				session.setAttribute("adEtudiants", adEtudiants);
				

				System.out.println("from database :   *****************************************");
				for (int i = 0; i < adEtudiants.size(); i++) {
					System.out.println(adEtudiants.get(i).getId());
				}
				
				
				List<Etudiant> adEtudiants1 =(List<Etudiant>) session.getAttribute("adEtudiants");

				System.out.println("session :   *****************************************");
				for (int i = 0; i < adEtudiants1.size(); i++) {
					System.out.println(adEtudiants1.get(i).getId());
				}
				
				
				getServletContext().getRequestDispatcher("/supprimerEtudiant.jsp").forward(request, response);
				
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
