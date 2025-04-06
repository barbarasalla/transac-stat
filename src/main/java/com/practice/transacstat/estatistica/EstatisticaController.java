package com.practice.transacstat.estatistica;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/estatistica")
    public ResponseEntity<Estatistica> getEstatistica(){
        return ResponseEntity.ok(estatisticaService.calculeStatic());
    }

}
