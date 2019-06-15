package org.ywb.mtkl;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 15:27
 */

public class Circle {
    private int x,y,r;


    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public boolean contain(Point p){
        return Math.pow(p.getX()-x,2)+Math.pow(p.getY()-y,2)<=r*r;
    }
}
