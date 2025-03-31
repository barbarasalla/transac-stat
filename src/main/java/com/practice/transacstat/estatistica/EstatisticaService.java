package com.practice.transacstat.estatistica;

import com.practice.transacstat.transacao.TransacaoService;
import org.springframework.stereotype.Service;

import java.util.stream.DoubleStream;

@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public Estatistica calculeStatic(){
        DoubleStream values = transacaoService.getTransacaoList().stream().mapToDouble(transacao -> transacao.getValor().doubleValue());
        return new Estatistica(values.summaryStatistics());
    }
}
