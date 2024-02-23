package com.example.tp3.requiered.facade;

import com.example.tp3.requiered.vo.CommandeVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms2",url = "localhost:8090/api/commande")
//@FeignClient(name = "commande-service")
public interface CommandeRequired {

    @GetMapping("/api/commande-service/commande/ref/{ref}")
    CommandeVo findByRef(@PathVariable String ref);
}
