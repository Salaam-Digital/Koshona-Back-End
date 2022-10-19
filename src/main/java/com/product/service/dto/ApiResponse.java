package com.product.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiResponse {

    public boolean status;
    public String message;
    public Object data;
    public List<Object> listOfData;

}
