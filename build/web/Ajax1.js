var READY_STATE_COMPLETE = 4;
var request, datos;
//referencia del formulario


//asignar escucha//
//Muestra los clientes en la vista de clientes en factura y ademas agrega uno nuevo//
$("#btn_agregar").click(function (e) {
    datos = document.forms["Cliente"];
    datos.addEventListener("submit", cargarContenido, false);
    MostrarCliente();
    MostrarFormularioCliente();
})
////Muestra los clientes en la vista de clientes en factura//
$("#btn_Cliente1").click(function (e) {
    MostrarCliente();
    MostrarFormularioCliente();
})
//Muestra los productos en la vista de producto en factura//
$("#btn_Producto").click(function (e) {
    MostrarProducto();
})
//Agrega los datos generales en la vista de factura//
$("#datosCliente1").click(function (e) {
    datosGeneralesProducto1();
     MostrarFormularioCliente();
})

//Escucha el evento de agregar cliente a la vista principal//
$(document).on('click', '.agregarCliente', function (e) {
    e.preventDefault();

    var codigoCliente = $(this).parent().parent().children().first().text();

    $.ajax({

        url: "ControladorProducto", type: 'POST', data: 'btn=4' + '&event=1&codigo=' + codigoCliente,
        success: function (data) {
            $("#datosGenerales").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//Escucha el evento de agregar Producto a la vista principal//
$(document).on('click', '.agregarProducto', function (e) {
    e.preventDefault();

    var codigoProducto = $(this).parent().parent().children().first().text();

    $.ajax({

        url: "ControladorProducto", type: 'POST', data: 'btn=4&event=2' + '&codigoproduc=' + codigoProducto,
        success: function (data) {
            $("#datosGenerales").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});


//Elimina los clientes//
$(document).on('click', '.btn_Eliminar', function (e) {
    e.preventDefault();
    
 var codigoCliente = $(this).parent().parent().children().first().text();
    var opcion = confirm("Deseas eliminar el cliente "+codigoCliente+"?");
    if (opcion == true) {
       
        $.ajax({
            //trabajando

            url: "ControlCliente", type: 'POST', data: 'event=1'+'&Eliminar=' + codigoCliente,
            
        });

    }

});


//Enviara el codigoCliente y el codigoProducto null para poder mostrar la tabla de ingresos//
function datosGeneralesProducto1() {
    $.ajax({

        url: "ControladorProducto", type: 'POST', data: 'btn=4' + '&event=0',
        success: function (data) {

            $("#datosGenerales").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });


}
//Recargara los registro de cliente//
function cargarContenido(event) {

    event.preventDefault();
    inicializarXHMHttpRequest();
    alert("Agregado con exito");
    request.open("POST", "ControlCliente", true);
    request.setRequestHeader("content-type", "application/x-www-form-urlencoded")
    request.send(crear_query_string());
    datos.reset();

}
function inicializarXHMHttpRequest() {

    request = new XMLHttpRequest();
    MostrarCliente();
}
//Recive la respuesta segun el estado//
function procesaRespuesta() {
    if (request.readyState === READY_STATE_COMPLETE & request.status === 200) {
        alert("Agregado con exito");


    }

}
//Enviara datos para recibir el muestreo de loc clientes
function MostrarCliente() {
    $.ajax({

        url: "ControlCliente", type: 'POST', data: 'btn=4&event=0',
        success: function (data) {
            $("#data1").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

}
function MostrarFormularioCliente() {
    $.ajax({

        url: "ControlCliente", type: 'POST', data: 'btn=4&event=2',
        success: function (data) {
            $("#data2").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

}
//enviara datos para poder mostrar los productos//
function MostrarProducto() {
    $.ajax({

        url: "ControlProducto", type: 'POST', data: 'btn=4',
        success: function (data) {
            $("#producto").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

}
//crear las variables para enviar el formulario//
function crear_query_string() {


    let nombre = datos.elements["nombre"].value;
    let apellido = datos.elements["apellido"].value;
    let telefono = datos.elements["telefono"].value;
    let direccion = datos.elements["direccion"].value;
    

    return  "nombre=" + encodeURI(nombre) +
            "&apellido=" + encodeURI(apellido) +
            "&telefono=" + encodeURI(telefono) +
            "&direccion=" + encodeURI(direccion) +
            "&btn_agregar=1" ;

}


