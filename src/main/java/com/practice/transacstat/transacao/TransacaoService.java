package com.practice.transacstat.transacao;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void createTransacao(Transacao transacao){
        validFieldDateTransacao(transacao);
        validFieldValorTransacao(transacao);
    }

    private void validFieldDateTransacao(Transacao transacao) {
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("A data da transação não é válida.");
        }
    }

    private void validFieldValorTransacao(Transacao transacao) {
        if (transacao.getValor().compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Valor da transação é inválido.");
        }
    }
}
