package com.zhaoyun.pattern.behavioral.chainofresponsibility;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public abstract class Hanlder {
    protected Hanlder next;

    public void setNext(Hanlder next) {
        this.next = next;
    }

    abstract protected void handle();
}
