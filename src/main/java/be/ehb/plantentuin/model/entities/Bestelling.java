package be.ehb.plantentuin.model.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bestelNR;
    @Temporal(TemporalType.DATE)
    private LocalDate bestelDatum;
    @DecimalMin("0.5")
    private double bedrag;
    @ManyToOne
    @JoinColumn(name = "levCode", nullable = false)
    private Leverancier leverancier;

    public Bestelling() {
    }

    public Bestelling(int bestelNR, LocalDate bestelDatum, double bedrag, Leverancier leverancier) {
        this.bestelNR = bestelNR;
        this.bestelDatum = bestelDatum;
        this.bedrag = bedrag;
        this.leverancier = leverancier;
    }

    public int getBestelNR() {
        return bestelNR;
    }

    public void setBestelNR(int bestelNR) {
        this.bestelNR = bestelNR;
    }

    public LocalDate getBestelDatum() {
        return bestelDatum;
    }

    public void setBestelDatum(LocalDate bestelDatum) {
        this.bestelDatum = bestelDatum;
    }

    public double getBedrag() {
        return bedrag;
    }

    public void setBedrag(double bedrag) {
        this.bedrag = bedrag;
    }

    public Leverancier getLeverancier() {
        return leverancier;
    }

    public void setLeverancier(Leverancier leverancier) {
        this.leverancier = leverancier;
    }
}
