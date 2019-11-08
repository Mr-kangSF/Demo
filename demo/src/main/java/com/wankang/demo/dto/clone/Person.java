package com.wankang.demo.dto.clone;

import lombok.Data;

import java.io.*;

/**
 * ${DESCRIPTION}
 *
 * @author wankang
 * @create 2019-11-08 15:54
 **/
@Data
public class Person implements Serializable {

    private Integer age;

    private String sex;

    private Car car;

    public Person deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(bao);

        oos.writeObject(this);

        //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(bis);

        return (Person) ois.readObject();
    }


}
