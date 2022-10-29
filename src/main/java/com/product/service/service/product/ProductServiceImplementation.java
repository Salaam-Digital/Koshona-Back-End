package com.product.service.service.product;

import com.product.service.dto.ApiResponseWithList;
import com.product.service.dto.ApiResponseWithObject;
import com.product.service.dto.listProduct.ListOfProductsDto;
import com.product.service.dto.productdetails.ProductDetailsForUpdate;
import com.product.service.entity.Image;
import com.product.service.entity.Product;
import com.product.service.exception.ProductException;
import com.product.service.repository.ImageRepository;
import com.product.service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {


    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;


    @Override
    public ApiResponseWithObject createProduct(ProductDetailsForUpdate detailsDto) {
        Product product = new Product();
        Product productEntity = productRepository.save(saveOrUpdateProduct(detailsDto, product));
        Optional<List<Image>> images = imageRepository.findByUuid(detailsDto.getUniqueId());
        if (images.isPresent()) {
            for (Image image : images.get()) {
                image.setProduct(productEntity);
                imageRepository.save(image);
            }
        }
        return apiResponse(productEntity);
    }

    @Override
    public ApiResponseWithObject updateProduct(ProductDetailsForUpdate productDetailsDto) {
        Product product = findProductById(productDetailsDto.getId());
        Product productEntity = productRepository.save(saveOrUpdateProduct(productDetailsDto, product));
        return apiResponse(productEntity);
    }

    @Override
    public ApiResponseWithObject deleteProduct(Long productId) {
        findProductById(productId);
        productRepository.deleteById(productId);
        return apiResponse((Product) null);
    }

    @Override
    public ApiResponseWithObject getProductById(Long id) {
        Product productEntity = findProductById(id);
        return apiResponse(productEntity);
    }

    @Override
    public ApiResponseWithList getAllProducts() {
        return apiResponse(Collections.singletonList(productRepository.findAll()));
    }

    @Override
    public ApiResponseWithList getListOfProducts() {
        List<Product> products = productRepository.findAll();
        List<ListOfProductsDto> list = new ArrayList<>();
        for (Product product : products) {
            ListOfProductsDto productsDto = new ListOfProductsDto();
            productsDto.setUserId(product.getUserId());
            productsDto.setAddress(product.getAddress());
            productsDto.setCurrency(product.getCurrency());
            productsDto.setEnableChat(product.getEnableChat());
            productsDto.setFloorCount(product.getFloorCount());
            productsDto.setLan(product.getLan());
            productsDto.setLat(product.getLat());
            productsDto.setFloorNumber(product.getFloorNumber());
            productsDto.setPrice(product.getPrice());
            productsDto.setIsFavorite(product.getIsFavorite());
            productsDto.setPhoneNumber(product.getPhoneNumber());
            productsDto.setTotalArea(product.getTotalArea());
            productsDto.setRoomCount(product.getRoomCount());
            list.add(productsDto);
        }

        return apiResponse(Collections.singletonList(list));
    }

    private Product saveOrUpdateProduct(ProductDetailsForUpdate detailsDto, Product product) {
        product.setUserId(detailsDto.getUserId());
        product.setPrice(detailsDto.getPrice());
        product.setRoomCount(detailsDto.getRoomCount());
        product.setTotalArea(detailsDto.getTotalArea());
        product.setFloorNumber(detailsDto.getFloorNumber());
        product.setAddress(detailsDto.getAddress());
        product.setFloorCount(detailsDto.getFloorCount());
        product.setIsFavorite(detailsDto.getIsFavorite());
        product.setLan(detailsDto.getLan());
        product.setLat(detailsDto.getLat());
        product.setPhoneNumber(detailsDto.getPhoneNumber());
        product.setEnablePhone(detailsDto.getEnablePhone());
        product.setEnableChat(detailsDto.getEnableChat());
        product.setAreaLength(detailsDto.getLivingArea());
        product.setTotalArea(detailsDto.getTotalArea());
        product.setWithFurniture(detailsDto.getWithFurniture());
        product.setBalcony(detailsDto.getBalcony());
        product.setBuiltYear(detailsDto.getBuiltYear());
        product.setElevator(detailsDto.getElevator());
        product.setParking(detailsDto.getParking());
        product.setDescription(detailsDto.getDescription());
        product.setViewCount(detailsDto.getViewCount());
        product.setUniqueId(detailsDto.getUniqueId());

        // TODO ENUMS
        product.setCurrency(detailsDto.getCurrency());
        product.setType(detailsDto.getType());
        product.setMaterial(detailsDto.getMaterial());

        return product;
    }

    private Product findProductById(Long productId) {
        Optional<Product> productEntity = productRepository.findById(productId);
        if (productEntity.isPresent()) {
            return productEntity.get();
        }

        throw new ProductException("Product with such Id not found");
    }

    private ApiResponseWithObject apiResponse(Product product) {
        ApiResponseWithObject apiResponse = new ApiResponseWithObject();
        apiResponse.setStatus(true);
        apiResponse.setMessage("SUCCESS");
        apiResponse.setData(product);
        return apiResponse;
    }

    private ApiResponseWithList apiResponse(List<Object> products) {
        ApiResponseWithList apiResponse = new ApiResponseWithList();
        apiResponse.setStatus(true);
        apiResponse.setMessage("SUCCESS");
        apiResponse.setData(products);
        return apiResponse;
    }
}