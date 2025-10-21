package be.ehb.plantentuin.controllers;


import be.ehb.plantentuin.model.dto.BestellingDTO;
import be.ehb.plantentuin.model.dto.BestellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/bestellingen")
public class BestellingController {

    BestellingService bestellingService;

    @Autowired
    public BestellingController(BestellingService bestellingService) {
        this.bestellingService = bestellingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BestellingDTO> getBestelling(@PathVariable int id) {
        Optional<BestellingDTO> bestelling;
        try {
            bestelling = bestellingService.getBestellingById(id);
            if (bestelling.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(bestelling.get(), HttpStatus.OK);
    }

}

