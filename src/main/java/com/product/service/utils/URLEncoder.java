package com.product.service.utils;

import com.product.service.entity.Image;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Component
public class URLEncoder {


    public String decoder(String givenURL) {
        try {
            givenURL = "http://localhost:8080/image/show/" + givenURL;
            String decodedURL = URLDecoder.decode(givenURL, StandardCharsets.UTF_8.name());
            return decodedURL;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public String encode(Image image) {
        return decoder(image.getFileName());
    }
}
