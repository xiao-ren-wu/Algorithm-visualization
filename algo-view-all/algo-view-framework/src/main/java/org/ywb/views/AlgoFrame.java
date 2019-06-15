package org.ywb.views;

import org.ywb.consumer.Consumer;

import javax.swing.*;
import java.awt.*;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 10:45
 */

public class AlgoFrame<T> extends JFrame {
    /**
     * 窗口宽度
     */
    private int canvasWidth;

    /**
     * 窗口高度
     */
    private int canvasHeight;

    /**
     * 数据类型
     */
    private T t;


    /**
     * 画布
     */
    private AlgoCanvas canvas;


    /**
     * 将绘画的逻辑写到consumer的accept中即可
     * @param consumer 用于封装绘画逻辑使用
     */
    public void paint(Consumer<T> consumer){
        this.canvas.consumer = consumer;
    }

    /**
     * 构建一个指定大小，点击‘x’可以关闭的可视化窗口
     * @param title 标题
     * @param canvasWidth 窗口宽度
     * @param canvasHeight 窗口高度
     */
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }
    /**
     * 默认大小为1024*768
     * @param title 窗口标题
     */
    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    /**
     * 该方法会重新清空之前的布局，系统并再次调用paintComponent方法
     * @param t
     */
    public void render(T t){
        this.t = t;
        repaint();
    }

    private class AlgoCanvas extends JPanel{

        private Consumer<T> consumer;

        public AlgoCanvas(){
            // 双缓存
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            if(consumer!=null&&t!=null){
                consumer.accept(g2d, t);
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }

    }
}
