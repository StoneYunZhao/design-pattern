package com.zhaoyun.pattern.creation.factorymethod;

/**
 * Created by ZhaoYun on 2019-05-19
 **/
public class ConcreteCreator implements Creator {
    @Override
    public Product factoryMethod(String type) {
        return new ConcreteProduct();
    }
}
