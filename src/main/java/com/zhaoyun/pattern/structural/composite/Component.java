package com.zhaoyun.pattern.structural.composite;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public interface Component {
    default void operation() {
        throw new UnsupportedOperationException();
    }

    default void add(Component component) {
        throw new UnsupportedOperationException();
    }

    default void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    default Component get(int index) {
        throw new UnsupportedOperationException();
    }
}
