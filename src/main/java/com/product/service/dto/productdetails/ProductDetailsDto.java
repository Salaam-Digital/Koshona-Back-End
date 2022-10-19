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
    //Xonalar soni
    private Integer room_count;
    //Kvadrat metr umumiy ??
    private Double total_area;
    //Nechinchi qavat
    private Integer floor_number;
    //Jami necha qavatli
    private Integer floor_count;
    private String address;
    //favorite ga qoshish izbranniy
    private Boolean isFavorite;
    private Double lat;
    private Double lan;
    private Double longitude;
    private String phone_number;
    private Boolean enablePhone;
    private Boolean enable_chat;
    private String created_at;
    private String update_at;
    //yashash maydoni
    private Double living_area;
    //balkon
    private Boolean balcony;
    //Mebellari bn birga sotiladimi
    private Boolean withFurniture;
    private Integer built_year;
    //ENUM
    private HomeType type;
    //ENUM uy materiali
    private HomeMaterial material;
    private Boolean elevator;
    private Boolean parking;
    private String description;
    // prosmotr
    private Integer view_count;
}
