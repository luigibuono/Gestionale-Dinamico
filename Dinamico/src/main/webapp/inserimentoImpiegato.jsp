<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h2>Form Impiegato</h2>

  <form id="impiegatoForm" action="<%=request.getContextPath()%>/ImpiegatoSrv" method="post">
    Nome:
    <input type="text" id="nome" name="nome" ></br>

    Cognome:
    <input type="text" id="cognome" name="cognome" ></br>

    Codice Fiscale:
    <input type="text" id="cf" name="cf" >
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="inserisci">

    <button type="submit">Invia</button>
  </form>
</body>
</html>ml>