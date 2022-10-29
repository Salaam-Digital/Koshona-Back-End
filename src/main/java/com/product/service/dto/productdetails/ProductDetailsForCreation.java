package com.product.service.dto.productdetails;

import com.product.service.entity.constants.Currency;
import com.product.service.entity.constants.HomeMaterial;
import com.product.service.entity.constants.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsForCreation {


    private Long userId;
    private Double price;
    private Currency currency;
    private Integer roomCount;
    private Double totalArea;
    private Integer floorNumber;
    private Integer floorCount;
    private String address;
    private Boolean isFavorite;
    private Double lat;
    private Double lan;
    private Double longitude;
    private String phoneNumber;
    private Boolean enablePhone;
    private Boolean enableChat;
    private String createdAt;
    private String updatedAt;
    private Double livingArea;
    private Boolean balcony;
    private Boolean withFurniture;
    private Integer builtYear;
    private HomeType type;
    private HomeMaterial material;
    private Boolean elevator;
    private Boolean parking;
    private String description;
    private Integer viewCount;
}
