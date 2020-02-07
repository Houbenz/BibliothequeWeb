package crud;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Annee;
import entities.Etudiant;

public class CrudAnnee extends FactoryManagerSingleton {

	
	public static final int OUVERT=1;
	public static final int FERME=2;
	public static final int NON_ARRIVE=0;

	
	/**
	 * ajoute une annnee a la bd de la biblio
	 * @param date
	 */
	public static void createAnnee(String date,int ouvert) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		
		try {
			transaction.begin();
			
			Annee annee = new Annee();
			annee.setAnnee(date.toString());
			annee.setOuvert(ouvert);
			eManager.persist(annee);
			
			System.out.println("date : "+date+" , ouvert : "+ouvert);
			
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {

			eManager.close();
		}
	}
	
	public static void modifyAnnee(String anneeString,int ouvert) {
		
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		
		try {
			transaction.begin();

			String query="SELECT a from Annee a where a.annee like :annee";
		
			TypedQuery<Annee> tq=eManager.createQuery(query,Annee.class);
			tq.setParameter("annee",anneeString);
			
			Annee annee =tq.getSingleResult();
			
			annee.setOuvert(ouvert);
			eManager.persist(annee);
			
			transaction.commit();
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {

			eManager.close();
		}
	}
	
	
	public static Annee getAnnee(String an) {
	
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		Annee annee =null;
		try {
			transaction.begin();
			String query="SELECT a from Annee a where annee like :an";
			TypedQuery<Annee> typedQuery = eManager.createQuery(query,Annee.class);
			typedQuery.setParameter("an", an);
			annee=typedQuery.getSingleResult();
			
			transaction.commit();
			return annee;
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			eManager.close();
		}
		
		return null;
	}
	
	
}
