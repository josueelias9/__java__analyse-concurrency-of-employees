


async function getAPI(url){
    let response = await fetch(url);
    let data_json = await response.json;

    return data_json;
}



document.getElementById("prueba").innerHTML = "ooeoeoe";