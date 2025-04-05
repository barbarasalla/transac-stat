package com.practice.transacstat.estatistica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatiscaController {

    private final EstatisticaService estatisticaService;

    public EstatiscaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<Estatistica> getEstatistica(){
        return ResponseEntity.ok(estatisticaService.calculeStatic());
    }

}
