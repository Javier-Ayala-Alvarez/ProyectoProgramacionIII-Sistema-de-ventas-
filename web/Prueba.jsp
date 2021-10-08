<%-- 
    Document   : Prueba
    Created on : 10-08-2021, 08:32:52 AM
    Author     : Francisco Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <form>  
        <% int a = 0; %>
        <% int b = 10;%>
        <h1><%=(a >= b) ? "a es mayor" : "b es mayor"%> </h1>
        </br>
        <div class="inputform">
            <label>VALOR DE A</label>
            <input type="text" name="valorA" 
                   value="<%=(a == 0) ? "VACIO" : a%>" >
        </div>               
    </form>  
