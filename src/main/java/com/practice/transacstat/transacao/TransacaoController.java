package com.practice.transacstat.transacao;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid Transacao transacao){
       service.createTransacao(transacao);
       return ResponseEntity.ok(HttpStatus.CREATED);
   }

    @DeleteMapping("/all")
    public ResponseEntity<HttpStatus> deleteAll(){
        service.deleteAllTransacao();
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
