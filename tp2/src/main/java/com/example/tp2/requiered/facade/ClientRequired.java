package com.example.tp2.requiered.facade;

import com.example.tp2.bean.Client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "client-service")
public interface ClientRequired {

    @GetMapping("/api/client-service/client/code/{code}")
    @CircuitBreaker(name = "clientFindByCodeCircuitBreaker", fallbackMethod = "getDefaultClient")
    Client findByCode(@PathVariable String code);

    @GetMapping("/api/client-service/client/")
    List<Client> findAll();

    default Client getDefaultClient(String code, Exception exception) {
        Client client = new Client();
        client.setCode(code);
        client.setName("Unknown");
        return client;
    }
}
