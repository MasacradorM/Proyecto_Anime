package com.sena.crud_basic.DTO;

import com.sena.crud_basic.model.Anime;
import com.sena.crud_basic.model.Platform;


public class animePlatformDTO {

    private Anime anime;
    private Platform platform;

    public animePlatformDTO( Anime anime, Platform platform) {
        this.anime = anime;
        this.platform = platform;
    }



    public void setAnime(Anime anime) {
        this.anime = anime;
    }
    

    public Anime getAnime() {
        return anime;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Platform getPlatform() {
        return platform;
    }

}
