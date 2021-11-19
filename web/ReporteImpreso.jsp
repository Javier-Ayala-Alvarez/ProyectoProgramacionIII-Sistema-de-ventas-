<%-- 
    Document   : ReporteImpreso
    Created on : 11-17-2021, 10:13:06 AM
    Author     : Francisco Javier
--%>

<%@page import="modelo.entidades.Venta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dao.VentaDao"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.io.File"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  Conexion conexion = new Conexion();
            VentaDao daoVenta = new VentaDao();
            Venta ventasList = new Venta();
            //reporte=JasperCompileManager.compileReport("src/reporte/report1Cliente.jrxml");
            //File reporfile = new File("C:/Users/Francisco Javier/Downloads/UES _ACTIVIDADES/ciclo4/Programacion III/Proyecto/ProyectoProgamacionIII/web/reporte/Factura.jasper");
            File reporfile = new File(application.getRealPath("reporte/Factura.jasper"));
            Map parameter = new HashMap();

            ventasList = daoVenta.getVentaTo1c(request.getParameter("id"));
            parameter.put("codigoFactura", request.getParameter("id"));
            parameter.put("total", ventasList.getSaldoTotal());
            
            byte[] bytes = JasperRunManager.runReportToPdf(reporfile.getPath(), parameter, conexion.getConexion());
            response.setContentType(request.getParameter("id")+".pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outpouststream = response.getOutputStream();
            outpouststream.write(bytes, 0, bytes.length);
            outpouststream.flush();
             outpouststream.close();%>
    </body>
</html>
