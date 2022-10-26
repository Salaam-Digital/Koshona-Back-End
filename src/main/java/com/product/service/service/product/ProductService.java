package com.product.service.service.product;

import com.product.service.dto.ApiResponseWithList;
import com.product.service.dto.ApiResponseWithObject;
import com.product.service.dto.productdetails.ProductDetailsDto;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ApiResponseWithObject createProduct(ProductDetailsDto productDetailsDto, MultipartFile[] files);

    ApiResponseWithObject updateProduct(ProductDetailsDto productDetailsDto);

    ApiResponseWithObject deleteProduct(Long productId);

    ApiResponseWithObject getProductById(Long id);

    ApiResponseWithList getAllProducts();

    ApiResponseWithList getListOfProducts();

}
