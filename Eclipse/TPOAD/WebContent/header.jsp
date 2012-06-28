<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
String contextPath = application.getContextPath();
String logoUrl = contextPath+"/images/rodamientos-logo.gif";
%>

<div><img src="<%=logoUrl%>" alt="Rodamiento Home"/></div>
<div id="menu">
    <span class="item">
        <a href="<%=contextPath%>">Home</a>
    </span>
    <span class="item">
        <a href="<%=contextPath%>/nuevoRodamiento/index.jsp">Nuevo Rodamiento</a>
    </span>
    <span class="item">
        <a href="<%=contextPath%>/solCotizacion/index.jsp">Solicitud de Cotizacion</a>
    </span>
    <span class="item">
        <a href="<%=contextPath%>/envODV/index.jsp">Envio a ODV</a>
    </span>
    <span class="item">
        <a href="<%=contextPath%>/solCompra/index.jsp">Solicitud de Compra</a>
    </span>
    <span class="item">
        <a href="<%=contextPath%>/solPedido/index.jsp">Solicitud de Pedido</a>
    </span>
</div>
