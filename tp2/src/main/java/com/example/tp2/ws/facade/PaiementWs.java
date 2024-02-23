package com.example.tp2.ws.facade;

import com.example.tp2.bean.Paiement;
import com.example.tp2.service.PaiementService;
import com.example.tp2.ws.converter.CommandeConverter;
import com.example.tp2.ws.converter.PaiementConverter;
import com.example.tp2.ws.dto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ms-commande/paiement/")
public class PaiementWs {

    @Autowired
    private PaiementService service;
    @Autowired
    private PaiementConverter converter;


    @GetMapping
    public List<PaiementDto> findAll() {
        converter.setCommande(false);
        List<Paiement> paiements = service.findAll();
        return converter.toDto(paiements);
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody Paiement entity) {
        int result = service.save(entity);
        if (result < 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
    }

    @GetMapping("commande/ref/{ref}")
    public List<PaiementDto> findByCommandeRef(@PathVariable String ref) {
        converter.setCommande(false);
        List<Paiement>  commande = service.findByCommandeRef(ref);
        return converter.toDto(commande);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("code/{code}")
    public PaiementDto findByCode(@PathVariable String code) {
        converter.setCommande(false);
        Paiement paiement = service.findByCode(code);
        return converter.toDto(paiement);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("id/{id}")
    public Optional<Paiement> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
