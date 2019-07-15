package com.wankang.demo.dto;

import lombok.Data;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-07-14 23:19
 **/
@Data
public class Trader {
    private String name;
    private String city;

    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }

    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }

}
