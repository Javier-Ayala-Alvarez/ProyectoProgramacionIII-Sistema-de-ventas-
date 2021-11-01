<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

<%@page import ="modelo.entidades.Registros"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

<table border="3" class="TABLE3" >
    <TR>
        <TD COLSPAN="15" ALIGN="CENTER" bgcolor="#fff">

            <H1>
                <font  color="#B76103" > 
                Registros</H1><TR><TD bgcolor="#3EB429" >
            <H4 ><font color="#fff">CODIGÓ<TD bgcolor="#3EB429" >
                    <H4><font color="#fff">PRODUCTO<TD bgcolor="#3EB429" >
                            <H4><font color="#fff">CANTIDAD<TD bgcolor="#3EB429" >
                                    <H4><font color="#fff">PRECIO<TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">TOTAL</TD>



                                                <%
                                                    List<Registros> registroList = (List<Registros>) request.getAttribute("registroList");
                                                    for (Registros registro : registroList) {
                                                %>
                                                <TR>



                                                    <td align="center">

                                                        <%= registro.getProducto().getCodigoProducto()%>
                                                    </td>
                                                    <td align="center">
                                                        <%= registro.getProducto().getNombreProducto()%>

                                                    </td>

                                                    <td align="center">
                                                        <%= registro.getCantidadProducto()%>

                                                    </td>

                                                    <td align="center">

                                                        <%= registro.getProducto().getPrecioVenta()%>
                                                    </td>
                                                    <td align="center">
                                                        $ <%= String.format("%.2f", registro.getPrecioTotalProducto())%>

                                                    </td>


                                                    <%}%></tr>
                                                </table>



