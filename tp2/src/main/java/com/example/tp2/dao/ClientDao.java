package com.example.tp2.dao;

import com.example.tp2.bean.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
    Client findByCode(String code);

    int deleteByCode(String code);

}
