<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

<%@page import ="modelo.entidades.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

  
        <table border="0" class="TABLE3">
            
    <TR>
        <TD COLSPAN="15" ALIGN="CENTER" bgcolor="#fff">

            <H1>
                <font  color="#B76103" > 
                Ventas Diarias</H1><TR><TD bgcolor="#3EB429" >
            <H4 ><font color="#fff">Nº FACTURA<TD bgcolor="#3EB429" >
                    <H4><font color="#fff">FECHA<TD bgcolor="#3EB429" >
                            <H4><font color="#fff">CLIENTE<TD bgcolor="#3EB429" >
                                    <H4><font color="#fff">VENDEDOR<TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">TOTAL</TD>
                                                <TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">DETALLE</TD>
                                                
                                                 <%
                                                        List<Venta> lstVenta = (List<Venta>) request.getAttribute("ventasList");
                                                        for (Venta registro : lstVenta) {
                                                    %>
                                                <TR>

                                                   

                                                    <td align="center">

                                                        <%= registro.getnFactura()%>
                                                    </td>
                                                    <td align="center">
                                                        <%= registro.getFechaVenta()%>

                                                    </td>

                                                    <td align="center">
                                                        <%= registro.getCliente().getNombre()+" "+registro.getCliente().getApellido()%>

                                                    </td>

                                                    <td align="center">

                                                        <%= registro.getEmpleado().getNombre() +" "+  registro.getEmpleado().getApellido() %>
                                                    </td>
                                                    <td align="center">

                                                        $ <%= String.format("%.2f", registro.getSaldoTotal())%>
                                                    </td>
                                                    <td align="center">
                                                        
                                                        <a href="ControlDetalleVen?id=<%= registro.getnFactura()%>"><img src="img/registro.png"/></a>
                                                        <a href="ReporteImpreso.jsp?id=<%= registro.getnFactura()%>"><img src="img/impresora.png"/></a>
                                                    </td>
                                                   
                                                    <%} %></tr>
                                                    </table>



