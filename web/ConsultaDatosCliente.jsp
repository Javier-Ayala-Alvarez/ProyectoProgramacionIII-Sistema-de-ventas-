<%-- 
    Document   : ConsultaDatosCliente
    Created on : Sep 29, 2021, 2:58:51 PM
    Author     : gerar
--%>
<%@page import ="java.util.List"%>
<%@page import ="modelo.entidades.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="recursos/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="recursos/css/core.css">
        <link href="recursos/css/font-awesome.css" rel="stylesheet">
        <link href="recursos/css/table.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="recursos/css/responsive.css">
        <script type="text/javascript" src="recursos/js/jquery.js"></script>
        <script type="text/javascript" src="recursos/js/bootstrap.js"></script>
    </head>
    <body>
        <form>
            <div class="container-fluid">
                <table  class="table table-responsive table-bordered navbarResponsive" 
                       width ="100%" id="dataTable" cellspacing="0">
                    <thead>
                        <tr class="table table-bordered table-responsive">
                            <th> ID</th>
                            <th>Codigo de Cliente</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Direccion</th>
                        </tr>
                    </thead>
                    <tbody>
            
            <%
            List<Cliente> lstClientes = (List<Cliente>) request.getAttribute("listaClientes");
            for (Cliente registro: lstClientes) {
            %>
            <tr class="table table-bordered table-responsive">
                <td><%= registro.getIdCliente()%></td>
                <td><%= registro.getCodigoCliente()%></td>
                <td><%= registro.getNombre()%></td>
                <td><%= registro.getApellido()%></td>
                <td><%= registro.getTelefono()%></td>
                <td><%= registro.getDireccion()%></td>
               
            </tr>
                
            
            
            <%} %>
            </tbody>
            </table>
            </div>
            <script src="js/bootstrap.min.js" type="text/javascript"></script>
            <script src="vendor/datatables/jquery.dataTables.js"></script>
            <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
            <script src="recursos/js/sb-admin-datatables.min.js"></script>
            
        
        
        </form>
    </body>
</html>