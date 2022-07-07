<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calendrier Gif</title>
<style type="text/css">
<%@include file="style/dark.css"%>
</style>
</head>
<body>
<header>
		<h1>Calendrier Gif</h1>
	</header>

<main>
		<c:if test="${param.notification ne null}">
			<h2>${param.notification}</h2>
		</c:if>

		<form class="mb-3" action="" method="post">
				<label class="form-label" for="email">Email</label>
				 <input class="form-control" type="email" name="EMAIL" placeHolder="Email"
					required>

				<label class="form-label" for="mot_de_passe">Mot de passe</label>
				 <input class="form-control" type="password" name="MOT_DE_PASSE"
					placeHolder="Mot de Passe" required>
					
				<input class="button-green" type="submit" value="Connexion">
				<a href="inscription" class="button-red" >
				S'inscrire
				</a>
		</form>
		
		<section class="mt-5">
		<p>Nb d'inscrits par année et par mois :</p>
		<c:forEach items="${nbInscrits}" var="nbInscrit">
	${nbInscrit.annee}/${nbInscrit.mois} : ${nbInscrit.nbInscrits}<br>
		</c:forEach>
		Nombre d'inscrits : ${nbTotalInscrits}
		</section>
		</main>

</body>
</html>