var id_usuario = new URL(location.href).searchParams.get("id_usuario");
var user;

$(document).ready(function () {

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    getUsuario().then(function () {
        
        $("#mi-perfil-btn").attr("href","profile.html?id=" + id_usuario);
    });
     $("#btn-reserva").attr("onclick","location.href = 'reserva.html?id=" + id_usuario+"'");
     
});
async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./",
        data: $.param({
            id_usuario: id_usuario
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
