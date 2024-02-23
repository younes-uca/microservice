package com.example.tp2.ws.dto;

import java.util.List;

public class CommandeDto {

    private String ref;
    private double total;
    private double totalPaye;
    private List<PaiementDto> paiements;
    private ClientDto client;

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<PaiementDto> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<PaiementDto> paiements) {
        this.paiements = paiements;
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
