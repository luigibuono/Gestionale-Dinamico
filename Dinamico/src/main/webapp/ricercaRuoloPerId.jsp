<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ricerca Per Id</h2>

  <form id="ruoloForm" action="<%=request.getContextPath()%>/RuoloSrv" method="get">
 
    Id:
    <input type="text" id="id" name="id" >
	</br>
    <!-- Campo hidden per tipoOperazione -->
    <input type="hidden" id="tipoOperazione" name="tipoOperazione" value="ricercaperid">

    <button type="submit">Invia</button>
  </form>
</body>
</html>