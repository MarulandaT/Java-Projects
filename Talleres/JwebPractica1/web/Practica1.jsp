<%-- 
    Document   : Practica1
    Created on : 8/02/2019, 02:12:43 PM
    Author     : l_mar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="operaciones.OpBasicas" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 1</title>
    </head>
    <body>
        <h1>Hola, ${param.nombre}</h1>
        <p>
            <strong> ${param.num1} + ${param.num2} = </strong> <%= OpBasicas.suma(request.getParameter("num1"),request.getParameter("num2") ) %><br>
            <strong> ${param.num1} - ${param.num2} = </strong> <%= OpBasicas.resta(request.getParameter("num1"),request.getParameter("num2") ) %><br>
            <strong> ${param.num1} * ${param.num2} = </strong> <%= OpBasicas.producto(request.getParameter("num1"),request.getParameter("num2") ) %><br>
            <strong> ${param.num1} / ${param.num2} = </strong> <%= OpBasicas.division(request.getParameter("num1"),request.getParameter("num2") ) %><br>
            <strong> ${param.num1} % ${param.num2} = </strong> <%= OpBasicas.residuo(request.getParameter("num1"),request.getParameter("num2") ) %><br>
        </p>
    </body>
</html>
