package com.practice.transacstat.transacao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@Slf4j
public class TransacaoServiceImpl implements TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoServiceImpl(TransacaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTransacao(Transacao transacao){
        log.info("Iniciando processamento de transação.");
        validFieldDateTransacao(transacao);
        validFieldValorTransacao(transacao);

        repository.add(transacao);
        log.info("Transação registrada com sucesso.");
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
