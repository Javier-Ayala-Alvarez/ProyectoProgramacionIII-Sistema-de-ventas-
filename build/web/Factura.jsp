
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Venta"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/EstiloFactura.css">

<link rel="stylesheet" href="css/bulma.min.css"/>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Factura</title>
</head>
<body>
    <!-- OPCCIONES ... -->
    <nav>
        <ul>
             <!-- Boton pata nuevaFactura ... -->
            <li> <input type="submit" name="ReFactura" value="Nueva Factura" id="datosGenerales" class="btn-enviar "></li>
            <li>
                 <!-- Boton para cerrar Factura... -->
                <form action="index.html" method="post">
                    <input type="submit" name="ReFactura" value="Cerrar" class="btn-enviar">

                </form>
            </li>
        </ul>
    </nav>
    <div class="columns" id="datosCliente">
            <!-- MUESTRA DATOS Cliente Fecha y Empleado... -->
    </div>
    <!-- FORMULARIO DE LA FACTURA ... -->
    <div class="columns" id="datosGenerales1" >
        <!-- MUESTRA DATOS GENERALES ... -->
    </div>
    <!-- VENTANA MODAL PRODUCTO ... -->
    <div class="modal" id="vent">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">PRODUCTO</p>
                <form  action="javascript:cerrarProducto()" method="post">
                     <!-- Boton para cerrar ventana Modal ... -->
                    <button class="delete" aria-label="close" id="cerrar"></button>
                </form>
            </header>
            <section class="modal-card-body">
                <!-- Content ... -->
                <div class="columns" id="producto">
                    <div class="column"  >
                        <!-- Muestra Productos---------------- ... -->
                        </section>
                        <footer class="modal-card-foot">
                            <button class="button is-success agregarProducto">Recargar</button>
                            <!-- Boton para cerrar ventana Modal ... -->
                            <form  action="javascript:cerrarProducto()" method="post">
                                <button class="button">Cancel</button>
                            </form>
                        </footer>
                    </div>
                </div>

                <!-- VENTANA MODAL Cliente ... -->

                <div class="modal" id="ventClien">
                    <div class="modal-background"></div>
                    <div class="modal-card">
                        <header class="modal-card-head">
                            <p class="modal-card-title ">CLIENTE</p>
                            <!-- Boton para cerrar ventana Modal ... -->
                            <form  action="javascript:cerrarCliente()" method="post">
                                <button class="delete" aria-label="close" id="cerrar"></button>

                            </form>
                        </header>
                        <section class="modal-card-body">
                            <!-- Content ... -->
                            <div class="columns">
                                <div class="column">FORMULARIO DE INSCRIPCION</div>
                            </div>
                            <div id="data2"> </div>
                            <!-- Muestra El formulario---------------- ... -->  

                        </section>
                        <footer class="modal-card-foot">
                            <!-- Boton para Recargar los datos... -->
                            <button class="button is-success btn_Cliente1">Recargar</button>
                            <!-- Boton para cerrar ventana Modal ... -->
                            <form  action="javascript:cerrarCliente()" method="post">
                                <button class="button">Cancel</button>
                            </form>

                        </footer>
                    </div>
                </div>
        <!-- Funciones para abrir o cerrar ventanas modales ... -->
                <script src="Ajax1.js"></script> 
                <script>

                    function abrirProducto() {
                        document.getElementById("vent").style.display = "block";
                    }
                    function cerrarProducto() {
                        document.getElementById("vent").style.display = "none";

                    }
                    function abrirCliente() {
                        document.getElementById("ventClien").style.display = "block";
                    }
                    function cerrarCliente() {
                        document.getElementById("ventClien").style.display = "none";

                    }
                </script>

                <!-- TABLA DE LA FACTURA... -->  

                <section class ="section">

                    <div class="columns" id="tablaregistro">

                    </div>
                    </body>


                    </html>


