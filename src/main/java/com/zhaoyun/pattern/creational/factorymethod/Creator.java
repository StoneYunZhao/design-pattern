package com.zhaoyun.pattern.creational.factorymethod;

/**
 * Created by ZhaoYun on 2019-05-19
 **/
public interface Creator {
    Product factoryMethod(String type);
}
