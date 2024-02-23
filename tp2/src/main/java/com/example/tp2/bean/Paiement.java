package com.example.tp2.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Paiement {

    @Id
    @GeneratedValue
    private Long id;
    private double amoumt;
    private String code;
    @ManyToOne
    private Commande commande;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public double getAmoumt() {
        return amoumt;
    }

    public void setAmoumt(double amoumt) {
        this.amoumt = amoumt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
