const inicio = document.querySelector(".container-inicio"); // Seccion inicio
const us = document.querySelector(".container-us"); // Seccion nosotros
const contacto = document.querySelector(".container-contacto"); // Seccion contacto

const btn_us = document.querySelector(".info");
const btn_inicio = document.querySelector(".inicio");
const btn_contacto = document.querySelector(".contacto");

function toggleNosotros() {

    const isInicioClosed = inicio.classList.contains("inactive");
    const isContactoClosed = contacto.classList.contains("inactive");

    if (!isInicioClosed) {
        inicio.classList.add("inactive");
    }

    if (!isContactoClosed) {
        contacto.classList.add("inactive");
    }

    us.classList.toggle("inactive")
    console.log("click");

}

function toggleInicio() {
    const isUsClosed = us.classList.contains("inactive");
    const isContactoClosed = contacto.classList.contains("inactive");
    

    if (!isUsClosed) {
        us.classList.add("inactive");
    }
    if (!isContactoClosed) {
        contacto.classList.add("inactive");
    }
    


    inicio.classList.toggle("inactive");

}

function toggleContacto() {
    const isInicioClosed = inicio.classList.contains("inactive");
    const isUsClosed = us.classList.contains("inactive");
    if (!isInicioClosed) {
        inicio.classList.add("inactive");
    }
    if (!isUsClosed) {
        us.classList.add("inactive");
    }

    contacto.classList.toggle("inactive");
}


// LLamado funciones

btn_us.addEventListener('click', toggleNosotros);
btn_inicio.addEventListener('click', toggleInicio);
btn_contacto.addEventListener('click', toggleContacto);