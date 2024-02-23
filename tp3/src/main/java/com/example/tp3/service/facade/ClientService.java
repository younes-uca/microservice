package com.example.tp3.service.facade;

import com.example.tp3.bean.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();

    void deleteById(Long aLong);

    Client findByCode(String code);

    int deleteByCode(String code);

    Optional<Client> findById(Long aLong);
}
