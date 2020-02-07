package crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Inscrit;
import entities.Etudiant;;

public class CrudInscrit  extends FactoryManagerSingleton{

	
	

	
	public static Inscrit ajouterEtudiant(int annee_id,String numCarte) {
		

		EntityManager eManager=factory.createEntityManager();
		EntityTransaction transaction =eManager.getTransaction();
		Inscrit inscrit=null;
		try {
			transaction.begin();
			inscrit = new Inscrit(annee_id,numCarte);
			eManager.persist(inscrit);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			eManager.close();
		}
		return inscrit;
	}
	
	
	public static List<Etudiant> getEtudiantsInscrit(int annee) {
		
		EntityManager eManager =factory.createEntityManager();
		EntityTransaction transaction=eManager.getTransaction();
		List<Etudiant> etudiants;
		try {
			transaction.begin();
		
		String query= "select e from Etudiant e,Inscrit i where e.numcarte=i.numCarte and adherer != 0 and i.annee_id like :annee ";
		TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
		tq.setParameter("annee", annee);
		etudiants=tq.getResultList();
			
		transaction.commit();
		
		for(Etudiant etudiant : etudiants) {
			System.out.println(etudiant.getNom());
		}
		return etudiants;
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			eManager.close();
		}	
		return null;
		
	}

		
}
