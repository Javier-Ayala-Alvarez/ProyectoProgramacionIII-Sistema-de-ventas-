var READY_STATE_COMPLETE = 4;   
var request, datos;
//referencia del formulario
datos = document.forms["Cliente"];
//asignar escucha//

datos.addEventListener("submit",cargarContenido,false);

function cargarContenido(event){
    event.preventDefault();
    inicializarXHMHttpRequest();
    request.onreadystatechange = procesaRespuesta;
    request.open("POST","ControlCliente",true);
    request.setRequestHeader("content-type","application/x-www-form-urlencoded")
    request.send(crear_query_string());
     datos.reset();
   
   
    
}
function inicializarXHMHttpRequest(){
    
    request = new XMLHttpRequest();
    
}
function procesaRespuesta(){
   
    if(request.readyState === READY_STATE_COMPLETE & request.status === 200){
        alert("Agregado con exito");
        
        console.log(request.response);
    }
    
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


