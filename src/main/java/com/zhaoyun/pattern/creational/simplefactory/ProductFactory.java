package com.zhaoyun.pattern.creational.simplefactory;

/**
 * Created by ZhaoYun on 2019-05-19
 **/
public class ProductFactory {
    public static Product createProduct(String type) {
        if ("A".equalsIgnoreCase(type)) {
            return new ConcreteProductA();
        } else if ("B".equalsIgnoreCase(type)) {
            return new ConcreteProductB();
        }
        return null;
    }
}
