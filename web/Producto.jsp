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
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
           out.println(request.getAttribute("alerta"));
        %>
        <div class="columns">
            <table  class="TABLE3">
                <tr>

                    </td></tr><tr><td >
                        <form action="ControlProductoAdministracion" method="post">
                            <div class="column">
                                Codigó</td><td><input type='text'  name='codigo'  class='input is-link' value="<%=(dato == null) ? request.getAttribute("codigo") : dato.getCodigoProducto()%>" readonly/></td><tr>

                                <td>Nombre</td><td><input type='text'  name='nombre'  class='input is-link' value="<%=(dato == null) ? "" : dato.getNombreProducto()%>" /></td>
                                <td>Precio Compra</td> <td><input type='text'  name='precioCompra' value="<%=(dato == null) ? "" : dato.getPrecioCompra()%>" class='input is-link' /></td>
                                <tr><td>Cantidad</td><td><input type='number'  name='cantidad' value=<%=(dato == null) ? 0 : String.valueOf(dato.getCantidad())%> class='input is-link'/></td>
                                    <td> Fecha de Vencimiento</td><td><input type='date'  name='fecha' class='input is-link'/></td>
                                <tr>
                                    <td>Precio Venta</td><td><input type='text'  name='precioVenta' value="<%=(dato == null) ? "" : dato.getPrecioVenta()%>" class='input is-link'/></td>
                                    <td><td> <input type="submit" name="<%=(dato == null) ? "btn_Guardar" : "btn_ModificarRegistros"%>" value="<%=(dato == null) ? "Guardar" : "Modificar"%>" class="button is-success is-active"></td>
                                </tr>
                                </from>
                                <div class="column">
                                    <table  class="TABLEProducto">

                                        <TR>
                                            <TD ALIGN="CENTER" bgcolor="#3EB429" >

                                            <font color="#fff">Codigó<TD bgcolor="#3EB429" >
                                                <H4><font color="#fff">Nombre<TD bgcolor="#3EB429" >
                                                        <H4><font color="#fff">Precio Compra<TD bgcolor="#3EB429" >
                                                                <H4><font color="#fff">Cantidad<TD bgcolor="#3EB429" >
                                                                        <H4><font color="#fff">Fecha de Vencimiento</TD>
                                                                            <TD bgcolor="#3EB429" >
                                                                                <H4><font color="#fff">Precio Venta</TD>
                                                                                    <TD bgcolor="#3EB429" >
                                                                                        <H4><font color="#fff">Empresa</TD>
                                                                                            <TD bgcolor="#3EB429" COLSPAN="3" align="center">
                                                                                                <H4 ><font color="#fff" >Opccionés</TD>
                                                                                                    <%
                                                                                                        List<Producto> lstProducto = (List<Producto>) request.getAttribute("productoList");
                                                                                                        for (Producto registro : lstProducto) {
                                                                                                    %>
                                                                                                    <TR>
                                                                                                        <td align="center">
                                                                                                            <%= registro.getCodigoProducto()%>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <%= registro.getNombreProducto()%>
                                                                                                        </td>

                                                                                                        <td align="center">
                                                                                                            <%= registro.getPrecioCompra()%>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <%= registro.getCantidad()%>
                                                                                                        </td>
                                                                                                        <td align="center">

                                                                                                            <%= registro.getFechaVencimiento()%>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <%= registro.getPrecioVenta()%>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <%= registro.getEmpresa().getNombre()%>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <form action="ControlProductoAdministracion?id=<%= registro.getCodigoProducto()%>" method="post">
                                                                                                                <input type="submit" name="btn_Modificar" value="Modificar" class="button is-small is-info is-outlined">
                                                                                                            </form>
                                                                                                        </td>
                                                                                                        <td align="center">

                                                                                                            <form action="ControlProductoAdministracion?id=<%= registro.getCodigoProducto()%>" method="post">
                                                                                                                <input type="submit" name="btn_Eliminar" value="Eliminar"  class="button is-small is-danger is-outlined">
                                                                                                            </form>
                                                                                                        </td>
                                                                                                        <td align="center">
                                                                                                            <form action="ControlProductoAdministracion?id=<%= registro.getCodigoProducto()%>" method="post">
                                                                                                                <input type="submit" name="btn_Aumetar" value="Aumetar" class="button is-small button is-success is-outlined">
                                                                                                            </form>
                                                                                                        </td><%}%></tr>

                                                                                                    </table>
                                                                                                    </div>
                                                                                                    </body>
                                                                                                    </html>
