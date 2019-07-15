package com.wankang.demo.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-13 11:36
 **/
@Data
public class Apple {

    private Integer weight;

    private String shape;

    public Apple(Integer weight, String shape){
        this.weight = weight;
        this.shape = shape;
    }

}
