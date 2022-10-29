package com.product.service.service.image;

import com.product.service.dto.ApiResponseWithList;
import com.product.service.dto.ApiResponseWithObject;
import com.product.service.entity.Image;
import com.product.service.entity.Product;
import com.product.service.repository.ImageRepository;
import com.product.service.repository.ProductRepository;
import com.product.service.utils.FileNameHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageServiceImplementation implements ImageService {

    private final ImageRepository imageRepository;
    private final FileNameHelper fileHelper;
    private final ProductRepository productRepository;

    @Override
    public ApiResponseWithObject uploadSingleFile(MultipartFile file, String uniqueId) {
        Optional<Product> product = productRepository.findByUuid(uniqueId);
        Image image;

        if (product.isPresent()) {
            image = Image.buildImage(file, fileHelper, product.get(), uniqueId);
        } else {
            image = Image.buildImage(file, fileHelper, null, uniqueId);
        }

        return new ApiResponseWithObject(true, "SUCCESS", save(image));
    }

    @Override
    public ApiResponseWithList uploadMultipleFiles(MultipartFile[] files, String uniqueId) {
        Optional<Product> product = productRepository.findByUuid(uniqueId);
        if (product.isPresent()) {
            return new ApiResponseWithList(true, "SUCCESS", Collections.singletonList(images(files, product.get(), uniqueId)));
        }

        return new ApiResponseWithList(true, "SUCCESS", Collections.singletonList(images(files, null, uniqueId)));
    }


    @Override
    public Image save(Image image) throws NullPointerException {
        if (image == null)
            throw new NullPointerException("Image Data NULL");
        return imageRepository.save(image);
    }

    @Override
    public Image findByFileName(String fileName) {
        return this.imageRepository.findByFileName(fileName);
    }


    @Override
    public List<Image> images(MultipartFile[] files, Product product, String uniqueId) {
        List<Image> images = Arrays.asList(files).stream().map(file -> save(Image.buildImage(file, fileHelper, product, uniqueId))).collect(Collectors.toList());
        return images;
    }

}
