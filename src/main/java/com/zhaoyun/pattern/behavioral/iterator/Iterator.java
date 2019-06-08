package com.zhaoyun.pattern.behavioral.iterator;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public interface Iterator<T> {
    boolean hasNext();

    T next();

    void remove();
}
