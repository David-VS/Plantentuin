package be.ehb.plantentuin.controllers;

import be.ehb.plantentuin.model.dao.LeverancierDAO;
import be.ehb.plantentuin.model.entities.Bestelling;
import be.ehb.plantentuin.model.entities.Leverancier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leveranciers")
public class LeveranciersAPIController {

    private LeverancierDAO leverancierDAO;

    @Autowired
    public LeveranciersAPIController(LeverancierDAO leverancierDAO) {
        this.leverancierDAO = leverancierDAO;
    }

    @GetMapping
    public Iterable<Leverancier> getAllLeveranciesWantDatIsFLemglish(){
        return leverancierDAO.findAll();
    }

    @GetMapping("/{id}")
    public Iterable<Bestelling> getBestellingenFor(@PathVariable int id){

        if(leverancierDAO.existsById(id)) {
            Leverancier gevonden = leverancierDAO.findById(id).get();
            return gevonden.getBestellingen();
        }
        return null;
    }
}
