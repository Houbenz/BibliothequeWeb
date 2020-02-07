package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Etudiant")
public class Etudiant {

	@Id
	@GenericGenerator(name = "increment",strategy = "increment")
	@GeneratedValue(generator = "increment")
	private int id ;
	
	
	private String numcarte;
	
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String specialite;
	
	private int adherer;
	
	public Etudiant() {
		
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getAdherer() {
		return adherer;
	}



	public void setAdherer(int adherer) {
		this.adherer = adherer;
	}



	public String getNumcarte() {
		return numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}



	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", numcarte=" + numcarte + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", adresse=" + adresse + ", specialite=" + specialite + ", adherer=" + adherer + "]";
	}
	
	
	
	
}
