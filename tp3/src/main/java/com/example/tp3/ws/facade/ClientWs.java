package com.example.tp3.ws.facade;

import com.example.tp3.bean.Client;
import com.example.tp3.requiered.facade.CommandeRequired;
import com.example.tp3.requiered.vo.CommandeVo;
import com.example.tp3.service.impl.ClientServiceImpl;
import com.example.tp3.ws.converter.ClientConverter;
import com.example.tp3.ws.dto.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/client-service/client/")
public class ClientWs {

    @Autowired
    private ClientServiceImpl service;
    @Autowired
    private ClientConverter converter;
    @Autowired
    private CommandeRequired commandeRequired;


    @GetMapping("ref/{ref}")
    public CommandeVo findByRef(@PathVariable String ref) {
        return commandeRequired.findByRef(ref);
    }

    @GetMapping
    public List<ClientDto> findAll() {
        List<Client> clients = service.findAll();
        return converter.toDto(clients);
    }

    @PostMapping
    public ResponseEntity<Integer> save(@RequestBody Client entity) {
        int result = service.save(entity);
        if (result < 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
    }


    @DeleteMapping("id/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("code/{code}")
    public ClientDto findByCode(@PathVariable String code) {
        Client client = service.findByCode(code);
        return converter.toDto(client);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("id/{id}")
    public Optional<Client> findById(@PathVariable Long id) {
        return service.findById(id);
    }
}
