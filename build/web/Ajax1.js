var READY_STATE_COMPLETE = 4;
var request, datos;
var codigoCliente;
var codigo;
var codigoProducto;

//ControlCliente:  Muestra los registros en la ventana modal cliente y agrega nuevo cliente//
$("#btn_agregar").click(function (e) {
    e.stopImmediatePropagation();
    datos = document.forms["Cliente"];
    datos.addEventListener("submit", cargarContenido, false);

})

////Factura: Muestra los regsitros en la ventana modal Cliente//
$(".btn_Cliente1").click(function (e) {
    e.stopImmediatePropagation();
    $.ajax({

        url: "ControlCliente", type: 'POST', data: 'btn=1&event=2',
        success: function (data) {
            $("#data2").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//Factura: Muestra los productos en la ventana modal producto//
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
//Factura: Muestra el formulario de registros de una factura//
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

//ControlCliente: Al seleccionar un cliente este se agregara al formulario de encabezado de factura//
$(document).on('click', '.agregarCliente', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();
    codigoCliente = $(this).parent().parent().children().first().text();
    $.ajax({

        url: "ControlSeleccionarCDE", type: 'POST', data: 'codigo=' + codigoCliente,

        success: function (data) {
            $("#datosCliente").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });


});
//ControlProducto: Al seleccionar los productos seran mostrados en el encabezado de la fractura//
$(document).on('click', '.agregarProducto', function (e) {
    e.stopImmediatePropagation();
    e.preventDefault();

    codigoProducto = $(this).parent().parent().children().first().text();

    $.ajax({

        url: "ControladorProducto", type: 'POST', data: 'btn=4' + '&event=SeleccionarProducto&cantidad=0&codigoproduc=' + codigoProducto,
        success: function (data) {
            $("#datosGenerales1").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//ControladorProducto: Enviara los registros de una factura y los hara visibles en una tabla//
$(document).on('click', '#registrosProduct', function (e) {
    e.stopImmediatePropagation();
    e.preventDefault();
    var codigoprducto = $(".codigopro").val();
    var producto = $("#producto1").val();
    var cantidad = $("#cantidad1").val();
    var precio = $("#precioUni1").val();
    var preciototal = $("#preciototal1").val();
    $.ajax({
        url: "ControlRegistro", type: 'POST', data: 'btn=4' +
                '&producto=' + producto +
                '&precioUni=' + precio +
                '&codigoprducto=' + codigoprducto +
                '&cantidad=' + cantidad +
                '&preciototal1=' + preciototal +
                '&event=AgregarRegistro',
        success: function (data) {
            $("#tablaregistro").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//ControlRegistro: cancelara la factura antes de guardar en la base de datos//
$(document).on('click', '#cancelarFactura', function (e) {
    e.stopImmediatePropagation();
    e.preventDefault();

    $.ajax({
        url: "ControlRegistro", type: 'POST', data: 'btn=4' +
                '&event=cancelarFactura',
//        url: "ControlRegistro", type: 'POST', data: 'btn=4' + '&event=3',
        success: function (data) {
            $("#tablaregistro").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });

});
//$(document).on('click', '#registrosProduct', function (e) {
//    e.stopImmediatePropagation();
//    e.preventDefault();
//    var codigoprducto = $(".codigopro").val();
//    var codigofactura = $("#factura").val();
//    var producto = $("#producto").val();
//    var cantidad = $("#cantidad1").val();
//    var codigoEmpleado = $("#codigoEmpleado").val();
//    var precio = $("#precioUni").val();
//    var codigoCliente = $("#codigoCliente").val();
//    var fecha = $("#fecha").val();
//    alert("fecha" + fecha + "?");
//
//    $.ajax({
//        url: "ControlRegistro", type: 'POST', data: 'btn=4' +
//                '&producto=' + producto +
//                '&codigofactura=' + codigofactura +
//                '&precioUni=' + precio +
//                '&codigoprducto=' + codigoprducto +
//                '&cantidad=' + cantidad +
//                '&codigoEmpleado=' + codigoEmpleado +
//                '&codigoCliente=' + codigoCliente +
//                '&fecha=' + fecha +
//                '&event=3',
////        url: "ControlRegistro", type: 'POST', data: 'btn=4' + '&event=3',
//        success: function (data) {
//            $("#tablaregistro").html(data);
//        }, error: function (xml, data) {
//            swal('Mensaje del sistema', 'Error', 'error');
//        }
//
//    });
//
//});
//Escucha el evento de agregar Producto a la vista principal//

//ControladorProducto: lee la informacion de cantidad para mostrar el total//
$(document).on('keyup', '.cantidad', function (e) {
    e.stopImmediatePropagation();
    var cantidad = $(".cantidad").val();

    $.ajax({
        url: "ControladorProducto", type: 'POST', data: 'event=SeleccionarProducto' + '&cantidad=' + cantidad + '&codigoproduc=' + codigoProducto,
        success: function (data) {
            $("#datosGenerales1").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });
});


//ControlCliente: Elimina los clientes//
$(document).on('click', '.btn_Eliminar', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();
    var codigoCliente = $(this).parent().parent().children().first().text();
var opcion = confirm("Deseas eliminar el Cliente " + codigoCliente + "? ");
    if (opcion === true) {
        $.ajax({
            //trabajando
            url: "ControlCliente", type: 'POST', data: 'event=btn_EliminarCliente' + '&Eliminar=' + codigoCliente,
            success: function (data) {
                $("#data2").html(data);
            }, error: function (xml, data) {
                swal('Mensaje del sistema', 'Error', 'error');
            }
        });
    }

    
});
//ControlCliente:  Modifica Los clientes ya registrado//
$(document).on('click', '#btn_modificarCliente1', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();

    var nombre = $("#nombreClien").val();
    var apellido = $("#apellidoClien").val();
    var telefono = $("#telefonoClien").val();
    var direccion = $("#direccionClien").val();
    alert("Modificado con exito");
    $.ajax({

        url: "ControlCliente", type: 'POST', data: 'event=ModificarCliente'
                + '&ModificarClien=' + codigoCliente
                + '&nombre=' + nombre
                + '&apellido=' + apellido
                + '&telefono=' + telefono
                + '&direccion=' + direccion,
        success: function (data) {
            $("#data2").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }
    });


});
//ControlCliente: llenara los campos para ser modificados//
$(document).on('click', '.btn_ModificarClienta', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();
    codigoCliente = $(this).parent().parent().children().first().text();


    $.ajax({
        //trabajando
        url: "ControlCliente", type: 'POST', data: 'event=Cambiarnombre' + '&Modificar=' + codigoCliente,
        success: function (data) {
            $("#data2").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }
    });



});
//ControlRegistro: Elimina los productos que ya estan agregados en las ventas//
$(document).on('click', '.btn_EliminarProducto', function (e) {
    e.preventDefault();
    e.stopImmediatePropagation();
   var idProducto = $(this).parent().parent().children().first().text();
        $.ajax({
        url: "ControlRegistro", type: 'POST', data: 'btn=4' +
                '&event=eliminarId' + '&Eliminar=' + idProducto,

        success: function (data) {
            $("#tablaregistro").html(data);
        }, error: function (xml, data) {
            swal('Mensaje del sistema', 'Error', 'error');
        }

    });
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


