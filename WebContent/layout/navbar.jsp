
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light ">
  <nav class="navbar-brand" ><strong class="text-success">
  <a href="http://localhost:8000/BibliothequeApp/home.jsp">Biblio</strong><strong class="text-danger">thèque</strong></a>
 <p class="nav-link btn">${annee.annee }</p>
  </nav>
	<div class="container-fluid">

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="nav navbar-nav mr-auto">				    
		        
	<c:choose>
	
	
	
				        <c:when test ="${agent.type=='conservateur' }">
					        <c:choose>
							        <c:when test="${open==true }">
							        		<li class="nav-link"><a href="GotoAnne">Fermer l'année</a></li>
							        </c:when>
							        <c:when test="${open==false }">
							        		<li class="nav-link"><a href="GotoAnne">Ouvrir l'année</a></li>
							        </c:when>
					        </c:choose>
			        </c:when>
			        
					<c:when test="${open == true }">
					
						        <li class="nav-link"><a href="registerEtudiant.jsp">Adhérer un étudiant</a></li>
						        <li class="nav-link"><a href="toRehadererEtudiantsServlet">Réadherer un étudiant</a></li>
						        <li class="nav-link"><a href="ShowAllEtudiantsServlet">Afficher les étudiants</a></li>
						        <li class="nav-link"><a href="ToDeleteEtudiantsServlet">Expirer un étudiant</a></li>
						        
	</c:when>
	</c:choose>
		        	
			</ul>
				
		        <a class="nav-item btn btn-warning"href="DisconnectServlet">Se déconnecter</a>
		</div>
	</div>
</nav>
