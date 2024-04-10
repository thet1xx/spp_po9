package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StarWay {

    private Planet[] planets;
    private Star star;

    public StarWay(Planet[] planets, Star star) {
        this.planets = planets;
        this.star = star;
    }

    public void getSystem(){
        System.out.println(star.getStar() + ":");
        for (Planet planet : planets){
            System.out.println(planet.getPlanet() + " " + planet.getIsHaslive());
        }
    }

    public void planetLive(){
        for (Planet planet : planets){
            planet.isPlanetHasLive();
            planet.changeLiveStatus();
        }
    }

    public void starMethods(){
        System.out.println();
        System.out.println("make stars generate energy: ");
        star.generateEnergy();
        star.isStarGenerateEnargy();

    }


}

