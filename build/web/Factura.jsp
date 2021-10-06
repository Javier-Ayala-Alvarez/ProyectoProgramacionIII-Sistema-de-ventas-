
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Venta"%>
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
            <li>
                <form  action="javascript:abrirProducto()" method="post">
                    <input type="submit" name="ReFactura" value="Producto" class="btn-enviar">
                </form>
            </li>
            <li>
                <form action="javascript:abrirCliente()" method="post">
                    <input type="submit" name="ReFactura" value="Cliente" class="btn-enviar">
                </form>
            </li>
            <li>
                <form action="index.html" method="post">
                    <input type="submit" name="ReFactura" value="Cerrar" class="btn-enviar">
                </form>
            </li>
        </ul>
<!-- FORMULARIO DE LA FACTURA ... -->
        <div class="columns">
            <div  class="form-register">
                <table><tr ><td><td><td><td ><td><td><td><td><td align="center">N° Factura<td>
                            <form >
                                <input type="text"  name="Usuario" placeholder="Numero Factura" class="input is-success" />               

                        </td></tr><tr ><td class="column is-one-third">
                            Cliente:</td><td> <input type="text"  name="Usuario" placeholder="Nombre" class="input is-success"/></td> 
                        <td align="right">
                            <button class="button is-success is-active"><a href="javascript:abrirCliente()">Buscar</</a></button></td>
                        <td  class="column is-one-third">
                            Direcion:</td><td> <input type="text"  name="Usuario" placeholder="Direccion Cliente" class="input is-success " /></td>
                        <td class="column is-one-third">
                            Fecha:</td><td> <input type="date"  name="Usuario" placeholder="Fecha" class="input is-success"  /></td></tr><tr>
                        <td class="column is-one-third">
                            Producto:</td><td><input type="text"  name="Usuario" placeholder="Producto" class="input is-success" /></td>
                        <td>
                            <button class="button is-success is-active"><a href="javascript:abrirProducto()">Buscar</a></button></td> 
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
<!-- VENTANA MODAL PRODUCTO ... -->
    </nav>
<div class="modal" id="vent">
  <div class="modal-background"></div>
  <div class="modal-card">
    <header class="modal-card-head">
      <p class="modal-card-title">PRODUCTO</p>
      <form  action="javascript:cerrarProducto()" method="post">
      <button class="delete" aria-label="close" id="cerrar"></button>
      </form>
    </header>
    <section class="modal-card-body">
      <!-- Content ... -->
      <div class="columns">
            <div class="column">
         <table  class="table is-fullwidth" >
         <TR><TD>
         <H4 ><font color="blue">CODIGO<TD>
          <H4><font color="blue">PRODUCTO<TD>
          <H4><font color="blue">PRECIO<TD >
          <H4><font color="blue">CANTIDAD<TD>
          <H4><font color="blue">SELECCIONAR</TD>
              <tr><td>w</td>
                  <td>w</td>
                  <td>w</td>
                  <td>w</td>
                  <td><button class="button is-danger is-outlined"><a href="javascript:abrirProducto()">AGREGAR</a></button></td></tr>
      </table>
    </section>
   <footer class="modal-card-foot">
      Debe Seleccionar un registro
    </footer>
  </div>
</div>
    
    <!-- VENTANA MODAL Cliente ... -->
    
<div class="modal" id="ventClien">
  <div class="modal-background"></div>
  <div class="modal-card">
    <header class="modal-card-head">
      <p class="modal-card-title">CLIENTE</p>
      <form  action="javascript:cerrarCliente()" method="post">
      <button class="delete" aria-label="close" id="cerrar"></button>
      
      </form>
    </header>
    <section class="modal-card-body">
      <!-- Content ... -->
      <div class="columns">
          <div class="column">FORMULARIO DE INSCRIPCION</div>
      </div>
      <form name="Cliente" method="post">
      <div class="columns" >
         
          <div class="column">
            NOMBRE: <input type="text"  name="nombre" placeholder="Apellido" class="input is-link" pattern="[A-Za-z]+"  required/> 
          </div>
          <div class="column">
           APELLIDO: <input type="text"  name="apellido" placeholder="Telefono" class="input is-link" pattern="[A-Za-z]+"  required/> 
          </div>
      </div>
      <div class="columns">
          <div class="column">
            TELEFONO: <input type="text"  name="telefono" placeholder="Telefono"  class="input is-link" pattern="[0-9]+" minlength="8" maxlength="8" required /> 
          </div>
          <div class="column">
            DIRECCION: <input type="text"  name="direccion" placeholder="Direccion" class="input is-link"  required/> 
          </div>
          <div class="column is-one-third">
              
            AGREGAR <input type="submit" name="btn_agregar" value="Nuevo" class="button is-link is-active is-fullwidth">
            </form>
          </div>
      </div>
      <div class="columns">
          <div class="column">DATOS ALMACENADOS</div>
      </div>
     <div class="columns">
            <div class="contanier">
                <div id="tabla"></div>
         <table  class="table is-fullwidth" >
         <TR bgcolor="#3EB429" ><TD>
         <H4 ><font color="#FFF">CODIGO<TD>
          <H4><font color="#FFF">NOMBRE<TD>
          <H4><font color="#FFF">APELLIDO<TD>
          <H4><font color="#FFF">TELEFONO<TD>
          <H4><font color="#FFF">DIRECCION<TD>
          <H4><font color="#FFF">SELECCIONAR</TD>
              
            
              <tr><td>i</td>
                  <td>w</td>
                  <td>w</td>
                  <td>w</td>
                  <td>W</td>
                
                  <td><button class="button is-danger is-outlined"><a href="javascript:abrirProducto()">AGREGAR</a></button></td></tr>
      </table>

    </section>
    <footer class="modal-card-foot">
      <button class="button is-success">Guardar</button>
      <button class="button">Cancel</button>
    </footer>
  </div>
</div>
   <script src="Ajax1.js"></script> 
      <script>
            
function abrirProducto(){
            document.getElementById("vent").style.display="block";
        }
function cerrarProducto(){
        document.getElementById("vent").style.display="none";
    
}
function abrirCliente(){
            document.getElementById("ventClien").style.display="block";
        }
function cerrarCliente(){
        document.getElementById("ventClien").style.display="none";
        
    }    
</script>

       
    
    
    
    
    
    
    
    
    
  <!-- TABLA DE LA FACTURA... -->  
    
    <section class ="section">

        <div class="columns">
<div class="column">
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
                                                                                       <button class="button is-danger is-outlined"><a href="javascript:abrirProducto()">Eliminar</a></button>

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
                                                                                        <button class="button is-danger is-outlined"><a href="javascript:abrirProducto()">Eliminar</a></button> 

                                                                                    </td>

                                                                                </tr>
                                                                                </table>  </div>  </div>

<!-- TOTALES DE LA FACTURA ... -->

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

                                                                               
