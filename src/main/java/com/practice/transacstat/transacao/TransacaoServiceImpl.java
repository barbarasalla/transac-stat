package com.practice.transacstat.transacao;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoServiceImpl(TransacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTransacao(Transacao transacao){
        validFieldDateTransacao(transacao);
        validFieldValorTransacao(transacao);

        repository.add(transacao);
    }

    @Override
    public void deleteAllTransacao(){
        repository.clearAll();
    }

    @Override
    public List<Transacao> getTransacaoList(){
        return repository.getTransacaoList();
    }

    private void validFieldDateTransacao(Transacao transacao) {
        if (transacao.getDataHora().atZoneSimilarLocal(ZoneId.of("America/Sao_Paulo"))
                .isAfter(OffsetDateTime.now().atZoneSimilarLocal(ZoneId.of("America/Sao_Paulo")))){
            throw new IllegalArgumentException("A data da transação não é válida.");
        }
    }

    private void validFieldValorTransacao(Transacao transacao) {
        if (transacao.getValor().compareTo(BigDecimal.ZERO)<0){
            throw new IllegalArgumentException("Valor da transação é inválido.");
        }
    }
}
