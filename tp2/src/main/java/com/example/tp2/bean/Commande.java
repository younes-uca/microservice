package com.example.tp2.bean;

import com.example.tp2.requiered.facade.ClientRequired;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue
    private Long id;
    private String ref;
    private double total;
    private double totalPaye;
    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "commande")
    private List<Paiement> paiements;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(double totalPaye) {
        this.totalPaye = totalPaye;
    }
}
