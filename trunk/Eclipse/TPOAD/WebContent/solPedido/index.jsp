<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="tr" uri="http://myfaces.apache.org/trinidad"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Gestion de Rodamientos</title>
        <link rel="stylesheet" type="text/css" href="../css/main.css"/>
    </head>
    <body>
        <%@include file="/header.jsp" %>
        <h1>Solicitud de Pedido</h1>
        <div id="content">
            <div class="message info">Para utilizar esta funcionalidad ingrese en el campo inferior el archivo XML y presione el boton "Enviar".</div>
            <f:view>
                <h:messages infoClass="message success" warnClass="message warning" errorClass="message error" showDetail="true"/> 
                <h:form enctype="multipart/form-data">
                    <tr:inputFile label="Upload:" value="#{uploadReposicionArticulos.file}"/>
                    <h:commandButton value="Comenzar" action="#{uploadReposicionArticulos.doUpload}"/>
                </h:form>
            </f:view>
        </div>
    </body>
</html>