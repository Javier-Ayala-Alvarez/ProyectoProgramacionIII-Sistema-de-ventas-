
<%@page import="modelo.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE HTML> 
<html CLASS="HTML">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/EstiloInicio.css">

        <title>Menu</title>
    </head>
    <div class="contenedor">
        <body> 


            <nav >
                <ul>
                    <li><img src='img/dottt.jpg' class='imgRedonda' class="li1"/></li>
                    <li><a class="li1"></i>Venta</a>
                        <ul>
                            <center>
                                <form action="ControladorVenta" method="post">

                                    <li><input type="submit" name="ReFactura" value="Registro Factura" class="btn-enviar"></li>
                                </form>
                        </ul>
                    </li>
                    <li><a class="li1"></i>Producto</a>
                        <ul>
                            <center>
                                <form action="ControlProductoAdministracion" method="post"> 
                                    <li><input type="submit" name="BOTON" value="producto" class="btn-enviar"></li>
                                </form>
                        </ul>
                    <li><a class="li1"></i></span>Empleado</a>
                        <ul> 
                            <center>
                                <form method="post">
                                    <li><input type="submit" name="BOTON" value="Consulta Empleado" class="btn-enviar"></li>
                                    <li><input type="submit" name="BOTON" value="Añadir Empleado" class="btn-enviar"></li>
                                    <li><input type="submit" name="BOTON" value="Consulta Usuario" class="btn-enviar"></li>
                                    <li><input type="submit" name="BOTON" value="Añadir Usuario" class="btn-enviar"></li>


                                </form>
                        </ul>
                    </li>
                    <li><a class="li1"></i></span>Cliente</a>
                        <ul> 
                            <center>
                                <form action="ControlClienteAdmin" method="post">
                                    <li><input type="submit" name="BOTON" value="Consulta" class="btn-enviar"></li>

                                </form>
                        </ul>
                    </li>
                    <li><a class="li1"></i></span>Pago Sucursa</a>
                        <ul> 
                            <center>
                                <form method="post">
                                    <li><input type="submit" name="BOTON" value="Gasto Administrativo" class="btn-enviar"></li>
                                    <li><input type="submit" name="BOTON" value="Pago de planilla" class="btn-enviar"></li>



                                </form>
                        </ul>
                    </li>
                    <li><a class="li1"></i></span>Configuraciones</a>
                        <ul> 
                            <center>
                                <form action="ControlConfiguraciones" method="post">
                                    <li><input type="submit" name="BOTON" value="Mostrar" class="btn-enviar"></li>
                                </form>
                            </center>
                        </ul>
                    </li>
                
                
                <li>
                    <a class="li1"></i></span>Opcciones</a>
                    <ul>
                        <center>
                        <li><FORM action="index.jsp" method="POST">

                            <input type="submit" name="BOTON" value="Cerrar Sesion"class="btn-enviar">
                        </FORM></li>
                        <li><FORM action="Inicio.jsp" method="POST">

                            <input type="submit" name="BOTON" value="Inicio"class="btn-enviar">
                        </FORM></li>
                        </center>
                        </ul>
                </li>
                </ul>
            </nav>
    </div>

