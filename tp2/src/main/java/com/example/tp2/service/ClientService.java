package com.example.tp2.service;

import com.example.tp2.bean.Client;
import com.example.tp2.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientDao dao;


    public List<Client> findAll() {
        return dao.findAll();
    }

    public int save(Client entity) {
        if (findByCode(entity.getCode()) != null) {
            return -1;
        } else {
            dao.save(entity);
            return 1;
        }
    }

    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    public Client findByCode(String code) {
        return dao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    public Optional<Client> findById(Long aLong) {
        return dao.findById(aLong);
    }
}
