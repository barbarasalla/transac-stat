package com.practice.transacstat.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "estatistica")
public class EstatisticaProperties {

    public static long securityTime;

    public void setSecurityTime(long securityTime) {
        EstatisticaProperties.securityTime = securityTime;
    }
}
