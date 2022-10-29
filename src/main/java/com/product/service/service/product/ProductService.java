package com.product.service.service.product;

import com.product.service.dto.ApiResponseWithList;
import com.product.service.dto.ApiResponseWithObject;
import com.product.service.dto.productdetails.ProductDetailsForUpdate;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ApiResponseWithObject createProduct(ProductDetailsForUpdate productDetailsDto);

    ApiResponseWithObject updateProduct(ProductDetailsForUpdate productDetailsDto);

    ApiResponseWithObject deleteProduct(Long productId);

    ApiResponseWithObject getProductById(Long id);

    ApiResponseWithList getAllProducts();

    ApiResponseWithList getListOfProducts();

}
