let headersList = {
    "Accept": "*/*",
    "User-Agent": "web",
    "Content-Type": "application/json"
}
// Obtener el id del anime desde la URL
const queryParams = new URLSearchParams(window.location.search);
const idAnime = queryParams.get('id');
var gender;

async function fetchCountries() {
    
    try {
        let response = await fetch("http://localhost:8085/api/v1/animeGender", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();

            if(data.anime_gender.anime_id=== idAnime){
                data.forEach((anime_gender) => {
                    gender = anime_gender.gender.name;
                });
            }
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los países:", error);
    }
    
}
fetchCountries();
console.log(gender);
async function anime() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/anime/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            let datalist = document.getElementById("anime");
            

            // Asegurarte de que el ID del anime está definido
            if (!idAnime) {
                console.error("ID de anime no encontrado en la URL.");
                datalist.innerHTML = '<p>No se encontró el anime seleccionado.</p>';
            } else {
                // Buscar el anime que coincide con el idAnime
                data.forEach((anime) => {
                    if (idAnime == anime.anime_id) {
                        let animeSelected = '<div class="col-lg-3">'+
                        '<div class="product__item__pic set-bg" >'+
                            '<img src="'+anime.image+'" alt="'+anime.title+'" class="product__item__img set-bg">'+
                            '<div class="ep">'+'Episodes - '+ anime.episodes+'</div>'+
                        '</div>'+
                        '</div>'+
                        '<div class="col-lg-9">'+
                            '<div class="anime__details__text">'+
                                '<div class="anime__details__title">'+
                                    '<h3>'+anime.title+'</h3>'+
                                '</div>'+
 
                                '<p>'+anime.synopsis+'</p>'+
                                '<div class="anime__details__widget">'+
                                    '<div class="row">'+
                                        '<div class="col-lg-6 col-md-6">'+
                                            '<ul>'+
                                                '<li><span>Type:</span> Anime</li>'+
                                                '<li><span>Studios:</span> '+ anime.estudio.name +'</li>'+
                                                '<li><span>Year Premiere:</span> '+ anime.year_premiere+'</li>'+
                                                '<li><span>Genre:</span> '+  +'</li>'+
                                            '</ul>'+
                                        '</div>'+
                                    '</div>'+
                                '</div>'+
                            '</div>'+
                        '</div>';
                        datalist.innerHTML = animeSelected;

                    }
                });

            }
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los países:", error);
    }
}


anime();
