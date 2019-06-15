package org.ywb.view;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/14 17:37
 */

public class AlgoVisHelper {

    private AlgoVisHelper() {}

    /**
     * 设置线条粗细
     * @param g2d 画笔
     * @param w 线条粗细，单位（像素）
     */
    public static void setStrokeWidth(Graphics2D g2d, int w) {
        g2d.setStroke(new BasicStroke(w,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }

    /**
     * 绘制一个空心圆
     * @param g2d 画笔
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 圆半径
     */
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.draw(circle);
    }

    /**
     * 绘制一个实心圆
     * @param g2d 画笔
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 圆半径
     */
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D.Double circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.fill(circle);
    }

    /**
     * 设置画笔颜色
     * @param g2d 画笔
     * @param c 颜色
     */
    public static void setColor(Graphics2D g2d,Color c){
        g2d.setColor(c);
    }

    /**
     * 抗锯齿
     * @param g2d 画笔
     */
    public static void addRenderingHints(Graphics2D g2d){
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(hints);
    }

    /**
     * 程序暂停指定时间
     * @param t 暂停时间（单位：毫秒）
     */
    public static void pause(int t){
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
