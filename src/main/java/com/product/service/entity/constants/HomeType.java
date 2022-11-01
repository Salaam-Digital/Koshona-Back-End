package com.product.service.entity.constants;

import lombok.Getter;

@Getter
public enum HomeType {

    HOUSE("House"),
    FLAT("Flat"),
    VILLA("Villa");

    private String homeType;

    HomeType(String homeType) {
        this.homeType = homeType;
    }
}
