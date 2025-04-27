let headersList = {
    "Accept": "*/*",
    "User-Agent": "web",
    "Content-Type": "application/json"
}
// Obtener el id del anime desde la URL
const queryParams = new URLSearchParams(window.location.search);
const idAnime = Number(queryParams.get('id'));
var idA = idAnime;
let genderA = [];

async function fetchAnimeG() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/animeGender/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            
            data.forEach((anime_gender) => {
                
                if (anime_gender.anime.anime_id === idA) {
                    genderA.push(" "+anime_gender.gender.name); 
                }
            });
            
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los datos:", error);
    }
}

fetchAnimeG();
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
                                        '<div class="col-lg-4 col-md-4">'+
                                            '<ul>'+
                                                '<li><span>Type:</span> Anime</li>'+
                                                '<li><span>Episodes:</span> '+ anime.episodes +'</li>'+
                                                '<li><span>Year Premiere:</span> '+ anime.year_premiere+'</li>'+
                                                '<li><span>Genres:</span> '+ genderA +'</li>'+
                                            '</ul>'+
                                        '</div>'+
                                        '<div class="col-lg-4 col-md-4">'+
                                            '<div class="product__sidebar__comment__item">'+
                                                '<div class="product__sidebar__comment__item__pic">'+
                                                    '<img src="'+anime.author.image+'" alt="" class="image">'+
                                                '</div>'+
                                                    '<li>Author: </li>'+
                                                '<div class="product__sidebar__comment__item__text">'+
                                                    '<h5>'+anime.author.name+'</h5>'+
                                                    '<span>'+anime.author.country.name+'</span>'+
                                                '</div>'+
                                            '</div>'+
                                        '</div>'+
                                        '<div class="col-lg-4 col-md-4">'+
                                            '<div class="product__sidebar__comment__item">'+
                                                '<div class="product__sidebar__comment__item__pic">'+
                                                    '<img src="'+anime.estudio.image+'" alt="" class="image">'+
                                                '</div>'+
                                                    '<li>Studio: </li>'+
                                                '<div class="product__sidebar__comment__item__text">'+
                                                    '<h5>'+anime.estudio.name+'</h5>'+
                                                    '<span>'+anime.estudio.country.name+'</span>'+
                                                '</div>'+
                                            '</div>'+
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
