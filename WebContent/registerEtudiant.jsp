<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/layout/Header.jsp" %>
<body>
<%@include file="layout/navbar.jsp" %>

<div class="container ">
		<div class="row">
			<div class=col-md-2></div>
			<div class=col-md-8><h5 class="text-center">Bonjour ${agent.nom} ${agent.prenom }</h5></div>
								<h5 class="text-center">${stubVide}</h5></div>
			<div class=col-md-2></div>
		</div>
		
		
		
		
	<div class="row">
		<div class=col-md-3></div>	
		<div class=col-md-6>
		
		<form class="border border-dark rounded bg-white p-3" action="RechercherEtudiantWS" method="post">
			<h3 class="text-center">Rechercher un etudiant depuis l'université	</h3>
			
		<div class="form-group">
			<label for="num_carte">Numero de carte</label>
			<input  class="form-control" type="text" name="num_carte" id="num_carte"/>
		</div>
		
		<input class="btn btn-success btn-block" type="submit" value="chercher">
		
		</form>
					
				<h5> ${nom} ${prenom} </h5>
		</div>
		
		<div class=col-md-3></div>
	
	</div>
</div>


</body>
</html>
