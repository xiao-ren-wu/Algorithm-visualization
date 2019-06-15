package org.ywb.domain;

import java.awt.*;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/14 22:00
 */

public class Circle {
    /**
     * 圆心坐标
     */
    public int x,y;

    /**
     * 圆的半径
     */
    private int r;

    /**
     * 圆在x方向上的速度和在y上的速度
     */
    public int vx,vy;

    public boolean isFilled = false;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public Circle(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }


    public void move(int minx,int miny,int maxx,int maxy){
        x+=vx;
        y+=vy;
        checkCollision(minx,miny,maxx,maxy);
    }
    private void checkCollision(int minx,int miny,int maxx,int maxy){
        if(x-r<minx){
            x=r;
            vx=-vx;
        }
        if(x+r>=maxx){
            x=maxx-r;
            vx=-vx;
        }
        if(y-r<miny){
            y=r;
            vy=-vy;
        }
        if(y+r>=maxy){
            y=maxy-r;
            vy=-vy;
        }
    }

    public boolean contain(Point point) {
        return (x-point.x)*(x-point.x)+(y-point.y)*(y-point.y)<=r*r;
    }
}

















