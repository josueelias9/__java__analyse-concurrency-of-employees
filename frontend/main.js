

function mes(numero_de_mes) {
    if (numero_de_mes == 1) return "enero";
    else if (numero_de_mes == 2) return "febero";
    else if (numero_de_mes == 3) return "marzo";
    else if (numero_de_mes == 4) return "abril";
    else if (numero_de_mes == 5) return "mayo";
    else if (numero_de_mes == 6) return "junio";
    else if (numero_de_mes == 7) return "julio";
    else if (numero_de_mes == 8) return "agosto";
    else if (numero_de_mes == 9) return "septiembre";
    else if (numero_de_mes == 10) return "octubre";
    else if (numero_de_mes == 11) return "noviembre";
    else if (numero_de_mes == 12) return "diciembre";
    else if (numero_de_mes == 13) return "enero (2016)";
}

async function getAPI(url) {
    fetch(url)
        .then(response => {
            return response.json();
        })
        .then(data => {
            let a = "";
            console.log(data);
            for (let i = 0; i < data.length; i++) {

                a = a + "<li>Del ";
                a = a + data[i].dia + " de " + mes(data[i].mes) + "     a las " + data[i].hora + " horas";
                a = a + " hasta el ";
                a = a + data[i + 1].dia + " de " + mes(data[i].mes) + "     a las " + data[i + 1].hora + " horas";
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
    fetch(miurl, xx)
        .then(response => {
            return response.json()
        })
        .then(data => {
            let a = "";
            console.log(data);
            for (let i = 0; i < data.length; i++) {
                a = a + '<tr>';
                a = a + '<td>';
                a = a + ((i/2)+1);
                a = a + '</td>';
                a = a + '<td>';
                a = a + data[i].dia + " de " + mes(data[i].mes) + " a las " + data[i].hora + " horas con "+ data[i].minuto + " minutos";
                a = a + '</td>';
                a = a + '<td>';
                a = a + data[i+1].dia + " de " + mes(data[i+1].mes) + " a las " + data[i+1].hora + " horas con "+ data[i+1].minuto + " minutos";
                a = a + '</td>';

                a = a + '</tr>';
                i = i + 1;
            }
            document.getElementById("oe").innerHTML = a;
            //document.getElementById("oe").innerHTML = '<th scope="row">3</th> <td colspan="2">Larry the Bird</td>    <td>@twitter</td>';

        });

}
