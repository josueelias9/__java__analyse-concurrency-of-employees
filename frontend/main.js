
async function getAPI(url) {
    fetch(url)
        .then(response => {
            return response.json();})
        .then(data => {
            let a = "";
            console.log(data.length);
            for(let i = 0; i< data.length; i++){
                a = a + "<li>limite inferior: " + data[i].infe +"     limite superior: "+ data[i].supe +"</li>";
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
