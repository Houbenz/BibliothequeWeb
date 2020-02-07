package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Etudiant;
import web.service.AdhesionServiceStub;



public class RechercherEtudiantWS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RechercherEtudiantWS() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		
		String url="/formEtudiant.jsp";
		
		if(session != null) {
			String num_carte=request.getParameter("num_carte");
			
			AdhesionServiceStub serviceStub = new AdhesionServiceStub();
			
			AdhesionServiceStub.GetEtudiant requestEtudiant= new AdhesionServiceStub.GetEtudiant();
			requestEtudiant.setNumCarte(num_carte);
			
			AdhesionServiceStub.GetEtudiantResponse responseEtudiant=serviceStub.getEtudiant(requestEtudiant);
			if (responseEtudiant.get_return() != null) {
				Etudiant etudiant = new Etudiant();
	
				System.out.println(responseEtudiant.get_return().toString());
				etudiant.setNom(responseEtudiant.get_return().getNom());
				etudiant.setPrenom(responseEtudiant.get_return().getPrenom());
				etudiant.setEmail(responseEtudiant.get_return().getEmail());
				etudiant.setNumcarte(responseEtudiant.get_return().getNumCarte());
				etudiant.setAdresse(responseEtudiant.get_return().getAdresse());
				etudiant.setId(responseEtudiant.get_return().getId());
				
				session.setAttribute("etudiant", etudiant);
			}else {
				session.setAttribute("stubVide", "Aucun Etudiant disponible");
			}
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}

}
