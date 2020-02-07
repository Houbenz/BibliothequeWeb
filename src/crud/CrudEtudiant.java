package crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Agent;
import entities.Etudiant;

public class CrudEtudiant extends FactoryManagerSingleton {

		
	/**
	 * Pour Ajout un Etudiant a la base de données
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 * @param specialite
	 */	
	public static boolean ajouterEtudiant(String numCarte,String nom,String prenom,String email,String adresse,String specialite) {
		
		EntityManager eManager=factory.createEntityManager();
		EntityTransaction transaction =eManager.getTransaction();
		
		try {
			transaction.begin();
			Etudiant etudiant = new Etudiant();
			etudiant.setNumcarte(numCarte);
			etudiant.setNom(nom);
			etudiant.setPrenom(prenom);
			etudiant.setAdresse(adresse);
			etudiant.setSpecialite(specialite);
			etudiant.setEmail(email);
			etudiant.setAdherer(1);
			eManager.persist(etudiant);
			transaction.commit();
			
			System.out.println("Etudiant"+etudiant.getNom()+"\t"+etudiant.getPrenom() +" ajouté !");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());;
		}finally {
			eManager.close();
		}	
		return false;
	}
	
	public static boolean rejoinEtudiant(int id) {
		EntityManager eManager=factory.createEntityManager();
		EntityTransaction transaction =eManager.getTransaction();
		
		try {
			transaction.begin();
			String query="SELECT e from Etudiant e where e.id = :id";
			TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
			tq.setParameter("id", id);
			Etudiant etudiant =tq.getSingleResult();
			
			if(etudiant.getAdherer() == 1) {
				System.out.println("l'etudiant est déja adheré");
				return false;
			}else {
				etudiant.setAdherer(1);
			}
			
			eManager.persist(etudiant);
			transaction.commit();
			
			System.out.println("Etudiant"+etudiant.getNom()+"\t"+etudiant.getPrenom() +" est rehadéré !");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());;
		}finally {
			eManager.close();
		}	
		return false;
	}

	
	
	public static List<Etudiant> getEtudiants(){
		EntityManager eManager =factory.createEntityManager();
		EntityTransaction transaction=eManager.getTransaction();
		List<Etudiant> etudiants;
		try {
			transaction.begin();
			String query ="SELECT e from Etudiant e where e.id IS NOT NULL";
			TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
			etudiants=tq.getResultList();
			for(Etudiant etudiant : etudiants) {
				System.out.println(etudiant.getNom());
			}
			transaction.commit();
			return etudiants;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			eManager.close();
		}	
		return null;
	}
	
	

	public static List<Etudiant> getAdheredEtudiants(){
		
		EntityManager eManager =factory.createEntityManager();
		EntityTransaction transaction=eManager.getTransaction();
		List<Etudiant> etudiants;
		try {
			transaction.begin();
			String query ="SELECT e from Etudiant e where e.adherer = 1";
			TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
			etudiants=tq.getResultList();
			for(Etudiant etudiant : etudiants) {
				System.out.println(etudiant.getNom());
			}
			transaction.commit();
			return etudiants;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			eManager.close();
		}	
		return null;
	}
	
	
	public static List<Etudiant> getExpiredEtudiants(){
		
		EntityManager eManager =factory.createEntityManager();
		EntityTransaction transaction=eManager.getTransaction();
		List<Etudiant> etudiants;
		try {
			transaction.begin();
			String query ="SELECT e from Etudiant e where e.adherer = 0";
			TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
			etudiants=tq.getResultList();
			for(Etudiant etudiant : etudiants) {
				System.out.println(etudiant.getNom());
			}
			transaction.commit();
			return etudiants;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			eManager.close();
		}	
		return null;
	}

	public static boolean expireEtudiant(int id) {
		
		
		EntityManager eManager=factory.createEntityManager();
		EntityTransaction transaction =eManager.getTransaction();
		
		try {
			transaction.begin();
			String query="SELECT e from Etudiant e where e.id = :id";
			TypedQuery<Etudiant> tq=eManager.createQuery(query,Etudiant.class);
			tq.setParameter("id", id);
			Etudiant etudiant =tq.getSingleResult();
			
			etudiant.setAdherer(0);
			eManager.persist(etudiant);
			//eManager.remove(etudiant);
			transaction.commit();
			
			System.out.println("Etudiant"+etudiant.getNom()+"\t"+etudiant.getPrenom() +" est supprimé !");
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());;
		}finally {
			eManager.close();
		}	
		return false;
	}
}
