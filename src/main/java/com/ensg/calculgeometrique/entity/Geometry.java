package com.ensg.calculgeometrique.entity;

/**
 *
 * @author Hiba GHADHAB M2 TSI 2018/2019 ENSG
 *
 **/


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Geometry
{
    private String type;

    private List<List<Double[]>> coordinates;

    public Geometry(String type,List<Double[]> coordinates) {
        this.coordinates = new ArrayList<>();
        this.coordinates.add(coordinates);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<Double[]>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double[]>> coordinates) {
        this.coordinates = coordinates;
    }
}
