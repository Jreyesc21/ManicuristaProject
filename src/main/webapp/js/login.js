$(document).ready(function () {

    $("#form-login").submit(function (event) {

        event.preventDefault();
        autenticarUsuario();
    });

    $("#form-register").submit(function (event) {

        event.preventDefault();
        registrarUsuario();
    });

});

function autenticarUsuario() {

    let id_usuario = $("#documento").val();
    let contrasena_usuario = $("#contrasena").val();

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            id_usuario: id_usuario,
            contrasena_usuario: contrasena_usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#login-error").addClass("d-none");
                let id_usuario = parsedResult[id_usuario];
                document.location.href = "home.html?id_usuario=" + id_usuario;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registrarUsuario() {

    let id_usuario = $("#input-documento").val();
    let contrasena_usuario = $("#input-contrasena").val();
    let contrasenaConfirmacion = $("#input-contrasena-repeat").val();
    let nombre_usuario = $("#input-nombre").val();
    let apellido_usuario = $("#input-apellido").val();
    let email = $("#input-email").val();
    let telefono_usuario = $("#input-telefono").val();
    let direccion_usuario = $("#input-direccion").val();
    let comuna_usuario = $("#input-comuna").val();
    let ciudad_usuario = $("#input-ciudad").val();
    

    if (contrasena_usuario === contrasenaConfirmacion) {

        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./ServletUsuarioRegister",
            data: $.param({
                id_usuario: id_usuario,
                contrasena_usuario: contrasena_usuario,
                nombre_usuario: nombre_usuario,
                apellido_usuario: apellido_usuario,
                email: email,
                telefono_usuario: telefono_usuario,
                direccion_usuario: direccion_usuario,
                comuna_usuario: comuna_usuario,
                ciudad_usuario: ciudad_usuario
                
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);

                if (parsedResult !== false) {
                    $("#register-error").addClass("d-none");
                    let id_usuario = parsedResult[id_usuario];
                    document.location.href = "home.html?id_usuario=" + id_usuario;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro del usuario");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }
}