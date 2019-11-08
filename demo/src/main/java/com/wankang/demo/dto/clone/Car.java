package com.wankang.demo.dto.clone;

import lombok.Data;

import java.io.Serializable;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-11-08 15:54
 **/
@Data
public class Car implements Serializable {

    private String color;

    private Integer weight;
}
