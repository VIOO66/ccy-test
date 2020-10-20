package com.currency.example.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class BasicResponseData implements Serializable {

    private String baseCurrency;
    private String secondaryCurrency;
    private LocalDate date;
    private Double rate;

    public BasicResponseData(String baseCurrency, String secondaryCurrency, LocalDate date, Double rate) {
        this.baseCurrency = baseCurrency;
        this.secondaryCurrency = secondaryCurrency;
        this.date = date;
        this.rate = rate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getSecondaryCurrency() {
        return secondaryCurrency;
    }

    public void setSecondaryCurrency(String secondaryCurrency) {
        this.secondaryCurrency = secondaryCurrency;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
