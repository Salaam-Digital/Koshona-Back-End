package com.product.service.controller;

import com.product.service.dto.ApiResponse;
import com.product.service.dto.productdetails.ProductDetailsDto;
import com.product.service.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/{id}")
    public ApiResponse findProductById(@PathVariable("id") Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/all")
    public ApiResponse getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/listProduct")
    public ApiResponse getAllListProducts() {
        return productService.getListOfProducts();
    }

    @PostMapping("/creation")
    public ApiResponse createProduct(@RequestBody ProductDetailsDto productDetailsDto) {
        return productService.createProduct(productDetailsDto);
    }

    @PutMapping("/edition")
    public ApiResponse updateProduct(@RequestBody ProductDetailsDto productDetailsDto) {
        return productService.updateProduct(productDetailsDto);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(@PathVariable("id") Long productId) {
        return productService.deleteProduct(productId);
    }
}
