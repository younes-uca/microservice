package com.example.tp3.service.impl;

import com.example.tp3.bean.Client;
import com.example.tp3.dao.ClientDao;
import com.example.tp3.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao dao;


    @Override
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
    @Override
    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }
    @Override
    public Client findByCode(String code) {
        return dao.findByCode(code);
    }
    @Override
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }
    @Override
    public Optional<Client> findById(Long aLong) {
        return dao.findById(aLong);
    }
}
