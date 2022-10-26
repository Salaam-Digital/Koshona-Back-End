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
    //Kvadrat metr umumiy ??
    private Double totalArea;
    //Nechinchi qavat
    private Integer floorNumber;
    //Jami necha qavatli
    private Integer floorCount;
    private String address;
    private Boolean isFavorite;
    private Double lan;
    private Double lat;
    private String phoneNumber;
    private Boolean enablePhone;
    private Boolean enableChat;
    //yashash maydoni
    private Double areaLength;
    private Boolean balcony;
    private Boolean withFurniture;
    private Integer builtYear;
    private Boolean elevator;
    private Boolean parking;
    private String description;
    private Integer viewCount;

    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private HomeType type;
    @Enumerated(EnumType.STRING)
    private HomeMaterial material;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images;
}
