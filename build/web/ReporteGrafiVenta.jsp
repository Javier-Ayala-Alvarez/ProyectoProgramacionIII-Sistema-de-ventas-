<%-- 
    Document   : ReporteProducto
    Created on : 11-17-2021, 09:25:53 PM
    Author     : Francisco Javier
--%>

<%@page import="java.util.Map"%>
<%@page import="modelo.conexion.Conexion"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>  <%  Conexion conexion = new Conexion();

            File reporfile = new File(application.getRealPath("reporte/GraficaVenta.jasper"));
            Map parameter = new HashMap();
            parameter.put("anio", Integer.parseInt(request.getParameter("anios")));
            byte[] bytes = JasperRunManager.runReportToPdf(reporfile.getPath(), parameter, conexion.getConexion());

            response.setContentType("Producto.pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outpouststream = response.getOutputStream();
            outpouststream.write(bytes, 0, bytes.length);
            outpouststream.flush();
            outpouststream.close();%></h1>
    </body>
</html>
