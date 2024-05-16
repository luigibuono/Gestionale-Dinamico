<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
          <%@ page import="model.Storico" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
 <h2>Inserisci Storico</h2>

<% Storico s = (Storico)request.getSession().getAttribute("storicoTrovato"); %>

  <form id="storicoForm" action="<%=request.getContextPath()%>/StoricoSrv" method="get">
    matricola:
    <input type="number" id="matricola" name="matricola" value ="<%out.print(s.getMatricola()); %>"></br>
   idRuolo:
    <input type="number" id="idRuolo" name="idRuolo" value ="<%out.print(s.getIdRuolo()); %>"></br>
   dataInizio:
    <input type="date" id="dataInizio" name="dataInizio" value ="<%out.print(s.getDataInizio()); %>"></br>
   dataFine:
    <input type="date" id="dataFine" name="dataFine" value ="<%out.print(s.getDataFine());%>"></br>

     <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="aggiorna">

    <input type="hidden" id="idStorico" name="idStorico" value="<%out.print(s.getIdStorico());%>">

    <button type="submit">Invia</button>
  </form>
</body>
</body>
</html>