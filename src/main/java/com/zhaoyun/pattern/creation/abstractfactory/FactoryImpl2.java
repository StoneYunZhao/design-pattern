package com.zhaoyun.pattern.creation.abstractfactory;

/**
 * Created by ZhaoYun on 2019-05-19
 **/
public class FactoryImpl2 implements Factory {
    @Override
    public ProductA createA() {
        return new ProductAImpl2();
    }

    @Override
    public ProductB createB() {
        return new ProductBImpl2();
    }
}
