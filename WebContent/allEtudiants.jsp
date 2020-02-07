<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="/layout/Header.jsp" %>
<body>
<%@include file="layout/navbar.jsp" %>

<div class="container">
	<div class="row">
	
		
							<h3 class="text-center">Liste des étudiants enregistrés au moins une fois</h3>
					
							<table class="table mt-5">
							<thead>
							<tr>
							<th scope="col">nom</th>
							<th scope="col">prenom</th>
							<th scope="col">email</th>
							<th scope="col">numero etudiant</th>
							</tr>
							</thead>
							
							<c:forEach items="${etudiants }" var="element">
							
							<tr>
							<td>${element.nom }</td>
							<td>${element.prenom }</td>
							<td>${element.email }</td>
							<td>${element.numcarte }</td>
							</tr>
							</c:forEach>
	</div>
</div>


</body>
</html>