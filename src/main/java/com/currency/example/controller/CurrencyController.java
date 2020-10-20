package com.currency.example.controller;

import com.currency.example.dto.ExchangeRatesData;
import com.currency.example.dto.BasicResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
public class CurrencyController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${update.data.url}")
    private String URL;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyController.class);


    @GetMapping("/{currency}")
    public ResponseEntity<BasicResponseData> getAccountData(@PathVariable("currency") final String currency,
                                                            @RequestParam(defaultValue = "RON", required = false) String transform) {


        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity request = new HttpEntity(headers);
        try {
            ResponseEntity<ExchangeRatesData> response = this.restTemplate.exchange(URL + transform, HttpMethod.GET, request,
                    ExchangeRatesData.class);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                ExchangeRatesData exchangeRatesData = response.getBody();
                logger.info(exchangeRatesData.toString());
                return new ResponseEntity<>(new BasicResponseData(transform,
                        currency, exchangeRatesData.getDate(), exchangeRatesData.getRates().get(currency)), HttpStatus.OK);
            } else {
                logger.debug("Required data could not be retrieved");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (HttpStatusCodeException e) {
            logger.debug("Required data could not be retrieved");
            return new ResponseEntity<>(e.getStatusCode());
        }
    }
}