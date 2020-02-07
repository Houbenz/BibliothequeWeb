<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/layout/Header.jsp" %>
<body>
<%@include file="layout/navbar.jsp" %>


<div class="row pt-3">
	
		<div class=col-md-3></div>
	
		<div class=col-md-6>
		
					   <form class="border border-dark rounded bg-white p-3" action="RegisterEtudiantServlet" method="Post" disabled>
				
					
						<h4 class="pb-5">Adhérer un nouveau étudiant</h4>
						
						<div class="form-group">
				        <label for="email">Email</label>
				        <input class="form-control" value="${etudiant.email }"  type="email" name="email" id="email">
						</div>
						
						<div class="form-row">
							<div class="col">
						        <label for="nom">Nom</label>
						        <input class="form-control" value="${etudiant.nom }" type="text" name="nom" id="nom">
							</div>
							
							<div class="col">
						        <label for="prenom">Prenom</label>
						        <input class="form-control"  value="${etudiant.prenom }"  type="text" name="prenom" id="prenom">
							</div>
						</div>
						
				        <div class="form-group">
						        <label for="prenom">adresse</label>
						        <input class="form-control"  value="${etudiant.adresse }"  type="text" name="adresse" id="adresse">
						</div>
									
						<div class="form-row mb-3">
					        <div class="col">
						        <label for="prenom">specialite</label>
						       
							        <select class="form-control" value="${etudiant.specialite }"  type="text" name="specialite" id="specialite">
								        <option>MI</option>
								       	<option>TLSI</option>
								      	<option>IFA</option>
							        </select>
							</div>
							<div class="col">
						        <label for="numCarte">Numero de carte</label>
						        <input class="form-control"  value="${etudiant.numcarte }"  type="text" name="numCarte" id="numCarte">
							</div>
						</div>
				
				        <input class="btn btn-success btn-block" type="submit" value="ajouter">
				
				        
				        
				       	<c:choose>
				        
				        <c:when test="${added == false }">
				                <h4 class="small text-center mt-3 text-danger">${msg4 }</h4>
				        </c:when>
				        <c:when test="${added == true }">
   				                <h4 class="small text-center mt-3 text-success">${msg4 }</h4>
				       </c:when>
				        </c:choose>
				        
				    </form>
				    
		
		</div>
	
		<div class=col-md-3></div>
	</div>