package org.example;

public class Star {
    private String star;
    private boolean energy = false;

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public boolean isEnergy() {
        return energy;
    }

    public void setEnergy(boolean energy) {
        this.energy = energy;
    }

    public void generateEnergy() {
       energy = !energy;
       System.out.println(energy);
    }

    public void isStarGenerateEnargy(){
        if (energy) {
            System.out.println(star + " generate enargy!");
        } else {
            System.out.println(star + " not generate enargy(");
        }
    }

}
