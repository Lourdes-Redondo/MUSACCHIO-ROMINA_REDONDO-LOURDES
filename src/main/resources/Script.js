window.onload = function() {
    fetch("http://localhost:8080/odontologos/listar")
        .then(function(respuesta) {
            return respuesta.json();
        })
        .then(data => {
            const tbody = document.querySelector('#tablaDeOdontologos tbody')
            
            data.forEach(OdontologoSalidaDto => {
                const fila = document.createElement('tr');

                fila.innerHTML =
                '<td>' + OdontologoSalidaDto["numeroDeMatricula"] + '</td>' +
                '<td>' +OdontologoSalidaDto["nombre"] + '</td>' +
                '<td>' +OdontologoSalidaDto["apellido"] + '</td>';

                tbody.appendChild(fila);
            });
        })
        .catch(error => console.error('No se pudo cargar a los odontologos.', error))
}
