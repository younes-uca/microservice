package com.example.tp2.ws.converter;

import com.example.tp2.bean.Commande;
import com.example.tp2.ws.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeConverter {

    @Autowired
    private PaiementConverter paiementConverter;
    private boolean paiement;
    @Autowired
    private ClientConverter clientConverter;
    private boolean client;

    public CommandeDto toDto(Commande item) {
        CommandeDto dto = new CommandeDto();
        if (item.getRef() != null) {
            dto.setRef(item.getRef());
        }
        dto.setTotal(item.getTotal());
        dto.setTotalPaye(item.getTotalPaye());
        if (paiement && item.getPaiements() != null) {
            dto.setPaiements(paiementConverter.toDto(item.getPaiements()));
        }
        if (client && item.getClient() != null) {
            dto.setClient(clientConverter.toDto(item.getClient()));
        }
        return dto;
    }


    public Commande toBean(CommandeDto dto) {
        Commande bean = new Commande();
        BeanUtils.copyProperties(dto, bean);
        if (paiement && dto.getPaiements() != null) {
            bean.setPaiements(paiementConverter.toBean(dto.getPaiements()));
        }
        if (client && dto.getClient() != null) {
            bean.setClient(clientConverter.toBean(dto.getClient()));
        }
        return bean;
    }


    public List<Commande> toBean(List<CommandeDto> dtos) {
        List<Commande> result = null;
        if (dtos != null) {
            result = dtos.stream().map(this::toBean).collect(Collectors.toList());
        }
        return result;
    }


    public List<CommandeDto> toDto(List<Commande> items) {
        List<CommandeDto> result = null;
        if (items != null) {
            result = items.stream().map(this::toDto).collect(Collectors.toList());
        }
        return result;
    }

    public boolean isPaiement() {
        return paiement;
    }

    public void setPaiement(boolean paiement) {
        this.paiement = paiement;
    }

    public boolean isClient() {
        return client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }
}

