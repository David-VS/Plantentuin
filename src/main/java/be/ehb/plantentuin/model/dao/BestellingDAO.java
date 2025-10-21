package be.ehb.plantentuin.model.dao;

import be.ehb.plantentuin.model.entities.Bestelling;
import be.ehb.plantentuin.model.entities.Leverancier;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BestellingDAO extends CrudRepository<Bestelling, Integer> {
    ArrayList<Bestelling> findByLeverancier(Leverancier lev);
}
