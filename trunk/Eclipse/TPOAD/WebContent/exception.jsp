<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Gestion de Rodamientos</title>
        <link rel="stylesheet" type="text/css" href="css/main.css"/>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>Error</h1>
        <div id="content">
            <p>Se ha producido un error.</p>
            <p><b><%= request.getAttribute("javax.servlet.error.message") %></b></p>
        </div>
    </body>
</html>