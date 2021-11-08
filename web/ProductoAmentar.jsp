<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Producto"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">
<link rel="stylesheet" href="css/bulma.min.css"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Producto dato = (Producto) request.getAttribute("producto");
            out.println(request.getAttribute("alerta"));
        %>
        <div class="columns">
            <table  class="TABLEconfiguraciones">
                <tr>
                    </td></tr><tr><td >
                        <form action="ControlProductoAdministracion" method="post">
                            <div class="column">
                                Codigó</td><td><input type='text'  name='codigo'  class='input is-link' value="<%=dato.getCodigoProducto()%>" readonly/></td><tr>

                                 <tr>    <td>Nombre</td><td><input type='text'  name='nombre'  class='input is-link' value="<%=dato.getNombreProducto()%>" readonly/></td>
                                  <tr>   <td>Precio Compra</td> <td><input type='text'  name='precioCompra' class='input is-link' required/></td>
                                <tr><td>Cantidad</td><td><input type='number'  name='cantidad' class='input is-link' required/></td>

                                    <tr> <td><td> <input type="submit" name="btn_GuardarAumento" value="Guardar" class="button is-success is-active"></td>
                                </tr>
                                </from>
                                </table
                            </div>
                            </body>
                            </html>
