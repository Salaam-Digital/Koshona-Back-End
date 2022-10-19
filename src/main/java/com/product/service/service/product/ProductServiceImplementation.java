package com.product.service.service.product;

import com.product.service.dto.ApiResponse;
import com.product.service.dto.listProduct.ListOfProductsDto;
import com.product.service.dto.productdetails.ProductDetailsDto;
import com.product.service.entity.Product;
import com.product.service.exception.ProductException;
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


    @Override
    public ApiResponse createProduct(ProductDetailsDto detailsDto) {
        Product product = new Product();
        Product productEntity = productRepository.save(saveOrUpdateProduct(detailsDto, product));
        return apiResponse(productEntity, null);
    }

    @Override
    public ApiResponse updateProduct(ProductDetailsDto productDetailsDto) {
        Product productEntity = findProductById(productDetailsDto.getId());
        return apiResponse(productEntity, null);
    }

    @Override
    public ApiResponse deleteProduct(Long productId) {
        findProductById(productId);
        productRepository.deleteById(productId);
        return apiResponse(null, null);
    }

    @Override
    public ApiResponse getProductById(Long id) {
        Product productEntity = findProductById(id);
        return apiResponse(productEntity, null);
    }

    @Override
    public ApiResponse getAllProducts() {
        return apiResponse(null, Collections.singletonList(productRepository.findAll()));
    }

    @Override
    public ApiResponse getListOfProducts() {
        List<Product> products = productRepository.findAll();
        List<ListOfProductsDto> list = new ArrayList<>();
        for (Product product : products) {
            ListOfProductsDto productsDto = new ListOfProductsDto();
            productsDto.setId(product.getId());
            productsDto.setUserId(product.getUserId());
            productsDto.setAddress(product.getAddress());
            productsDto.setCurrency(product.getCurrency());
            productsDto.setEnableChat(product.getEnableChat());
            productsDto.setFloorCount(product.getFloorCount());
            productsDto.setLan(product.getLan());
            productsDto.setLat(product.getLat());
            productsDto.setFloorNumber(product.getFloorNumber());
            productsDto.setImages(product.getImageList());
            productsDto.setPrice(product.getPrice());
            productsDto.setIsFavorite(product.getIsFavorite());
            productsDto.setPhoneNumber(product.getPhoneNumber());
            productsDto.setTotalArea(product.getTotalArea());
            productsDto.setRoomCount(product.getRoomCount());
            list.add(productsDto);
        }

        return apiResponse(null, Collections.singletonList(list));
    }

    private Product saveOrUpdateProduct(ProductDetailsDto detailsDto, Product product) {
        product.setId(detailsDto.getId());
        product.setUserId(detailsDto.getUserId());
        product.setPrice(detailsDto.getPrice());
        product.setRoomCount(detailsDto.getRoom_count());
        product.setTotalArea(detailsDto.getTotal_area());
        product.setFloorNumber(detailsDto.getFloor_number());
        product.setAddress(detailsDto.getAddress());
        product.setFloorCount(detailsDto.getFloor_count());
        product.setIsFavorite(detailsDto.getIsFavorite());
        product.setLan(detailsDto.getLan());
        product.setLat(detailsDto.getLat());
        product.setPhoneNumber(detailsDto.getPhone_number());
        product.setEnablePhone(detailsDto.getEnablePhone());
        product.setEnableChat(detailsDto.getEnable_chat());
        product.setAreaLength(detailsDto.getLiving_area());
        product.setTotalArea(detailsDto.getTotal_area());
        product.setWithFurniture(detailsDto.getWithFurniture());
        product.setBalcony(detailsDto.getBalcony());
        product.setBuiltYear(detailsDto.getBuilt_year());
        product.setElevator(detailsDto.getElevator());
        product.setParking(detailsDto.getParking());
        product.setDescription(detailsDto.getDescription());
        product.setViewCount(detailsDto.getView_count());
        product.setImageList(detailsDto.getImages());

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

    private ApiResponse apiResponse(Product product, List<Object> products) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(true);
        apiResponse.setMessage("SUCCESS");
        apiResponse.setData(product);
        apiResponse.setListOfData(products);
        return apiResponse;
    }
}
