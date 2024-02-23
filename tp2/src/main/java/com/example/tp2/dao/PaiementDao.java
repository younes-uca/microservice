package com.example.tp2.dao;

import com.example.tp2.bean.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {
    Paiement findByCode(String code);

    int deleteByCode(String code);

    List<Paiement> findByCommandeRef(String ref);

    int deleteByCommandeRef(String ref);
}
