var READY_STATE_COMPLETE = 4;
var request, datos;

//Muestra los clientes en la vista de clientes en factura y ademas agrega uno nuevo//
$("#btn_agregar").click(function (e) {
    e.stopImmediatePropagation();
    datos = document.forms["Cliente"];
    datos.addEventListener("submit", cargarContenido, false);

})
////Muestra los clientes en la vista de clientes en factura//
$(".btn_Cliente1").click(function (e) {
    e.stopImmediatePropagation();
    $.ajax({

        url: "ControlCliente", type:'POST', data:'btn=1&event=2',
        success: function (data) {
            $("#data2").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });
   
});
//Muestra los productos en la vista de producto en factura//
$("#btn_Producto").click(function (e) {
    e.stopImmediatePropagation();
   $.ajax({

        url: "ControlProducto", type: 'POST', data: 'btn=4',
        success: function (data) {
            $("#producto").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });
});
//Agrega los datos generales en la vista de factura//
$("#datosGenerales").click(function (e) {
    e.stopImmediatePropagation();
    $.ajax({
        url: "ControladorProducto", type: 'POST', data: '&event=0&cantidad=0',
        success: function (data) {

            $("#datosGenerales1").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });
    
});

//Escucha el evento de agregar cliente a la vista principal//
//$(document).on('click', '.agregarCliente', function (e) {
//    e.preventDefault();
//
//    var codigoCliente = $(this).parent().parent().children().first().text();
//
//    $.ajax({
//
//        url: "ControladorProducto", type: 'POST', data: 'btn=4' + '&event=1&cantidad=0&codigo=' + codigoCliente,
//        success: function (data) {
//            $("#datosGenerales1").html(data);
//        }, error: function (xml, data) {
//            swal('Mensaje del sistema', 'Error', 'error');
//        }
//
//    });
//
//});
var codigoProducto;
$(document).on('click', '.agregarProducto', function (e) {
    e.stopImmediatePropagation();
    e.preventDefault();

     codigoProducto = $(this).parent().parent().children().first().text();

    $.ajax({

        url: "ControladorProducto", type: 'POST', data: 'btn=4' + '&event=2&cantidad=0&codigoproduc=' + codigoProducto,
        success: function (data) {
            $("#datosGenerales1").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});

$(document).on('click', '#registrosProduct', function (e) {
    e.stopImmediatePropagation();
    e.preventDefault();
    $.ajax({
        url: "ControlRegistro", type: 'POST', data: 'btn=4' + '&event=3',
        success: function (data) {
            $("#tablaregistro").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//Escucha el evento de agregar Producto a la vista principal//

     
    $(document).on('keyup','.cantidad',function(e){
        e.stopImmediatePropagation();
    var cantidad = $(".cantidad").val();
            $.ajax({
            url: "ControladorProducto", type: 'POST', data: 'event=2' + '&cantidad=' + cantidad + '&codigoproduc=' + codigoProducto,
                    success: function (data) {
                    $("#datosGenerales1").html(data);
                    }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
            }

        });
    });


//Elimina los clientes//
$(document).on('click', '.btn_Eliminar', function(e) {
    e.preventDefault();
    e.stopImmediatePropagation();
    var codigoCliente = $(this).parent().parent().children().first().text();
    
    var opcion = confirm("Deseas eliminar el cliente " + codigoCliente + "? ");
    if (opcion === true) {
        $.ajax({
            //trabajando
            url: "ControlCliente", type: 'POST', data: 'event=1' + '&Eliminar=' + codigoCliente,
        });

    
    }
});


//Recargara los registro de cliente//
function cargarContenido(event) {

    event.preventDefault();
    inicializarXHMHttpRequest();
    alert("Se a agregado con exito")
    request.open("POST", "ControlCliente", true);
    request.setRequestHeader("content-type", "application/x-www-form-urlencoded")
    request.send(crear_query_string());
    datos.reset();
    
    

}
function inicializarXHMHttpRequest() {

    request = new XMLHttpRequest();
   
}
//Recive la respuesta segun el estado//
function procesaRespuesta() {
    if (request.readyState === READY_STATE_COMPLETE & request.status === 200) {
        alert("Agregado con exito");


    }

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
            "&btn_agregar=1";
    

}


