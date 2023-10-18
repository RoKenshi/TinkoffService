package ru.popov.tinkoffservice.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.piapi.core.InvestApi;

@Configuration
@EnableConfigurationProperties(ApiConfig.class)
@RequiredArgsConstructor
public class ApplicationConfig {
    private final ApiConfig apiConfig;

    private final String ssoToken = "t.Cjj4ZeZ8l2xWiP7UN-1p-y9OngWpDLzJv7TBDF576BFY5-ER3_f4qOcDmfcfziVOH9ST4ZionDMheEJLwSP7eQ";

    @Bean
    public InvestApi api() {

        InvestApi investApi = InvestApi.create(ssoToken);
        return investApi;

    }
}
