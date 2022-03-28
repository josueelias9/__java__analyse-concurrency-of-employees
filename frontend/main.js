
async function getAPI(url) {
    fetch(url)
        .then(response => {
            return response.json();
        })
        .then(data => {
            let a = "";
            console.log(data);
            for (let i = 0; i < data.length; i++) {

                let mes = 0;
                if (data[i].mes == 1) mes = "enero";
                else if (data[i].mes == 2) mes = "febero";
                else if (data[i].mes == 3) mes = "marzo";
                else if (data[i].mes == 4) mes = "abril";
                else if (data[i].mes == 5) mes = "mayo";
                else if (data[i].mes == 6) mes = "junio";
                else if (data[i].mes == 7) mes = "julio";
                else if (data[i].mes == 8) mes = "agosto";
                else if (data[i].mes == 9) mes = "septiembre";
                else if (data[i].mes == 10) mes = "octubre";
                else if (data[i].mes == 11) mes = "noviembre";
                else if (data[i].mes == 12) mes = "diciembre";

                a = a + "<li>Del ";
                a = a + data[i].dia + " de " + mes + "     a las " + data[i].hora + " horas";
                a = a + " hasta el ";
                a = a + data[i + 1].dia + " de " + mes + "     a las " + data[i + 1].hora + " horas";
                a = a + "</li>";
                i = i + 1;
            }

            document.getElementById("prueba").innerHTML = a;

        });
}


async function postAPI(miurl, formData) {
    const value = Object.fromEntries(formData.entries());
    let xx = {
        method: 'post',
        body: JSON.stringify(value)
    }
    fetch(miurl,xx)
        .then(response => {
            return response.json()
        })
        .then(data => {
            let a = "";
            console.log(data);
            for (let i = 0; i < data.length; i++) {

                let mes = 0;
                if (data[i].mes == 1) mes = "enero";
                else if (data[i].mes == 2) mes = "febero";
                else if (data[i].mes == 3) mes = "marzo";
                else if (data[i].mes == 4) mes = "abril";
                else if (data[i].mes == 5) mes = "mayo";
                else if (data[i].mes == 6) mes = "junio";
                else if (data[i].mes == 7) mes = "julio";
                else if (data[i].mes == 8) mes = "agosto";
                else if (data[i].mes == 9) mes = "septiembre";
                else if (data[i].mes == 10) mes = "octubre";
                else if (data[i].mes == 11) mes = "noviembre";
                else if (data[i].mes == 12) mes = "diciembre";

                a = a + "<li>Del ";
                a = a + data[i].dia + " de " + mes + "     a las " + data[i].hora + " horas";
                a = a + " hasta el ";
                a = a + data[i + 1].dia + " de " + mes + "     a las " + data[i + 1].hora + " horas";
                a = a + "</li>";
                i = i + 1;
            }

            document.getElementById("prueba").innerHTML = a;

        });

}


//let direccion_url = "http://localhost:8080/calcular";
//let a = await getAPI(direccion_url);
//


// 
// 
// const myForm = document.getElementById("myForm");
// 
// myForm.addEventListener('submit', function (e) {
//     e.preventDefault();
//     const formData = new FormData(this);
//     putapi(direccion_url, formData).then(() => {
//         map.data.forEach(function (feature) {
//             map.data.remove(feature);
//         });
//         map.data.loadGeoJson(direccion_url);
//     });
// 
// });
