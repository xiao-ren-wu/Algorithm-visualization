package org.ywb.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import java.lang.InterruptedException;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 10:45
 */
public class AlgoVisHelper {

    private AlgoVisHelper(){}

    public static final Color Red = new Color(0xF44336);
    public static final Color Pink = new Color(0xE91E63);
    public static final Color Purple = new Color(0x9C27B0);
    public static final Color DeepPurple = new Color(0x673AB7);
    public static final Color Indigo = new Color(0x3F51B5);
    public static final Color Blue = new Color(0x2196F3);
    public static final Color LightBlue = new Color(0x03A9F4);
    public static final Color Cyan = new Color(0x00BCD4);
    public static final Color Teal = new Color(0x009688);
    public static final Color Green = new Color(0x4CAF50);
    public static final Color LightGreen = new Color(0x8BC34A);
    public static final Color Lime = new Color(0xCDDC39);
    public static final Color Yellow = new Color(0xFFEB3B);
    public static final Color Amber = new Color(0xFFC107);
    public static final Color Orange = new Color(0xFF9800);
    public static final Color DeepOrange = new Color(0xFF5722);
    public static final Color Brown = new Color(0x795548);
    public static final Color Grey = new Color(0x9E9E9E);
    public static final Color BlueGrey = new Color(0x607D8B);
    public static final Color Black = new Color(0x000000);
    public static final Color White = new Color(0xFFFFFF);

    /**
     * 绘制一个空心圆
     * @param g 画笔
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 圆半径
     */
    public static void strokeCircle(Graphics2D g, int x, int y, int r){

        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.draw(circle);
    }

    /**
     * 绘制一个实心圆
     * @param g 画笔
     * @param x 圆心横坐标
     * @param y 圆心纵坐标
     * @param r 圆半径
     */
    public static void fillCircle(Graphics2D g, int x, int y, int r){

        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g.fill(circle);
    }

    public static void strokeRectangle(Graphics2D g, int x, int y, int w, int h){

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.draw(rectangle);
    }

    public static void fillRectangle(Graphics2D g, int x, int y, int w, int h){

        Rectangle2D rectangle = new Rectangle2D.Double(x, y, w, h);
        g.fill(rectangle);
    }

    /**
     * 设置画笔颜色
     * @param g 画笔
     * @param color 颜色
     */
    public static void setColor(Graphics2D g, Color color){
        g.setColor(color);
    }

    /**
     * 设置线条粗细
     * @param g 画笔
     * @param w 线条粗细，单位（像素）
     */
    public static void setStrokeWidth(Graphics2D g, int w){
        int strokeWidth = w;
        g.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * 程序暂停指定时间
     * @param t 暂停时间（单位：毫秒）
     */
    public static void pause(int t) {
        try {
            Thread.sleep(t);
        }
        catch (InterruptedException e) {
            System.out.println("Error sleeping");
        }
    }

    /**
     * 帖图片
     * @param g 画笔
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param imageURL 图片地址
     */
    public static void putImage(Graphics2D g, int x, int y, String imageURL){

        ImageIcon icon = new ImageIcon(imageURL);
        Image image = icon.getImage();

        g.drawImage(image, x, y, null);
    }

    /**
     * 抗锯齿
     * @param g2d 画笔
     */
    public static void addRenderingHints(Graphics2D g2d){
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(hints);
    }

    public static void drawText(Graphics2D g, String text, int centerx, int centery){

        if(text == null) {
            throw new IllegalArgumentException("Text is null in drawText function!");
        }
        FontMetrics metrics = g.getFontMetrics();
        int w = metrics.stringWidth(text);
        int h = metrics.getDescent();
        g.drawString(text, centerx - w/2, centery + h);
    }

}
