/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webtools.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sparshramchandani
 */
public class Music {
    List<Base> music = new ArrayList<>();

    public Music() {
        this.music = new ArrayList<>();
        music.add(new Base("I am Going to Tell You a Secret by Madonna", 26.99f));
        music.add(new Base("Baby One More Time by Britney Spears", 10.95f));
        music.add(new Base("Justified by Justin Timberlake", 9.77f));
        music.add(new Base("Loose by Nelly Furtado", 13.98f));
        music.add(new Base("Gold Digger by Kanye West", 27.99f));
    }

    public List<Base> getMusic() {
        return music;
    }

    public void setMusic(List<Base> music) {
        this.music = music;
    }

}
