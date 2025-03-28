let headersList = {
    "Accept": "*/*",
    "User-Agent": "web",
    "Content-Type": "application/json"
}

async function fetchCountries() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/country/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            let datalist = document.getElementById("countryList");

            
            data.forEach((country) => {
                let option = document.createElement("option");
                option.value = country.name;
                datalist.appendChild(option);
            });
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los países:", error);
    }
}



let countryID;
let countryInput = document.getElementById("country");
countryInput.addEventListener("change", () => {
    let selectedCountry = countryInput.value;
    console.log("País seleccionado:", selectedCountry);
    
    
    async function selectId() {
        let response = await fetch("http://localhost:8085/api/v1/country/", {
            method: "GET",
            headers: headersList 
        });
        let data = await response.json();

        data.forEach((country) => {
            if (country.name === selectedCountry) {
                countryID = country.country_id; 
                console.log("ID del país:", countryID);
            }
        });
    }
    selectId();

});
 
fetchCountries();

function registerGenre() {

    return new Promise(async (resolve) => {


        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("nameGenre").value
        });

        let response = await fetch("http://localhost:8085/api/v1/gender/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}

function registerCountry() {

    return new Promise(async (resolve) => {


        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("nameCountry").value
        });

        let response = await fetch("http://localhost:8085/api/v1/country/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}

function registerAuthor() {

    return new Promise(async (resolve) => {


        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("nameAuthor").value,
            "image": document.getElementById("image").value,
            "country_id": {"country_id":countryID}
        });

        let response = await fetch("http://localhost:8085/api/v1/author/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);
        alert(selectedCountry);
    });
    
}

function registerPlatform() {

    return new Promise(async (resolve) => {

        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("namePlatform").value,
            "image": document.getElementById("image").value,
            "country_id": {"country_id":countryID}
        });

        let response = await fetch("http://localhost:8085/api/v1/platform/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}