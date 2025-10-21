package be.ehb.plantentuin.model.dto;

import be.ehb.plantentuin.model.dao.BestellingDAO;
import be.ehb.plantentuin.model.entities.Bestelling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BestellingService {

    BestellingDAO bestellingDAO;

    @Autowired
    public BestellingService(BestellingDAO bestellingDAO) {
        this.bestellingDAO = bestellingDAO;
    }

    public Optional<BestellingDTO> getBestellingById(int id) {
        Optional<Bestelling> bestelling = Optional.empty();
        try {
            bestelling = bestellingDAO.findById(id);
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return Optional.of(new BestellingDTO(bestelling.get().getBestelNR(),
                bestelling.get().getBedrag()));
    }

    public List<BestellingDTO> getBestellingen() {
        Iterable<Bestelling> bestellingen = new ArrayList<>();
        try {
            bestellingen = bestellingDAO.findAll();
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return Collections.emptyList();
    }

}
