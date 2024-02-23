package com.example.tp2.ws.extern;

import com.example.tp2.bean.Client;
import com.example.tp2.bean.Commande;
import com.example.tp2.requiered.facade.ClientRequired;
import com.example.tp2.service.CommandeService;
import com.example.tp2.ws.converter.CommandeConverter;
import com.example.tp2.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/commande-service/client/")
public class ClientWs {

    @Autowired
    private ClientRequired clientRequired;


    @GetMapping("code/{code}")
    public Client findByCode(@PathVariable String code) {
        return clientRequired.findByCode(code);
    }
}
