package com.product.service.dto.listProduct;

import com.product.service.dto.ImageDto;
import com.product.service.dto.image.ImageResponse;
import com.product.service.entity.Image;
import com.product.service.entity.constants.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOfProductsDto {

    private Long id;
    private Long userId;
    private List<ImageResponse> images;
    private Double price;
    private Currency currency;
    private Integer roomCount;
    private Double totalArea;
    private Integer floorNumber;
    private Integer floorCount;
    private String address;
    private Boolean isFavorite;
    private Double lan;
    private Double lat;
    private String phoneNumber;
    private Boolean enableChat;
}
