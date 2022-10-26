package com.product.service.dto.image;

import com.product.service.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {

    private String uuid;
    private String fileName;
    private String fileType;
    private long size;

    public ImageResponse(Image image) {
        setUuid(image.getUuid());
        setFileName(image.getFileName());
        setFileType(image.getFileType());
        setSize(image.getSize());
    }
}
