package com.orderservice.webclient;

import com.orderservice.dto.PurchaseRequest;
import com.orderservice.dto.PurchaseResponse;
import com.orderservice.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClient {

    private final WebClient webClient;

    private final Logger logger = LoggerFactory.getLogger(ProductClient.class);

    public List<PurchaseResponse> purchaseResponses(List<PurchaseRequest> purchaseRequests){
        return webClient
                .post()
                .uri("/purchase")
                .bodyValue(purchaseRequests)
                .retrieve()
                .onStatus(HttpStatusCode::isError, response -> {
                    logger.error("Error occurred: {}", response.statusCode());
                    return Mono.error(new BusinessException("Error occurred: " + response.statusCode()));
                })
                .bodyToMono(new ParameterizedTypeReference<List<PurchaseResponse>>() {})
                .defaultIfEmpty(Collections.emptyList())
                .block();
    }
}
