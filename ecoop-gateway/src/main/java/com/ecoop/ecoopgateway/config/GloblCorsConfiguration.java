package com.ecoop.ecoopgateway.config;


import com.ecoop.ecoopgateway.filter.CorsResponseHeaderFilter;
import com.ecoop.ecoopgateway.filter.TokenFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.DefaultCorsProcessor;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;


/**
 * @ClassName CorsConfiguration
 * @Description TODO
 * @Author crazy
 * @Date 2019-08-07 10:43
 * @Version 1.0
 **/
@Configuration
@EnableConfigurationProperties({ServerProperties.class})
public class GloblCorsConfiguration {
    @Bean
    public CorsResponseHeaderFilter corsResponseHeaderFilter() {
        return new CorsResponseHeaderFilter();
    }

    @Bean
    public TokenFilter tokenFilter(ServerProperties serverProperties) {
        return new TokenFilter(serverProperties);
    }

    @Bean
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", buildCorsConfiguration());

        CorsWebFilter corsWebFilter = new CorsWebFilter(source, new DefaultCorsProcessor() {
            @Override
            protected boolean handleInternal(ServerWebExchange exchange, CorsConfiguration config,
                                             boolean preFlightRequest)
            {
                // 预留扩展点
                // if (exchange.getRequest().getMethod() == HttpMethod.OPTIONS) {
                return super.handleInternal(exchange, config, preFlightRequest);
                // }

                // return true;
            }
        });

        return corsWebFilter;
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");

        corsConfiguration.addAllowedMethod(HttpMethod.OPTIONS);
        corsConfiguration.addAllowedMethod(HttpMethod.POST);
        corsConfiguration.addAllowedMethod(HttpMethod.GET);
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.addAllowedMethod(HttpMethod.PATCH);

        corsConfiguration.addAllowedHeader("origin");
        corsConfiguration.addAllowedHeader("content-type");
        corsConfiguration.addAllowedHeader("accept");
        corsConfiguration.addAllowedHeader("x-requested-with");
        corsConfiguration.addAllowedHeader("Referer");

        corsConfiguration.setMaxAge(7200L);
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}
