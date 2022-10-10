var id = new URL(location.href).searchParams.get("id");
var user;

$(document).ready(function () {


    fillUsuario();
    getReservas(id);
    $("#reservar-btn").attr("href", `home.html?id=${id}`);

    $("#form-modificar").on("submit", function (event) {

        event.preventDefault();
        modificarUsuario();
    });

    $("#aceptar-eliminar-cuenta-btn").click(function () {

        eliminarCuenta().then(function () {
            location.href = "index.html";
        })
    })

});

async function fillUsuario() {
    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioPedir",
        data: $.param({
            id_usuario: id
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                user = parsedResult;

                $("#input-documento").val(parsedResult.id_usuario);
                $("#input-contrasena").val(parsedResult.contrasena_usuario);
                $("#input-nombre").val(parsedResult.nombre_usuario);
                $("#input-apellidos").val(parsedResult.apellido_usuario);
                $("#input-email").val(parsedResult.email);
                $("#input-telefono").val(parsedResult.telefono_usuario);
                $("#input-direccion").val(parsedResult.direccion_usuario);
                $("#input-ciudad").val(parsedResult.ciudad_usuario);
                $("#input-comuna").val(parsedResult.comuna_usuario);
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });
}


function modificarUsuario() {

    let id = $("#input-documento").val();
    let contrasena = $("#input-contrasena").val();
    let nombre = $("#input-nombre").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let telefono = $("#input-telefono").val();
    let direccion = $("#input-direccion").val();
    let ciudad = $("#input-ciudad").val();
    let comuna = $("#input-comuna").val();
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./",
        data: $.param({
            id_usuario: id,
            contrasena: contrasena,
            nombre: nombre,
            apellido: apellidos,
            email: email,
            telefono: telefono,
            direccion: direccion,
            ciudad: ciudad,
            comuna: comuna
        }),
        success: function (result) {

            if (result != false) {
                $("#modificar-error").addClass("d-none");
                $("#modificar-exito").removeClass("d-none");
            } else {
                $("#modificar-error").removeClass("d-none");
                $("#modificar-exito").addClass("d-none");
            }

            setTimeout(function () {
                location.reload();
            }, 3000);

        }
    });

}

async function eliminarCuenta() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioEliminar",
        data: $.param({
            id_usuario: id
        }),
        success: function (result) {

            if (result != false) {

                console.log("Usuario eliminado")

            } else {
                console.log("Error eliminando el usuario");
            }
        }
    });
}


function getReservas(id) {


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletReservaListar",
        data: $.param({
            id_usuario: id
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                mostrarReserva(parsedResult);

            } else {
                console.log("Error recuperando los datos de las reservas");
            }
        }
    });
}

function mostrarReserva(reservas) {
    let contenido = "";
    if (reservas.length >= 1) {
        $.each(reservas, function (index, reserva) {
            reserva = JSON.parse(reserva);

            contenido += '<tr><th scope="row">' + reserva.fecha_servicio + '</th>' +
                    '<td>' + reserva.username_usuario+ '</td>' +
                    '<td>' + reserva.nombre_servicio + '</td>';
        });
        $("#historial-tbody").html(contenido);
        $("#historial-table").removeClass("d-none");
        $("#historial-vacio").addClass("d-none");

    } else {
        $("#historial-vacio").removeClass("d-none");
        $("#historial-table").addClass("d-none");
    }
}