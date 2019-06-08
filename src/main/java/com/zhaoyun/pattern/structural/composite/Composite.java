package com.zhaoyun.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhaoYun on 2019-06-08
 **/
public final class Composite implements Component {
    private final List<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component get(int index) {
        return children.get(index);
    }

}
