package be.ehb.plantentuin.model.dao;

import be.ehb.plantentuin.model.entities.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantDAO extends CrudRepository<Plant, Integer> {

    List<Plant> findPlantByKleur(String kleur);
    List<Plant> findPlantByPrijsIsBetween(double min, double max);

}
