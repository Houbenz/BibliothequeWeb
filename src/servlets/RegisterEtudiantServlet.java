package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudAnnee;
import crud.CrudEtudiant;
import crud.CrudInscrit;
import entities.Annee;
import entities.Inscrit;

/**
 * Servlet implementation class RegisterEtudiantServlet
 */
public class RegisterEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterEtudiantServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
				
				
	
	HttpSession session = request.getSession();
	if(session.getAttribute("agent") !=null) {

		
		String email=request.getParameter("email");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String adresse=request.getParameter("adresse");
		String specialite=request.getParameter("specialite");
		String numCarte=request.getParameter("numCarte");
		
		boolean added=false;
		
				Inscrit inscrit=null;
			if(nom.equals("") ||prenom.equals("")|| adresse.equals("")||numCarte.equals("") ) {
				
			}else {

				added =CrudEtudiant.ajouterEtudiant(numCarte, nom, prenom, email, adresse, specialite);
				Annee annee =(Annee)session.getAttribute("annee");
				inscrit=CrudInscrit.ajouterEtudiant(annee.getId(), numCarte);
				
			}
					String url="/registerEtudiant";
					request.setAttribute("added", added);
					if (inscrit != null) {
						request.setAttribute("msg4", "Etudiant(e) "+nom +" "+prenom +" ajouté");
						
					}else {
						request.setAttribute("msg4", "une erreur est parvenu");
					}
					getServletContext().getRequestDispatcher(url).forward(request, response);
					}
					else {
				
						getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
}

}
