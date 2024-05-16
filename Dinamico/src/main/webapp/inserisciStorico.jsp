<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Inserisci Storico</h2>

  <form id="storicoForm" action="<%=request.getContextPath()%>/StoricoSrv" method="post">
    matricola:
    <input type="number" id="matricola" name="matricola" ></br>
   idRuolo:
    <input type="number" id="idRuolo" name="idRuolo" ></br>
   dataInizio:
    <input type="date" id="dataInizio" name="dataInizio" ></br>
   dataFine:
    <input type="date" id="dataFine" name="dataFine" ></br>

     <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="inserisci">

    <button type="submit">Invia</button>
  </form>
</body>
</html>