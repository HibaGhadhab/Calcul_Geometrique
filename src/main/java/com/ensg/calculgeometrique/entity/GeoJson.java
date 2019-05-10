package com.ensg.calculgeometrique.entity;

/**
 *
 * @author Hiba GHADHAB M2 TSI 2018/2019 ENSG
 *
 **/


public class GeoJson
{
    private String type;
    private PropertiesGeoJson properties;
    private Geometry geometry;

    public GeoJson(String type, PropertiesGeoJson properties, Geometry geometry) {
        this.type = type;
        this.properties = properties;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertiesGeoJson getProperties() {
        return properties;
    }

    public void setProperties(PropertiesGeoJson properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}



