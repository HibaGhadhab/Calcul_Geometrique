package com.ensg.calculgeometrique.controller;

/**
 *
 * @author Hiba GHADHAB - M2 TSI 2018/2019 - ENSG
 *
 **/

import com.ensg.calculgeometrique.entity.GeoJson;
import com.ensg.calculgeometrique.service.MainService;
import org.geotools.geojson.geom.GeometryJSON;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;

@RestController
public class MainController
{
    @Autowired
    MainService mainService;


    /**
     * Get the minimum bounding rectangle by calling the service
     * @return GeoJson
     */
    @GetMapping("/MBR")
    public GeoJson MBR_Geometry ()
    {
        return mainService.getMbrCoordinates();
    }


    /**
     * Get the minimum bounding circle by calling the service
     * @return GeoJson
     */
    @GetMapping("/MBC")
    public GeoJson MBC_Geometry ()
    {
        return mainService.getMbcCoordinates();
    }


    /**
     * Read uploaded file, extract the geometry and get it's coordinate
     * @param file
     * @return List<Double[]>
     * @throws IOException
     * @throws ParseException
     **/
    @PostMapping("/saveFile")
    public List<Double[]> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
        file.transferTo(new File("C:\\Workspace\\calculgeometrique\\files\\file.json"));
        //if file is taking too long with laoding use the following line of code:
        //Thread.sleep(1000);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:\\Workspace\\calculgeometrique\\files\\file.json"));
        String json = obj.toString();
        GeometryJSON gjson = new GeometryJSON();
        try (Reader reader = new StringReader(json))
        {
            org.locationtech.jts.geom.Geometry geom = gjson.readPolygon(reader);
            return mainService.getCoordinates(geom.getCoordinates());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
