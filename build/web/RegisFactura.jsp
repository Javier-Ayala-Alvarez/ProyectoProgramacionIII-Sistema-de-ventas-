<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

<%@page import ="modelo.entidades.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/bulma.min.css"/>

<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

  <table border="0" class="reporte">
    <tr><td> <form action="ReporteGrafiVenta.jsp"><div class="field has-addons">
                            <div class="control is-expanded">
                                <div class="select is-fullwidth">
                                    <select name="anios">
                                        <%
                                            int id = 0;
                                            List<Venta> año = (List<Venta>) request.getAttribute("fecha");
                                            for (Venta regis : año) {
                                                id = regis.getAño();
                                        %>
                                        <option value="<%= regis.getAño()%>"> <%= regis.getAño()%></option>
                                        <%}%>
                                    </select>
                                </div>
                            </div>
                            <div class="control">
                                <button type="submit" class="button is-primary"><img src="img/impresora.png"/></button>
                            </div>
                        </div>
                    </form></td></tr>
</table>
        <table border="0" class="TABLE3">
            
    <TR>
        <TD COLSPAN="5" ALIGN="CENTER" bgcolor="#fff">

            <H1>
                <font  color="#B76103" > 
                Ventas Diarias </H1><TR><TD bgcolor="#3EB429" >
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



