package com.example.tp2.ws.converter;

import com.example.tp2.bean.Paiement;
import com.example.tp2.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {
    @Autowired
    private CommandeConverter commandeConverter;
    private boolean commande;

    public PaiementDto toDto(Paiement item) {
        PaiementDto dto = new PaiementDto();
        if (item.getCode() != null) {
            dto.setCode(item.getCode());
        }
        dto.setAmoumt(item.getAmoumt());
        if (commande && item.getCommande() != null) {
            dto.setCommande(commandeConverter.toDto(item.getCommande()));
        }
        return dto;
    }


    public Paiement toBean(PaiementDto dto) {
        Paiement bean = new Paiement();
        BeanUtils.copyProperties(dto, bean);
        if (dto.getCommande() != null) {
            bean.setCommande(commandeConverter.toBean(dto.getCommande()));
        }
        return bean;
    }


    public List<Paiement> toBean(List<PaiementDto> dtos) {
        List<Paiement> result = null;
        if (dtos != null) {
            result = dtos.stream().map(this::toBean).collect(Collectors.toList());
        }
        return result;
    }


    public List<PaiementDto> toDto(List<Paiement> items) {
        List<PaiementDto> result = null;
        if (items != null) {
            result = items.stream().map(this::toDto).collect(Collectors.toList());
        }
        return result;
    }

    public boolean isCommande() {
        return commande;
    }

    public void setCommande(boolean commande) {
        this.commande = commande;
    }
}

