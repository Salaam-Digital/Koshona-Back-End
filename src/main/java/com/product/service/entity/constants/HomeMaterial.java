package com.product.service.entity.constants;

import lombok.Getter;

@Getter
public enum HomeMaterial {

    BRICK("Brick"),
    FUNDAMENT("Fundament");

    private String homeMaterial;

    HomeMaterial(String homeMaterial) {
        this.homeMaterial = homeMaterial;
    }
}
