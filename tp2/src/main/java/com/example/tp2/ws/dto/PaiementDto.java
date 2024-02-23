package com.example.tp2.ws.dto;

public class PaiementDto {

    private double amoumt;
    private String code;
    private CommandeDto commandeDto;


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

    public CommandeDto getCommande() {
        return commandeDto;
    }

    public void setCommande(CommandeDto commandeDto) {
        this.commandeDto = commandeDto;
    }
}
