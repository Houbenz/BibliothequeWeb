package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Agent;

public class CrudAgent extends FactoryManagerSingleton {

	
	public static boolean authentifier(String email,String password) {
		
		Agent agent = getAgent(email, password);
		if(agent == null) {
			return false;
		}else {
			return true;
		}	
	}
	
	public static Agent getAgent(String email,String password ) {

		EntityManager eManager=factory.createEntityManager();
		EntityTransaction transaction = eManager.getTransaction();
		try {
			transaction.begin();
			String query="SELECT a from Agent a where a.email = :email AND a.password = :password";
			TypedQuery<Agent> typedQuery=eManager.createQuery(query,Agent.class);
			typedQuery.setParameter("email", email);
			typedQuery.setParameter("password", password);
			
			Agent agent=null;
			agent=typedQuery.getSingleResult();
			transaction.commit();
		
			return agent;
			
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		} finally {
			eManager.close();
		}
		return null;
	}
}
