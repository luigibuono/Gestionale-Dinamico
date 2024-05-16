<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Menu di Esempio</h2>
	<ul id="menu">
		<li><a
			href="<%=request.getContextPath()%>/inserimentoImpiegato.jsp">Inserisci
				Impiegato</a></li>
		<li><a
			href="<%=request.getContextPath()%>/ricercaImpiegatoPerCodiceFiscale.jsp">Ricerca
				Impiegato Per Codice Fiscale</a></li>


		<li><a
			href="<%=request.getContextPath()%>/ricercaImpiegatoPerCognome.jsp">Ricerca
				Impiegato Per Cognome</a></li>

		<li><a
			href="<%=request.getContextPath()%>/inserisciRuolo.jsp">Inserisci
				Ruolo</a></li>
		<li><a
			href="<%=request.getContextPath()%>/ricercaRuoloPerId.jsp">Ricerca
				Ruolo Per Id</a></li>
		<li><a
			href="<%=request.getContextPath()%>/inserisciStorico.jsp">Inserisci
				Storico</a></li>
		<li><a
			href="<%=request.getContextPath()%>/ricercaStoricoPerId.jsp">Ricerca
				Storico Per Id</a></li>

	</ul>
</body>
</html>