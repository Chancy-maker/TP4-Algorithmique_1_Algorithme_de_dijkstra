package com.company;

import java.util.Objects;

public class Arc {

    /**
     * startingPick représente le sommet de départ d'un arc
     */
    private int startingPick;

    /**
     * arrivalPick représente le sommet d'arrivé d'un arc
     */
    private int arrivalPick;

    /**
     * weight représente le poids d'un arc
     */
    private int weight;




    /**
     * Construteur d'un Arc
     * @param startingPick
     * @param arrivalPick
     * @param weight
     */
    public Arc(int startingPick, int arrivalPick, int weight){
        this.startingPick = startingPick;
        this.arrivalPick = arrivalPick;
        this.weight = weight;
    }

    /**
     * getStartingPick est le getter de la proprité strartingPick
     * @return
     */
    public int getStartingPick() {
        return startingPick;
    }

    /**
     * getArrivalPick est le getter de la propriété arrivalPick
     * @return
     */
    public int getArrivalPick() {
        return arrivalPick;
    }

    /**
     * getWeight est le getter de la propriété weight
     * @return
     */
    public int getWeight() {
        return weight;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arc arc = (Arc) o;
        return startingPick == arc.startingPick &&
                arrivalPick == arc.arrivalPick;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startingPick, arrivalPick);
    }

    @Override
    public String toString() {
        return "Arc("+ startingPick +
                ", " + arrivalPick +
                ", " + weight +
                ')';
    }


}
