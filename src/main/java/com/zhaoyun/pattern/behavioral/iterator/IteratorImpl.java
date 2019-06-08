package com.zhaoyun.pattern.behavioral.iterator;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public final class IteratorImpl<T> implements Iterator<T> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
