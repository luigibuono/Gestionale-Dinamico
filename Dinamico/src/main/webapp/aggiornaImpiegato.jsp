<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="model.Impiegato" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Impiegato imp = (Impiegato)request.getSession().getAttribute("impiegatoTrovato"); %>
<h2>Form Impiegato</h2>

  <form id="impiegatoForm" action="<%=request.getContextPath()%>/ImpiegatoSrv" method="post">
    Nome:
    <input type="text" id="nome" name="nome" value="<%out.print(imp.getNome()); %>" ></br>

    Cognome:
    <input type="text" id="cognome" name="cognome"  value="<%=imp.getCognome() %>"></br>

    Codice Fiscale:
    <input type="text" id="cf" name="cf" value="<%=imp.getCodiceFiscale() %>">
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="aggiorna">

    <button type="submit">Invia</button>
  </form>
</body>
</html>