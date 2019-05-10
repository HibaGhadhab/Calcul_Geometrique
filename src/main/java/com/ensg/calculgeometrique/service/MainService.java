package com.ensg.calculgeometrique.service;

/**
 *
 * @author Hiba GHADHAB - M2 TSI 2018/2019 - ENSG
 *
 **/

import com.ensg.calculgeometrique.entity.GeoJson;
import com.ensg.calculgeometrique.entity.PropertiesGeoJson;
import org.geotools.geojson.GeoJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.locationtech.jts.algorithm.MinimumBoundingCircle;
import org.locationtech.jts.algorithm.MinimumDiameter;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MainService
{
    //input file
    private static String filePath = "C:\\Workspace\\calculgeometrique\\files\\file.json";


    /**
     * Get geometry from GeoJSON file added by the user
     * @return Geometry
     */
    public org.locationtech.jts.geom.Geometry getGeometry()
    {
        Object obj = null;
        JSONParser parser = new JSONParser();
        try {
            obj = parser.parse(new FileReader(filePath));
            String json = obj.toString();
            org.locationtech.jts.geom.Geometry mbr = null;
            GeometryJSON gjson = new GeometryJSON();
            try (Reader reader = new StringReader(json))
            {
                org.locationtech.jts.geom.Geometry geom = gjson.readPolygon(reader);
                return geom;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ParseException |IOException  e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * get list of longitudes and latitudes as a list of Double[]
     * @param coor
     * @return Coordinate[]
     */
    public List<Double[]> getCoordinates(Coordinate[] coor)
    {
        List<Double[]> coordinates = new ArrayList<>();
        for(Coordinate c : coor){
            Double[] elem = new Double[2];
            elem[0] = c.getY();
            elem[1] = c.getX();
            coordinates.add(elem);
        }
        return coordinates;
    }


    /**
     * The minimum bounding rectangle
     * @return GeoJson
     */
    public GeoJson getMbrCoordinates()
    {
        org.locationtech.jts.geom.Geometry mbr = null;
        PropertiesGeoJson propertiesGeoJson = new PropertiesGeoJson("MinimumRectangle");
        org.locationtech.jts.geom.Geometry geom = getGeometry();
        MinimumDiameter minDiam = new MinimumDiameter(geom);
        mbr =  minDiam.getMinimumRectangle();
        Coordinate[] coor = mbr.getCoordinates();
        List<Double[]> coordinates = getCoordinates(coor);
        com.ensg.calculgeometrique.entity.Geometry geometry
                = new com.ensg.calculgeometrique.entity.Geometry("Polygon",coordinates);
        return new GeoJson("Feature",propertiesGeoJson,geometry);
    }


    /**
     * The minimum bounding circle
     * @return GeoJson
     */
    public GeoJson getMbcCoordinates()
    {
        JSONParser parser = new JSONParser();
        Geometry mbc = null;
        try
        {
            Object obj = parser.parse(new FileReader(filePath));
            String json = obj.toString();
            GeometryJSON gjson = new GeometryJSON();
            try (Reader reader = new StringReader(json))
            {
                org.locationtech.jts.geom.Geometry geom = gjson.readPolygon(reader);
                MinimumBoundingCircle minCircle = new MinimumBoundingCircle(geom);
                mbc = minCircle.getCircle();
                List<String> tab = new ArrayList<>();
                Coordinate[] coor = mbc.getCoordinates();
                PropertiesGeoJson propertiesGeoJson = new PropertiesGeoJson("MinimumCircle");
                List<Double[]> coordinates = getCoordinates(coor);
                com.ensg.calculgeometrique.entity.Geometry geometry
                        = new com.ensg.calculgeometrique.entity.Geometry("Polygon",coordinates);
                return new GeoJson("Feature",propertiesGeoJson,geometry);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }catch (IOException|ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
