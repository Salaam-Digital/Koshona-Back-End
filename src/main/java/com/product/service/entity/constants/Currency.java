package com.product.service.entity.constants;

import lombok.Getter;

@Getter
public enum Currency {

    SUM("SUM"),
    USD("USD"),
    EURO("EURO");

    private String currency;

    Currency(String currency) {
        this.currency = currency;
    }
}
