package be.ehb.plantentuin.controllers;

import be.ehb.plantentuin.model.entities.Plant;
import be.ehb.plantentuin.model.dao.PlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planten")
public class PlantAPIController {

    private PlantDAO mPlantDAO;

    /*CREATE TABLE plant
(
    art_code    INT          NOT NULL,
    plantennaam VARCHAR(255) NOT NULL,
    soort       VARCHAR(255) NOT NULL,
    kleur       VARCHAR(255) NULL,
    prijs       DOUBLE       NOT NULL,
    CONSTRAINT pk_plant PRIMARY KEY (art_code)
);*/
    @Autowired
    public PlantAPIController(PlantDAO mPlantDAO) {
        this.mPlantDAO = mPlantDAO;
    }

    @GetMapping
    public Iterable<Plant> getAllPlanten(){
        return mPlantDAO.findAll();
    }

    @GetMapping("/kleur")
    public List<Plant> getPlantenByName(@RequestParam String kleur){
        return mPlantDAO.findPlantByKleur(kleur);
    }

    @GetMapping("/prijs")
    public List<Plant> getPlantenByPriceBetween(@RequestParam double min,
                                                @RequestParam double max){
        return mPlantDAO.findPlantByPrijsIsBetween(min, max);
    }
    @PostMapping
    public HttpStatus insertPlant(@RequestParam String plantennaam,
                                  @RequestParam String soort,
                                  @RequestParam String kleur,
                                  @RequestParam double prijs){
        Plant toSave = new Plant();
        toSave.setArtCode(0);
        toSave.setPlantennaam(plantennaam);
        toSave.setSoort(soort);
        toSave.setKleur(kleur);
        toSave.setPrijs(prijs);

        mPlantDAO.save(toSave);

        return HttpStatus.OK;
    }
}
