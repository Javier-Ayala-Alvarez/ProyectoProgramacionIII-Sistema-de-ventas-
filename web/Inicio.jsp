
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
            <TABLE  CLASS="TABLE" align="left">
                <TR><TD align="center">
                        <font color="#fff"> <h2 align="center"> bienvenido</h2>

                        <img src='img/dottt.jpg' class='imgRedonda' />
                        <font color="red"><h2 align="center" class="letra"> <%=request.getAttribute("codigo1")%> </h2>
                        <FORM action="index.jsp" method="POST">

                            <input type="submit" name="BOTON" value="Cerrar Sesion"class="btn-enviar">
                        </FORM>
                        <FORM action="Inicio.jsp" method="POST">

                            <input type="submit" name="BOTON" value="Inicio"class="btn-enviar">
                        </FORM>
                <tr><td align="center">


            </TABLE>

            <nav >
                <ul>

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
                        </ul>
                    </li>
                </ul>
                </li>
            </nav>
    </div>
</center></ul></li></center></ul></li></center>
