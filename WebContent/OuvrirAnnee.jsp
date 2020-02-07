<%@include file="/layout/Header.jsp" %>
<body>
<%@include file="layout/navbar.jsp" %>

<div class="container pt-5 mt-5"> 

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">    
					
		
					
					<c:choose>
					
						<c:when test="${annee.ouvert ==0 or annee.ouvert ==2 }">
						
									<h3 class="py-3">L'an : ${annee.annee } est fermé</h3>
									<form class="p-3 bg-secondary" action="OuvrirAnneeServlet" method="post">
									<h5 class="pt-3 text-white text-center">Ouvrir le nouvel An</h5>
									
									<input type="hidden" value="${annee.annee }" name="an">
									<input class="btn btn-block btn-primary mt-2"type="submit" value="ouvrir l'an">
									</form>
						</c:when>
						
						<c:when test="${annee.ouvert ==1 }">
						
							<h3 class="py-3">L'an : ${annee.annee } est ouvert.</h3>
							
									<form class="p-3 bg-secondary" action="OuvrirAnneeServlet" method="post">
									<h5 class="pt-3 text-white text-center">Fermer l'an</h5>
									<input type="hidden" value="${annee.annee }" name="an">
									<input class="btn btn-block btn-primary mt-2"type="submit" value="Fermer l'an">
									</form>
						</c:when>
					</c:choose>
					
		</div>
		<div class="col-md-3"></div>
	</div>
						<h3 class="small"> ${msg3}</h3>
</div>
</body>
</html>