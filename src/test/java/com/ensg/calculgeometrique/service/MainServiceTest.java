package com.ensg.calculgeometrique.service;

/**
 *
 * @author Hiba GHADHAB M2 TSI 2018/2019 ENSG
 *
 **/

import com.ensg.calculgeometrique.entity.GeoJson;
import org.geotools.geojson.GeoJSON;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Coordinates;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MainServiceTest {
    @Autowired
    MainService mainService;

    //Dans le polygon extrait du fichier GeoJSON ajouté par l'utilisateur, le nombre de point doit être supérieur ou égale à 4.
    @Test
    public void pointNumbers() {
        Geometry geom = mainService.getGeometry();
        Coordinate[] coordinates = geom.getCoordinates();
        Assert.assertTrue(coordinates.length >= 4);
    }

    //Dans le polygon extrait du fichier GeoJSON ajouté par l'utilisateur, le premier et le dernier point doivent avoir les mêmes coordonnées.
    @Test
    public void firstLastPoint(){
        Geometry geom = mainService.getGeometry();
        Coordinate[] coordinates = geom.getCoordinates();

        int retvalX = Double.compare(coordinates[0].getX(),  coordinates[(coordinates.length)-1].getX());
        int retvalY = Double.compare(coordinates[0].getY(), coordinates[(coordinates.length)-1].getY());

        Assert.assertTrue((retvalX == 0) && (retvalY == 0));
    }

    //test sur MBR: Pour le rectangle généré, je dois avoir exactement 5 points
    @Test
    public void mbrPoints()
    {
        GeoJson rst = mainService.getMbrCoordinates();
        com.ensg.calculgeometrique.entity.Geometry geom = rst.getGeometry();
        List<List<Double[]>> lcoordinates = geom.getCoordinates();
        List<Double[]> coordinates = lcoordinates.get(0);
        Assert.assertTrue(coordinates.size() == 5);
    }

    //Test par rapport MBR: dans le recangle généré, le premier etle dernier point doivent avoir les même coordonnées
    @Test
    public void mbrFirstLastPoint()
    {
        GeoJson rst = mainService.getMbrCoordinates();
        com.ensg.calculgeometrique.entity.Geometry geom = rst.getGeometry();
        List<List<Double[]>> lcoordinates = geom.getCoordinates();
        List<Double[]> coordinates = lcoordinates.get(0);
        Double[] firstPoint = coordinates.get(0);
        Double[] lastPoint = coordinates.get(coordinates.size()-1);
        Double firstPointX = firstPoint[0];
        Double firstPointY = firstPoint[1];
        Double lastPointX = lastPoint[0];
        Double lastPointY = lastPoint[1];

        int retvalX = Double.compare(firstPointX, lastPointX);
        int retvalY = Double.compare(firstPointX, lastPointX);

        Assert.assertTrue((retvalX == 0) && (retvalY == 0));
    }

    //test par rapport MBC: dans le cercle obtenu, on s'assure que nous avons eu 4 points minimum.
    @Test
    public void mbcPoints()
    {
        GeoJson rst = mainService.getMbcCoordinates();
        com.ensg.calculgeometrique.entity.Geometry geom = rst.getGeometry();
        List<List<Double[]>> lcoordinates = geom.getCoordinates();
        List<Double[]> coordinates = lcoordinates.get(0);
        Assert.assertTrue(coordinates.size()>= 4);
    }

}