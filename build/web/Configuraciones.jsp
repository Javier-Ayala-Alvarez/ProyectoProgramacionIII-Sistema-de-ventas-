<%@page import="modelo.entidades.Empresa"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">
<link rel="stylesheet" href="css/bulma.min.css"/>
<%@page import ="modelo.entidades.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Inicio.jsp"%>
<!DOCTYPE html>

<%
    List<Empresa> registroList = (List<Empresa>) request.getAttribute("registroList");
    for (Empresa registro : registroList) {
%>
<div class="columns">
    <table class="TABLEconfiguraciones">
        
       
            
            <tr>
                <TD COLSPAN="15" ALIGN="CENTER" bgcolor="#fff">
                    <H1>
                        <font  color="#B76103" > 
                        CONFIGURACIONES</H1>
                        </td></tr><tr><td >
                     <form action="ControlConfiguraciones" method="post">
                    <div class="column ">
                        

                        Codigo<input type='text'  name='código' value="<%= registro.getCodigoEmpresa()%>" class='input is-link'  readonly/>
                        Nombre <input type='text'  name='nombre' value="<%= registro.getNombre()%>" class='input is-link'/>
                    </div>   
                    <div class="column">
                        Direccion<input type='text'  name='dirección' value="<%= registro.getDireccion()%>" class='input is-link'/>
                        Correo <input type='text'  name='correo' value="<%= registro.getCorreo()%>" class='input is-link'/>
                        <%}%>
                    </div> 
                    <div class="column">
                       
                        <input type="submit" name="btn_Actualizar" value="Actualizar" class="button is-success is-active">
                    </div> 
                </td></tr>
        </from>
    </table>
</div>





