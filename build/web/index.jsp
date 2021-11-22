<!DOCTYPE html>
<html>
    <script src="jquery-latest.js"></script>
    
    <head>
        
        <meta charset="utf-8">
       
         <%
            out.println(request.getAttribute("alerta"));
        %>
        <link rel="stylesheet" type="text/css" href="css/estiloIndex.css">
        <title>Sistema de Venta</title>
    </head>
    <body class="body">

        <h1>"Sistema de Venta"</h1>
        <h2 class="form__titulo">Inició Sesión</h2>

        <form action="ControlLogin" method="POST" class="form-register">
            <div class="contenedor-inputs">
                <input type="text" required name="Usuario" placeholder="Usuario" class="input" class="ant" />

                <input type="Password" required name="Clave" placeholder="Contraseña" class="input" class="ant2" />

                <input type="submit" value="Entrar" class="btn-enviar" />
               
        </form>
         

    </div>
</body>
<script src="Ajax1.js"></script> 
</html>
