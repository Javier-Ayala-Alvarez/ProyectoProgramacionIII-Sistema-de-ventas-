<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

<%@page import ="modelo.entidades.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

<table border="3" class="TABLE3">
    <TR>
        <TD COLSPAN="15" ALIGN="CENTER" bgcolor="#fff">

            <H1>
                <font  color="#B76103" > 
                Facturas</H1><TR><TD bgcolor="#3EB429" >
            <H4 ><font color="#fff">CODIGO<TD bgcolor="#3EB429" >
                    <H4><font color="#fff">FECHA<TD bgcolor="#3EB429" >
                            <H4><font color="#fff">CLIENTE<TD bgcolor="#3EB429" >
                                    <H4><font color="#fff">VENDEDOR<TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">TOTAL</TD>
                                                <TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">OPCIONES</TD>
                                                
                                                 <%
                                                        List<Venta> lstVenta = (List<Venta>) request.getAttribute("ventasList");
                                                        for (Venta registro : lstVenta) {
                                                    %>
                                                <TR>

                                                   

                                                    <td>

                                                        <%= registro.getnFactura()%>
                                                    </td>
                                                    <td>
                                                        <%= registro.getFechaVenta()%>

                                                    </td>

                                                    <td>
                                                        <%= registro.getCliente()%>

                                                    </td>

                                                    <td>

                                                        <%= registro.getEmpleado()%>
                                                    </td>
                                                    <td>

                                                        <%= registro.getSaldoTotal()%>
                                                    </td>
                                                    <td>

                                                        <input type="submit" name="detalle" value="detalle" class="btn-enviar">  

                                                    </td>
                                                   
                                                    <%} %></tr>
                                                    </table>



