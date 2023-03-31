package com.ballestax.miamiapi.dto;

import com.ballestax.miamiapi.model.Presentation;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String category;
    private String location;
    private String image;
    private BigDecimal price;
    private boolean enabled;
    private List<Presentation> presentations;

}
