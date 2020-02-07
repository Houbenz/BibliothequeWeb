package links;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CrudAnnee;
import crud.CrudEtudiant;
import entities.Annee;
import entities.Etudiant;

/**
 * Servlet implementation class OuvrirAnneeServlet
 */
public class GotoAnne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GotoAnne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		if(session.getAttribute("agent") !=null) {
			
			//test on the computer clock 
			Calendar calendar =Calendar.getInstance();
			String now= "";
			if(calendar.get(Calendar.MONTH)>9) {
				 now = String.valueOf(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.YEAR)+1));

			}else {
				 now = String.valueOf(calendar.get(Calendar.YEAR) - 1+"-"+(calendar.get(Calendar.YEAR)));
			}
			

			//if it doesn't exists add it to the database 
			Annee annee =CrudAnnee.getAnnee(now);
			if( annee== null ) {
				CrudAnnee.createAnnee(now,0);
				ArrayList<Etudiant> etudiants = (ArrayList<Etudiant>) CrudEtudiant.getEtudiants();
				
				
				//expire all students
				for (int i = 0; i < etudiants.size(); i++) {
					int id =etudiants.get(i).getId();
					CrudEtudiant.expireEtudiant(id);
					
				}
				
				
				
			}
			annee =CrudAnnee.getAnnee(now);
			session.setAttribute("annee",annee);
			
			String url="/OuvrirAnnee.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			else {
		
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
			}
}
		
		
