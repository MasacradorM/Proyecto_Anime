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


async function fetchStudios() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/estudio/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            let datalist = document.getElementById("estudioList");

            
            data.forEach((estudio) => {
                let option = document.createElement("option");
                option.value = estudio.name;
                datalist.appendChild(option);
            });
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los estudios:", error);
    }
}

async function fetchAuthor() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/author/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            let datalist = document.getElementById("authorList");

            
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


let estudioID;
let estudioImput = document.getElementById("estudio");
estudioImput.addEventListener("change", () => {
    let selectedestudio = estudioImput.value;
    console.log(selectedestudio);
    
    
    async function selectId() {
        let response = await fetch("http://localhost:8085/api/v1/estudio/", {
            method: "GET",
            headers: headersList 
        });
        let data = await response.json();

        data.forEach((estudio) => {
            if (estudio.name === selectedestudio) {
                estudioID = estudio.estudio_id; 
                console.log("ID del Estudio:", estudioID);
            }
        });
    }
    selectId();

});

let authorID;
let authorImput = document.getElementById("author");
authorImput.addEventListener("change", () => {
    let selectedAuthor = authorImput.value;
    console.log(selectedAuthor);
    
    
    async function selectId() {
        let response = await fetch("http://localhost:8085/api/v1/author/", {
            method: "GET",
            headers: headersList 
        });
        let data = await response.json();

        data.forEach((author) => {
            if (author.name === selectedAuthor) {
                authorID = author.author_id; 
                console.log("ID del Author:", authorID);
            }
        });
    }
    selectId();

});

let countryID_A;
let countryID_P; 
let countryID_E;
function addChangeEventToInputs(inputs) {
    inputs.forEach((input) => {
        input.addEventListener("change", async () => {
            let selectedCountry = input.value;

            try {
                let response = await fetch("http://localhost:8085/api/v1/country/", {
                    method: "GET",
                    headers: headersList
                });

                if (response.ok) {
                    let data = await response.json();

                    let country = data.find((country) => country.name === selectedCountry);
                    if (country) {
                        if (input.id === "countryA") {
                            countryID_A = country.country_id; 
                            console.log(`ID del país (${selectedCountry}):`, countryID_A);
                        } else if (input.id === "countryP") {
                            countryID_P = country.country_id; 
                            console.log(`ID del país (${selectedCountry}):`, countryID_P);
                        }
                        else if (input.id === "countryE") {
                            countryID_E = country.country_id;
                            console.log(`ID del país (${selectedCountry}):`, countryID_E);
                        }
                    } else {
                        console.warn("País no encontrado:", selectedCountry);
                    }
                } else {
                    console.error("Error al obtener datos:", response.status);
                }
            } catch (error) {
                console.error("Hubo un error al obtener el ID del país:", error);
            }
        });
    });
}

const countryInputs = [document.getElementById("countryA"), document.getElementById("countryP"), document.getElementById("countryE")];
fetchCountries();
fetchStudios();
fetchAuthor();
addChangeEventToInputs(countryInputs);

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
            "country_id": {"country_id":countryID_A}
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
            "country_id": {"country_id":countryID_P}
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
function registerEstudio() {

    return new Promise(async (resolve) => {

        let bodyContent = JSON.stringify({
            "id": 0,
            "name": document.getElementById("nameEstudio").value,
            "image": document.getElementById("image").value,
            "country_id": {"country_id":countryID_E}
        });

        let response = await fetch("http://localhost:8085/api/v1/estudio/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}
function registerAnime() {

    return new Promise(async (resolve) => {

        let bodyContent = JSON.stringify({
            "id": 0,
            "title": document.getElementById("title").value,
            "synopsis": document.getElementById("synopsis").value,
            "year_premiere": document.getElementById("yearPremier").value,
            "episodes": document.getElementById("episodes").value,
            "image": document.getElementById("image").value,
            "estudio": {"estudio_id":estudioID},
            "author": {"author_id":authorID}
        });

        let response = await fetch("http://localhost:8085/api/v1/anime/", {
            method: "POST",
            body: bodyContent,
            headers: headersList
        });

        let data = await response.text();
        console.log(data);

    });
}