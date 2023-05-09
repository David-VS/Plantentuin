package be.ehb.plantentuin.controllers;

import be.ehb.plantentuin.model.dao.LeverancierDAO;
import org.springframework.beans.factory.annotation.Autowired;
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


}
