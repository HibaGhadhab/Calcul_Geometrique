package com.ensg.calculgeometrique.entity;

/**
 *
 * @author Hiba GHADHAB M2 TSI 2018/2019 ENSG
 *
 **/

import org.locationtech.jts.geom.Coordinate;

public class Circle
{
    private Coordinate center;
    private Double rayon;

    public Circle()
    {

    }
    public Circle(Coordinate center, Double rayon) {
        this.center = center;
        this.rayon = rayon;
    }

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public Double getRayon() {
        return rayon;
    }

    public void setRayon(Double rayon) {
        this.rayon = rayon;
    }
}
