package com.ballestax.miamiapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PresentationDto {

    private String name;
    private BigDecimal price;
    private boolean _default;
    private boolean _enabled;
    private Long product_id;
}
