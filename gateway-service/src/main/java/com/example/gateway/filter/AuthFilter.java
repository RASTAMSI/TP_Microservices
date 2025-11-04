package com.example.gateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {

    private final WebClient webClient;

    @Value("${auth.service.url}")
    private String authServiceUrl;

    public AuthFilter(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        // Lire headers
        String username = request.getHeaders().getFirst("username");
        String password = request.getHeaders().getFirst("password");
        String role     = request.getHeaders().getFirst("role");

        // Vérifier présence
        if (username == null || password == null || role == null) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }

        // Appel à authorization-service
        return webClient.get()
                .uri(authServiceUrl + "/auth/validate")
                .header("username", username)
                .header("password", password)
                .header("role", role)
                .retrieve()
                .onStatus(HttpStatusCode::isError, resp -> Mono.error(new RuntimeException("AUTH ERROR")))
                .toBodilessEntity()
                .flatMap(resp -> chain.filter(exchange)) // OK → continue
                .onErrorResume(e -> { // AUTH FAILED
                    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                    return exchange.getResponse().setComplete();
                });
    }
}
