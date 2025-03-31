package com.practice.transacstat.transacao;
import java.util.List;

public interface TransacaoService {

    void createTransacao(Transacao transacao);

    void deleteAllTransacao();

    List<Transacao> getTransacaoList();
}
