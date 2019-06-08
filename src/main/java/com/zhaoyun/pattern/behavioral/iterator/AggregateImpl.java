package com.zhaoyun.pattern.behavioral.iterator;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public final class AggregateImpl<T> implements Aggregate<T> {
    @Override
    public IteratorImpl<T> createIterator() {
        return new IteratorImpl<>();
    }
}
