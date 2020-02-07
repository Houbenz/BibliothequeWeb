<%@include file="/layout/Header.jsp" %>
<body>
<%@include file="layout/navbar.jsp" %>


<div class="container">
	<div class="row">
	
		
							<h3 class="text-center">Liste des etudiants adhérées</h3>
					
							<table class="table mt-5">
							<thead>
							<tr>
							<th scope="col">ID</th>
							<th scope="col">nom</th>
							<th scope="col">prenom</th>
							<th scope="col">email</th>
							<th scope="col">numero etudiant</th>
							<th scope="col">Action</th>
							</tr>
							</thead>
							
							<c:forEach items="${adEtudiants}" var="element">
							
							
							<tr>
							<td>${element.id }</td>
							<td>${element.nom }</td>
							<td>${element.prenom }</td>
							<td>${element.email }</td>
							<td>${element.numcarte }</td>
							
							
							
							<td>
								
								<form method="post" action=DeleteEtudiantServlet>	
								<input type="hidden" name="id" value="${element.id}" >
								<input type="submit" class="btn btn-danger" value="expirer">
								</form>
							</td>
							
							</tr>
							</c:forEach>
							
							</table>
							
							<h4 class="small"> ${msg1}</h4>
	</div>
</div>



						
</body>
</html>