
async function getAPI(url) {
    let response = await fetch(url);
    let data_json = await response.json;

    return data_json;
}



let direccion_url = "http://localhost:8080/calcular";
let a = await getAPI(direccion_url);

document.getElementById("prueba").innerHTML = a;


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
