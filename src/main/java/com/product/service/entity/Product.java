package com.product.service.entity;

import com.product.service.entity.constants.Currency;
import com.product.service.entity.constants.HomeMaterial;
import com.product.service.entity.constants.HomeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{

    private Long userId;
    private Double price;
    private Integer roomCount;
    private Double totalArea;
    private Integer floorNumber;
    private Integer floorCount;
    private String address;
    private Boolean isFavorite;
    private Double lan;
    private Double lat;
    private String phoneNumber;
    private Boolean enablePhone;
    private Boolean enableChat;
    private Double areaLength;
    private Boolean balcony;
    private Boolean withFurniture;
    private Integer builtYear;
    private Boolean elevator;
    private Boolean parking;
    private String description;
    private Integer viewCount;
    private String uniqueId;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private HomeType type;
    @Enumerated(EnumType.STRING)
    private HomeMaterial material;

}
