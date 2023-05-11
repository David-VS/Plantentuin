package be.ehb.plantentuin.model.dao;

import be.ehb.plantentuin.model.entities.Bestelling;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BestellingDAO extends CrudRepository<Bestelling, Integer> {
}
