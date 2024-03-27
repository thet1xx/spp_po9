package org.example;

public class Planet {
    private String planet;
    private boolean isHasLive;
    public String getPlanet() {
        return planet;
    }

    public Planet(String planet, boolean isHasLive) {
        this.planet = planet;
        this.isHasLive = isHasLive;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }
    public boolean getIsHaslive() {
        return isHasLive;
    }
    public void setLive(boolean live) {
        this.isHasLive = live;
    }

    public void isPlanetHasLive() {
        System.out.println("Planet " + planet + " live: " + isHasLive);
    }
    public void changeLiveStatus() {
        isHasLive = !isHasLive;
        System.out.println("Status changed");

    }

}
