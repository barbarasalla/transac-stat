package com.practice.transacstat.estatistica;

import com.practice.transacstat.configuration.EstatisticaProperties;
import com.practice.transacstat.transacao.TransacaoService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.stream.DoubleStream;

@Service
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public Estatistica calculeStatic(){
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC).minusSeconds(EstatisticaProperties.securityTime);

        DoubleStream values = transacaoService.getTransacaoList().stream()
                .filter(transacao -> transacao.getDataHora().isAfter(now))
                .mapToDouble(transacao -> transacao.getValor().doubleValue());
        return new Estatistica(values.summaryStatistics());
    }
}
