var READY_STATE_COMPLETE = 4;   
var request, datos;
//referencia del formulario


//asignar escucha//
$("#btn_Cliente").click(function(e){
datos = document.forms["Cliente"] ;
datos.addEventListener("submit",cargarContenido,false);
 MostrarCliente();
})
$("#btn_Cliente1").click(function(e){
 MostrarCliente();
})

$("#btn_Producto").click(function(e){
 MostrarProducto();
})
$(document).on('click', '.agregarCliente',function(e){
    e.preventDefault();
   var row = $(this).parent().parent().children().first().text();
   alert("Se hizo un click"+row);
   console.log(row);
});


$("#btn_Eliminar").click(function(e){
  $.ajax({
       //trabajando
        url:"ControlCliente", type:'POST', data: 'btn=4&Eliminar=',
        success:function (data){
            $("#data1").html(data);
        },error:function(xml,data){swal('Mensaje del sistema','Error','error');}
        
    });
})

function cargarContenido(event){
    
    event.preventDefault();
    inicializarXHMHttpRequest();
  alert("Agregado con exito");
    request.open("POST","ControlCliente",true);
    request.setRequestHeader("content-type","application/x-www-form-urlencoded")
    request.send(crear_query_string());
     datos.reset();
   
}
function inicializarXHMHttpRequest(){
    
    request = new XMLHttpRequest();
    MostrarCliente();
}
function procesaRespuesta(){
    if(request.readyState === READY_STATE_COMPLETE & request.status === 200){
        alert("Agregado con exito");
        
        
    }
    
}

function MostrarCliente(){
   $.ajax({
       
        url:"ControlCliente", type:'POST', data: 'btn=4',
        success:function (data){
            $("#data1").html(data);
        },error:function(xml,data){swal('Mensaje del sistema','Error','error');}
        
    });
    
}
function MostrarProducto(){
   $.ajax({
       
        url:"ControlProducto", type:'POST', data: 'btn=4',
        success:function (data){
            $("#producto").html(data);
        },error:function(xml,data){swal('Mensaje del sistema','Error','error');}
        
    });
    
}

function crear_query_string(){
 
    
    let nombre = datos.elements["nombre"].value;
    let apellido = datos.elements["apellido"].value;
    let telefono = datos.elements["telefono"].value;
    let direccion = datos.elements["direccion"].value;
    let btn_agregar = datos.elements["btn_agregar"].value;
    
    return  "nombre="+encodeURI(nombre) +
            "&apellido="+encodeURI(apellido) +
            "&telefono="+encodeURI(telefono) +
            "&direccion="+encodeURI(direccion) +
            "&btn_agregar="+encodeURI(btn_agregar);
  
}


