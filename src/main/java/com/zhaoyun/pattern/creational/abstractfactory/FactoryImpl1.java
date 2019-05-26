package com.zhaoyun.pattern.creational.abstractfactory;

/**
 * Created by ZhaoYun on 2019-05-19
 **/
public class FactoryImpl1 implements Factory {
    @Override
    public ProductA createA() {
        return new ProductAImpl1();
    }

    @Override
    public ProductB createB() {
        return new ProductBImpl1();
    }
}
