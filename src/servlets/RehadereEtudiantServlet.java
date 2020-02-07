package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudAgent;
import crud.CrudAnnee;
import crud.CrudEtudiant;
import crud.CrudInscrit;
import entities.Annee;
import entities.Etudiant;
import entities.Inscrit;

/**
 * Servlet implementation class RehadereEtudiantServlet
 */
public class RehadereEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RehadereEtudiantServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		if(session.getAttribute("agent") !=null) {
			
			int id= Integer.parseInt(request.getParameter("id"));
			String numcarte =request.getParameter("numcarte");
			Annee annee = (Annee)session.getAttribute("annee");
			boolean rejoined =false;
			rejoined=CrudEtudiant.rejoinEtudiant(id);
			Inscrit inscrit = CrudInscrit.ajouterEtudiant(annee.getId(),numcarte);
			
			
			String url="/rejoinEtudiant";
			request.setAttribute("rejoind", rejoined);
			if (inscrit != null) {
				request.setAttribute("msg2", "etudiant adheré avec succès");
				

				List<Etudiant> etudiants=CrudEtudiant.getExpiredEtudiants();
				session.setAttribute("exEtudiants", etudiants);
		
			}else {
				request.setAttribute("msg2", "Une erreur est parvenu");
			}
			request.getRequestDispatcher(url).forward(request, response);
			}
			else {
		
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			}
	}
