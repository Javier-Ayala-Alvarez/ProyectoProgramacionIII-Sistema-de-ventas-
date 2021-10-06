     


    //declarar Variables
var READY_STATE_COMPLETE = 4;
var request, datos;
//referencia del formulario
datos = document.getElementById("Cliente");
//asignar escucha//

datos.addEventListener("submit",cargarContenido,true);

function cargarContenido(event){
    event.preventDefault();
    inicializarXHMHttpRequest();
    request.onreadystatechange = procesaRespuesta();
    request.open("POST","ControlCliente",true);
    request.setRequestHeader("content-type","application/x-www-form-urlencoded")
    request.send(crear_query_string());
   
   
    
}
function inicializarXHMHttpRequest(){
    request = new XMLHttpRequest();
    
}
function procesaRespuesta(){
    if(request.readyState === READY_STATE_COMPLETE & request.status === 2000){
        console.log(request.response);
    }
    
}
function crear_query_string(){
    let codigo = datos.elements["codigo"].value;
    let nombre = datos.elements["nombre"].value;
    let apellido = datos.elements["apellido"].value;
    let telefono = datos.elements["telefono"].value;
    let direccion = datos.elements["direccion"].value;
    return "codigo="+encodeURL(codigo) +
            "&nombre="+encodeURL(nombre) +
            "&apellido="+encodeURL(apellido) +
            "&telefono="+encodeURL(telefono) +
            "&direccion="+encodeURL(direccion);
   
}


