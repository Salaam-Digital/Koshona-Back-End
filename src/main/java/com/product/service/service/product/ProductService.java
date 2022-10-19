package com.product.service.service.product;

import com.product.service.dto.ApiResponse;
import com.product.service.dto.productdetails.ProductDetailsDto;

public interface ProductService {

    ApiResponse createProduct(ProductDetailsDto productDetailsDto);

    ApiResponse updateProduct(ProductDetailsDto productDetailsDto);

    ApiResponse deleteProduct(Long productId);

    ApiResponse getProductById(Long id);

    ApiResponse getAllProducts();

    ApiResponse getListOfProducts();

}
