package com.example.tp2.ws.facade;

import com.example.tp2.bean.Client;
import com.example.tp2.bean.Commande;
import com.example.tp2.requiered.facade.ClientRequired;
import com.example.tp2.requiered.vo.ClientVo;
import com.example.tp2.service.CommandeService;
import com.example.tp2.ws.converter.CommandeConverter;
import com.example.tp2.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/commande-service/commande/")
public class CommandeWs {
    @Autowired
    private CommandeService service;
    @Autowired
    private CommandeConverter converter;
    @Autowired
    private ClientRequired clientRequired;

    @GetMapping("client/")
    public List<Client> findAllClient() {
        return clientRequired.findAll();
    }
    @GetMapping
    public List<CommandeDto> findAll() {
        System.out.println("******************** findAll");
        List<Commande> commandes = service.findAll();
        converter.setPaiement(false);
        converter.setClient(true);
        List<CommandeDto> dtos = converter.toDto(commandes);
        return dtos;
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody CommandeDto dto) {
        converter.setClient(true);
        Commande entity = converter.toBean(dto);
        int result = service.save(entity);
        if (result < 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
    }

    @GetMapping("id/{id}")
    public Optional<Commande> findById(@PathVariable Long id) {
        converter.setPaiement(false);
        converter.setClient(true);
        return service.findById(id);
    }

    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("ref/{ref}")
    public Commande findByRef(@PathVariable String ref) {
        converter.setPaiement(false);
        converter.setClient(true);
        System.out.println("******************** find by ref = " + ref);
        return service.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return service.deleteByRef(ref);
    }
}
