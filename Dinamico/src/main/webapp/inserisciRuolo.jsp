<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Inserisci Ruolo</h2>

  <form id="ruoloForm" action="<%=request.getContextPath()%>/RuoloSrv" method="post">
    Descrizione:
    <input type="text" id="descrizione" name="descrizione" ></br>

     <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="inserisci">

    <button type="submit">Invia</button>
  </form>
</body>
</html>