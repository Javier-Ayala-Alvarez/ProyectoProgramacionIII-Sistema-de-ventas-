<%-- 
    Document   : Factura
    Created on : 10-01-2021, 06:23:30 PM
    Author     : Francisco Javier
--%>
<link rel="stylesheet" type="text/css" href="css/EstiloFactura.css">
<link rel="stylesheet" href="css/bulma.min.css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

    <nav>
        <ul>
            <li>
                <form  method="post">
                    <input type="submit" name="ReFactura" value="Producto" class="btn-enviar">
                </form>
            </li>
            <li>
                <form action="" method="post">
                    <input type="submit" name="ReFactura" value="Cliente" class="btn-enviar">
                </form>
            </li>
            <li>
                <form action="index.html" method="post">
                    <input type="submit" name="ReFactura" value="Cerrar" class="btn-enviar">
                </form>
            </li>
        </ul>

        <div class="columns">
            <div  class="form-register">
                <table><tr ><td><td><td><td ><td><td><td><td><td align="center">N° Factura<td>
                            <form >
                                <input type="text"  name="Usuario" placeholder="Numero Factura" class="input is-success" />               

                        </td></tr><tr ><td class="column is-one-third">
                            Cliente:</td><td> <input type="text"  name="Usuario" placeholder="Nombre" class="input is-success"/></td> 
                        <td align="right">
                            <input type="submit" name="ReFactura" value="buscar" class="button is-success is-active"></td>
                        <td  class="column is-one-third">
                            Direcion:</td><td> <input type="text"  name="Usuario" placeholder="Direccion Cliente" class="input is-success " /></td>
                        <td class="column is-one-third">
                            Fecha:</td><td> <input type="date"  name="Usuario" placeholder="Fecha" class="input is-success"  /></td></tr><tr>
                        <td class="column is-one-third">
                            Producto:</td><td><input type="text"  name="Usuario" placeholder="Producto" class="input is-success" /></td>
                        <td>
                            <input type="submit" name="ReFactura" value="buscar" class="button is-success is-active"></td>
                        <td class="column is-one-third">
                            Cantidad:</td><td> <input type="number"  name="Usuario" placeholder="Cantidad" class="input is-success"  /></td>
                        <td align="center">
                            Precio Unitario:</td><td> <input type="text"  name="Usuario" placeholder="Precio Unitario" class="input is-success"/></td>
                        <td align="center">
                            Precio Total: </td><td><input type="text"  name="Usuario" placeholder="Precio Total" class="input is-success" /></td>
                        <td align="center">
                            <input type="submit" name="ReFactura" value="Agregar a Carrito" class="button is-link is-active"></td></tr>

                    </form>

                </table>
            </div>
        </div>

    </nav>


    <section class ="section">

        <div class="contanier">

            <div class="TABLE3">
                <table  class="table is-fullwidth">
                    <TR><TD bgcolor="#3EB429" >
                            <H4 ><font color="#fff">N°<TD bgcolor="#3EB429" >
                                    <H4 ><font color="#fff">CODIGO<TD bgcolor="#3EB429" >
                                            <H4><font color="#fff">PRODUCTO<TD bgcolor="#3EB429" >
                                                    <H4><font color="#fff">PRECIO<TD bgcolor="#3EB429" >
                                                            <H4><font color="#fff">CANTIDAD<TD bgcolor="#3EB429" >
                                                                    <H4><font color="#fff">TOTAL</TD><TD bgcolor="#3EB429" >
                                                                            <H4><font color="#fff">OPCCIONES</TD>
                                                                                <tr>


                                                                                    <td align="center">

                                                                                        4
                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>

                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>

                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4 

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4 

                                                                                    </td>


                                                                                <tr>


                                                                                    <td align="center">

                                                                                        4
                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>

                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>

                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4 

                                                                                    </td>
                                                                                    <td align="center">
                                                                                        4 

                                                                                    </td>

                                                                                </tr>
                                                                                </table>  </div>  </div>  </div>



                                                                                <div  class="form-register1">
                                                                                    <table><tr><td>
                                                                                                <form >
                                                                                                    <td><input type="submit" name="ReFactura" value="Facturar" class="button is-link is-active ">
                                                                                                    <td ><input type="submit" name="ReFactura" value="Cancelar" class="button is-danger">
                                                                                                    <td class="column is-one-third"> Total: <td><input type="text"  name="Usuario" placeholder="Total" class="input is-success"/>                                                                                                
                                                                                                </form>
                                                                                            </td></tr>
                                                                                    </table>
                                                                                </div>
                                                                                </body>

                                                                                </html>
