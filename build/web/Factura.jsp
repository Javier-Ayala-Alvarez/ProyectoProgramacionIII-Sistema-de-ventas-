
<%@page import="java.util.List"%>
<%@page import="modelo.entidades.Venta"%>

<script src="jquery-latest.js"></script>
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
            
            
            <li> <input type="submit" name="ReFactura" value="Nueva Factura" id="datosCliente1" class="btn-enviar"></li>
        
            
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
        </nav>
<!-- FORMULARIO DE LA FACTURA ... -->
        <div class="columns" id="datosGenerales" >
           
            
<!-- MUESTRA DATOS GENERALES ... -->
            
        </div>
<!-- VENTANA MODAL PRODUCTO ... -->
    
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
      <div class="columns" id="producto">
            <div class="column"  >
<!-- Muestra Productos---------------- ... -->
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
      <div id="data2"> </div>
        <!-- Muestra El formulario---------------- ... -->  
      
      <div class="columns">
          <div class="column">DATOS ALMACENADOS</div>
      </div>
     <div class="columns"  id="data1">
            <div class="contanier" >
<!-- Muestra Cliente en la tabla---------------- ... -->
    </section>
    <footer class="modal-card-foot">
      <button class="button is-success" id="btn_Cliente1">Recargar</button>
       <form  action="javascript:cerrarCliente()" method="post">
      <button class="button">Cancel</button>
      </form>
      
    </footer>
  </div>
</div>
          <script>
	
</script>
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

                                                                               
