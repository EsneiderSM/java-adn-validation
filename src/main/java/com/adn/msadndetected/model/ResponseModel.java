package com.adn.msadndetected.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseModel<T> {
    private int code;
    private T result;
}
