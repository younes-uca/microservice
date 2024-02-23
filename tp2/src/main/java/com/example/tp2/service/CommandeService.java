package com.example.tp2.service;

import com.example.tp2.bean.Client;
import com.example.tp2.bean.Commande;
import com.example.tp2.dao.CommandeDao;
import com.example.tp2.requiered.facade.ClientRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private CommandeDao dao;
    @Autowired
    private PaiementService paiementService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRequired clientRequired;

    public List<Commande> findAll() {
        return dao.findAll();
    }

    public int save(Commande entity) {
        String code = entity.getClient().getCode();
        if (findByRef(entity.getRef()) != null) {
            return -1;
        } else if (entity.getTotalPaye() > entity.getTotal()) {
            return -2;
        } else {
            Client client = clientService.findByCode(code);
            if (client == null) {
                client = clientRequired.findByCode(code);
            }
            entity.setClient(client);
            dao.save(entity);
            return 1;
        }
    }

    public Optional<Commande> findById(Long aLong) {
        return dao.findById(aLong);
    }

    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    public Commande findByRef(String ref) {
        Commande commande = dao.findByRef(ref);
        Client client = clientRequired.findByCode("cl1");
        commande.setClient(client);
        return commande;
    }

    @Transactional
    public int deleteByRef(String ref) {
        int result1 = paiementService.deleteByCommandeRef(ref);
        int result2 = dao.deleteByRef(ref);
        return result1 + result2;
    }
}
