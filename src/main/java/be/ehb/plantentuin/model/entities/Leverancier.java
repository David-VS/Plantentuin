package be.ehb.plantentuin.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Leverancier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int levCode;
    @NotBlank
    @Size(min = 3, max = 200)
    private String lev_naam;
    @NotBlank
    private String adres;
    @NotBlank
    private String woonplaats;

    public Leverancier() {
    }

    public int getLevCode() {
        return levCode;
    }

    public void setLevCode(int levCode) {
        this.levCode = levCode;
    }

    public String getLev_naam() {
        return lev_naam;
    }

    public void setLev_naam(String lev_naam) {
        this.lev_naam = lev_naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }
}
