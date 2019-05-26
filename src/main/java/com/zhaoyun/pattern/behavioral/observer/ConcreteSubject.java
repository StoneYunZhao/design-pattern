package com.zhaoyun.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhaoYun on 2019-05-26
 **/
public class ConcreteSubject implements Subject {
    private List<Observer> os = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers() {

    }
}
