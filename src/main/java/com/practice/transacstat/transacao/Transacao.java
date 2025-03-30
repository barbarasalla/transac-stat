package com.practice.transacstat.transacao;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class Transacao {

    @NonNull
    private BigDecimal valor;

    @NonNull
    private OffsetDateTime dataHora;
}
