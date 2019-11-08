package com.wankang.demo.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 浅克隆
 *
 * @author wankang
 * @create 2019-07-13 11:36
 **/
@Data
@Slf4j
public class Apple implements Cloneable{

    private Integer weight;

    private String shape;

    public Apple(Integer weight, String shape){
        this.weight = weight;
        this.shape = shape;
    }


    @Override
    public Apple clone(){

        try {
            Object app = super.clone();
            return ((Apple) app);
        } catch (CloneNotSupportedException e) {
            log.error("克隆失败");
            return null;
        }

    }
}
