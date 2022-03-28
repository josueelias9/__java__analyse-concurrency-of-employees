

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



async function postAPI(miurl, texto) {
    xml = "<response>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-20 17:00:00' group='2' id='72780' isdbar='false' name='LoLa' startdate='2015-01-20 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-23 17:00:00' group='2' id='72783' isdbar='false' name='LoLa' startdate='2015-01-23 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-22 17:00:00' group='2' id='72782' isdbar='false' name='LoLa' startdate='2015-01-22 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma' enddate='2015-01-27 17:00:00' group='2' id='72785' isdbar='false' name='LoLa' startdate='2015-01-27 08:00:00' type='0' useroffset='2' usertype='0'/>    <bar addedby='' comment='' datacenter='15' dateoffset='1' dcname='Gamma'  enddate='2015-01-26 17:00:00' group='2' id='72784' isdbar='false' name='LoLa' startdate='2015-01-26 08:00:00' type='0' useroffset='2' usertype='0'/></response>  ";

    let xx = {
        method: 'post',
        body: JSON.stringify({"mixml":texto})
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
