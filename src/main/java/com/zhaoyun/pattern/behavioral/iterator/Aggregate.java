package com.zhaoyun.pattern.behavioral.iterator;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public interface Aggregate<T> {
    Iterator<T> createIterator();
}
