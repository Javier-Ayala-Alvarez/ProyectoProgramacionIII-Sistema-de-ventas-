<%@page import="modelo.entidades.Cliente"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

<table border="3" class="TABLE3" >
    <TR>
        <TD COLSPAN="15" ALIGN="CENTER" bgcolor="#fff">

            <H1>
                <font  color="#B76103" > 
                CLIENTE</H1><TR><TD bgcolor="#3EB429" >
            <H4 ><font color="#fff">CÓDIGO<TD bgcolor="#3EB429" >
                    <H4><font color="#fff">NOMBRE<TD bgcolor="#3EB429" >
                            <H4><font color="#fff">APELLIDO<TD bgcolor="#3EB429" >
                                    <H4><font color="#fff">TELÉFONO<TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">DIRECCIÓN</TD>



                                                <%
                                                    List<Cliente> registroList = (List<Cliente>) request.getAttribute("registroList");
                                                    for (Cliente registro : registroList) {
                                                %>
                                                <TR>



                                                    <td align="center">

                                                        <%= registro.getCodigoCliente()%>
                                                    </td>
                                                    <td align="center">

                                                        <%= registro.getNombre()%>
                                                    </td>

                                                    <td align="center">
                                                        <%= registro.getApellido()%>

                                                    </td>

                                                    <td align="center">
                                                        <%= registro.getTelefono()%>

                                                    </td>
                                                    <td align="center">
                                                        <%= registro.getDireccion()%>

                                                    </td>


                                                    <%}%></tr>
                                                </table>



