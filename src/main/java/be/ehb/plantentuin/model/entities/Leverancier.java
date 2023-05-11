package be.ehb.plantentuin.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties("bestellingen")
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
    @OneToMany(mappedBy = "leverancier")
    private List<Bestelling> bestellingen = new ArrayList<>();

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

    public List<Bestelling> getBestellingen() {
        return bestellingen;
    }

    public void setBestellingen(List<Bestelling> bestellingen) {
        this.bestellingen = bestellingen;
    }
}
