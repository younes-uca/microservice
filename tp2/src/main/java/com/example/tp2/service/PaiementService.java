package com.example.tp2.service;

import com.example.tp2.bean.Paiement;
import com.example.tp2.dao.PaiementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {
    @Autowired
    private PaiementDao dao;


    public List<Paiement> findAll() {
        return dao.findAll();
    }

    public int save(Paiement entity) {
        if (findByCode(entity.getCode()) != null) {
            return -1;
        } else {
            dao.save(entity);
            return 1;
        }
    }

    public List<Paiement> findByCommandeRef(String ref) {
        return dao.findByCommandeRef(ref);
    }

    public int deleteByCommandeRef(String ref) {
        return dao.deleteByCommandeRef(ref);
    }

    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    public Paiement findByCode(String code) {
        return dao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    public Optional<Paiement> findById(Long aLong) {
        return dao.findById(aLong);
    }
}
