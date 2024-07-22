package com.eidiko.product_service.responseStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure <T> {

    private int status;
    private String message;
    private T data;

}