<%@include file="/layout/Header.jsp" %>
<body>

<%@include file="/layout/navbar.jsp" %>
<div class="container pt-5 mt-5"> 

	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">    
		
		 <h3 class="pt-3 text-center">Bonjour ${agent.nom}
		  ${agent.prenom}</h3> 
		  
		  <h3 class="pt-3 text-center">Type:  ${agent.type} </h3>
		
		    <ul class="list-group pt-3">
		        <c:choose>
			        <c:when test ="${agent.type=='conservateur' }">
			                <c:choose>
							        <c:when test="${open==true }">
			       							<li class="list-group-item"><a href="GotoAnne">Fermer ann�e</a></li>
							        </c:when>
							        <c:when test="${open==false}">
			       							<li class="list-group-item"><a href="GotoAnne">Ouvrir ann�e</a></li>
							        </c:when>
					        </c:choose>
			        </c:when>
					<c:when test="${open == true }">
					        <li class="list-group-item"><a href="registerEtudiant.jsp">Adh�rer un �tudiant</a></li>
					        <li class="list-group-item"><a href="toRehadererEtudiantsServlet">R�adherer un �tudiant</a></li>
					        <li class="list-group-item"><a href="ShowAllEtudiantsServlet">Afficher les �tudiants</a></li>
					        <li class="list-group-item"><a href="ToDeleteEtudiantsServlet">Expirer un �tudiant</a></li>
		        	</c:when>
				</c:choose>
		        	
		        <li class="list-group-item"><a href="DisconnectServlet">Se d�connecter</a></li>
		    </ul>
		</div>
		<div class="col-md-3"></div>
	</div>


</div>
</body>
</html>
