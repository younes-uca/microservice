package com.example.tp3.ws.converter;

import com.example.tp3.bean.Client;
import com.example.tp3.ws.dto.ClientDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    public ClientDto toDto(Client bean) {
        ClientDto dto = new ClientDto();
        BeanUtils.copyProperties(bean, dto);
        return dto;
    }


    public Client toBean(ClientDto dto) {
        Client bean = new Client();
        BeanUtils.copyProperties(dto, bean);
        return bean;
    }


    public List<Client> toBean(List<ClientDto> dtos) {
        List<Client> result = null;
        if (dtos != null) {
            result = dtos.stream().map(this::toBean).collect(Collectors.toList());
        }
        return result;
    }


    public List<ClientDto> toDto(List<Client> items) {
        List<ClientDto> result = null;
        if (items != null) {
            result = items.stream().map(this::toDto).collect(Collectors.toList());
        }
        return result;
    }

}

