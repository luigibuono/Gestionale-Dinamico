<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="model.Ruolo" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Ruolo r = (Ruolo)request.getSession().getAttribute("ruoloTrovato"); %>
<h2>Form Ruolo</h2>

  <form id="ruoloForm" action="<%=request.getContextPath()%>/RuoloSrv" method="post">
    Descrizione:
    <input type="text" id="descrizione" name="descrizione" value="<%out.print(r.getDescrizione()); %>" ></br>
  <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="aggiorna">
    <input type="hidden" id="id" name="id" value="<%out.print(r.getIdRuolo()); %>">

    <button type="submit">Invia</button>
  </form>
</body>
</html>