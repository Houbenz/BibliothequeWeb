package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudAnnee;
import crud.CrudEtudiant;
import entities.Annee;
import entities.Etudiant;

public class OuvrirAnneeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OuvrirAnneeServlet() {
        super();
    }

    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("agent") !=null) {
			String annee =request.getParameter("an");

			
			Annee annee2 =CrudAnnee.getAnnee(annee);
			
			
			//ouvrir année 1 = ouvert ; 2 = termine ;3 = nonarrive

			if (annee2.getOuvert() == 0 || annee2.getOuvert() == 2) {
				CrudAnnee.modifyAnnee(annee, 1);
				request.setAttribute("msg3", "An est ouvert bravo ! ");
				session.setAttribute("open", true);
			}else if(annee2.getOuvert() == 1) {
				CrudAnnee.modifyAnnee(annee,2);
				request.setAttribute("msg3", "An est fermé");
				session.setAttribute("open", false);
				//expire all students
				ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>) CrudEtudiant.getEtudiants();
				for (int i = 0; i < etudiants.size(); i++) {
					int id =etudiants.get(i).getId();
					CrudEtudiant.expireEtudiant(id);
					
				}
				
			}
			

			Annee newAnnee =CrudAnnee.getAnnee(annee);
			session.setAttribute("annee", newAnnee);
			
			String url="/OuvrirAnnee.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		
			}
			else {
		
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
	}

}
