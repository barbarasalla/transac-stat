package com.practice.transacstat.transacao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacaoRepository {

    public static List<Transacao> transacaoList = new ArrayList<>();

    public void add (Transacao transacao){
        transacaoList.add(transacao);
    }

    public void clearAll() {
        transacaoList.clear();
    }

    public List<Transacao> getTransacaoList() {
        return transacaoList;
    }
}
