package crud;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class FactoryManagerSingleton {


	protected static EntityManagerFactory factory=Persistence.
			createEntityManagerFactory("biblio");
}
