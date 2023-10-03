document.getElementById("btnGuardar").addEventListener("click", () => {
    const nombreMateria = document.getElementById("nombreMateria").value;
    const codigoMateria = document.getElementById("codigoMateria").value;

    if (codigoMateria.length === 0 || !/^\d+$/.test(codigoMateria) || isNaN(parseInt(codigoMateria))) {
        alert("El código no es válido. Debe ser un número entero.");
    } else if (nombreMateria.length === 0) {
        alert("No se ha ingresado el nombre de la materia.");
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("post", "/TallerProyecto/ServletMateria", true);


        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const resp = JSON.parse(xhr.responseText);
                if (resp.state) {
                    alert("Materia agregada");
                    // Puedes realizar acciones adicionales aquí después de agregar la materia.
                } else {
                    alert("No se ha agregado la materia");
                }
            }
        }

        const data = `add=true&nombreMateria=${nombreMateria}&codigoMateria=${codigoMateria}`;
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send(data);

        // Recargar la página después de agregar la materia
        xhr.onload = () => {
            if (xhr.status === 200) {
                location.reload();
            }
        };
    }
});
