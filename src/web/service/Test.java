package web.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import entities.Etudiant;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			AdhesionServiceStub serviceStub = new AdhesionServiceStub();
			
			AdhesionServiceStub.GetEtudiant getEtudiantRequest = new AdhesionServiceStub.GetEtudiant();
			
			getEtudiantRequest.setNumCarte("M1/32141826");
			
			AdhesionServiceStub.GetEtudiantResponse response= serviceStub.getEtudiant(getEtudiantRequest);
			
			response.get_return();
			
			Etudiant etudiant = new Etudiant();
			
			System.out.println(response.get_return().toString());
			
			etudiant.setNom(response.get_return().getNom());
			etudiant.setPrenom(response.get_return().getPrenom());
			etudiant.setEmail(response.get_return().getEmail());
			etudiant.setNumcarte(response.get_return().getNumCarte());
			etudiant.setAdresse(response.get_return().getAdresse());
			etudiant.setId(response.get_return().getId());
			
			
			System.out.println( etudiant.toString());
			
			
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		/*
		try {
			HellowordServiceStub serviceStub = new HellowordServiceStub();
			HellowordServiceStub.SayHello sayHello=new HellowordServiceStub.SayHello();
			sayHello.setName("Houssein");
			
			HellowordServiceStub.SayHelloResponse response =serviceStub.sayHello(sayHello);
			
			System.out.println(response.get_return());
			
		} catch (AxisFault e) {
			e.printStackTrace();
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		*/
		
	}
	

}
