let headersList = {
    "Accept": "*/*",
    "User-Agent": "web",
    "Content-Type": "application/json"
}

async function listAnime() {
    try {
        let response = await fetch("http://localhost:8085/api/v1/anime/", {
            method: "GET",
            headers: headersList 
        });

        if (response.ok) {
            let data = await response.json();
            let datalist = document.getElementById("listAnime");

            
            data.forEach((anime) => {
                let synopsisSnippet = anime.synopsis.length > 100 ? anime.synopsis.substring(0, 112) + '...' : anime.synopsis;

                let option = '<div class="col-lg-4 col-md-6 col-sm-6">'+
                    '<div class="product__item">'+
                        '<div class="product__item__pic set-bg" >'+
                            '<img src="'+anime.image+'" alt="'+anime.title+'" class="product__item__img set-bg">'+
                            '<div class="ep">'+'Episodes - '+ anime.episodes+'</div>'+
                        '</div>'+
                        '<div class="product__item__text">'+
                        '<h5 id="animeListed" data-Id="'+ anime.anime_id +'">'+
                        '<a href="anime-details.html?id='+anime.anime_id+'" >'+ anime.title +'</a>'+
                    '</h5>'+
                            '<br>'+
                            '<h6>'+synopsisSnippet+'</h6>'+
                        '</div>'+
                    '</div>' +
                '</div>';
                datalist.innerHTML += option;
            });
        } else {
            console.error("Error al obtener datos:", response.status);
        }
    } catch (error) {
        console.error("Hubo un error al cargar los países:", error);
    }
}

listAnime();



    
        
        
        
    
    
        

    

