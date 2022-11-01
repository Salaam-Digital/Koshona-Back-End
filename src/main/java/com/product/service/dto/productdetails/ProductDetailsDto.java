package com.product.service.dto.productdetails;

import com.product.service.entity.Image;
import com.product.service.entity.constants.Currency;
import com.product.service.entity.constants.HomeMaterial;
import com.product.service.entity.constants.HomeType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDetailsDto {

    private Long id;
    private Long userId;
    private List<Image> images;
    private Double price;
    private Currency currency;
    private Integer roomCount;
    //Kvadrat metr umumiy ??
    private Double totalArea;
    //Nechinchi qavat
    private Integer floorNumber;
    //Jami necha qavatli
    private Integer floorCount;
    private String address;
    //favorite ga qoshish izbranniy
    private Boolean isFavorite;
    private Double lat;
    private Double lan;
    private Double longitude;
    private String phoneNumber;
    private Boolean enablePhone;
    private Boolean enableChat;
    private String createdAt;
    private String updatedAt;
    //yashash maydoni
    private Double livingArea;
    //balkon
    private Boolean balcony;
    //Mebellari bn birga sotiladimi
    private Boolean withFurniture;
    private Integer builtYear;
    //ENUM
    private HomeType type;
    //ENUM uy materiali
    private HomeMaterial material;
    private Boolean elevator;
    private Boolean parking;
    private String description;
    // prosmotr
    private Integer viewCount;
}
