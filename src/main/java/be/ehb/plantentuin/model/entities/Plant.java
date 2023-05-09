package be.ehb.plantentuin.model.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


@Entity
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int artCode;
    @NotNull
    private String plantennaam;
    @NotNull
    private String soort;
    private String kleur;
    @DecimalMin("0.99")
    private double prijs;

    public Plant() {
    }

    public int getArtCode() {
        return artCode;
    }

    public void setArtCode(int artCode) {
        this.artCode = artCode;
    }

    public String getPlantennaam() {
        return plantennaam;
    }

    public void setPlantennaam(String plantennaam) {
        this.plantennaam = plantennaam;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
