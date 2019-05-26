package com.zhaoyun.pattern.behavioral.observer;

/**
 * Created by ZhaoYun on 2019-05-26
 **/
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
