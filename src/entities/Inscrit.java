package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inscrit")
public class Inscrit implements Serializable{

	@Id
	private int annee_id;
	@Id
	private String numCarte;
	
	public Inscrit(int annee_d,String numCarte) {
		this.annee_id=annee_d;
		this.numCarte=numCarte;
	}
	
	public int getAnnee_id() {
		return annee_id;
	}
	public void setAnnee_id(int annee_id) {
		this.annee_id = annee_id;
	}
	public String getNumCarte() {
		return numCarte;
	}
	public void setNumCarte(String numCarte) {
		this.numCarte = numCarte;
	}
	
	
	
}
