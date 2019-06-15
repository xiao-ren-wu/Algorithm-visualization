package org.ywb.view;

import org.ywb.domain.Circle;

import javax.swing.*;
import java.awt.*;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/14 16:00
 */

public class AlgoFrame extends JFrame {

    /**
     * 窗口宽度
     */
    private int canvasWidth;

    /**
     * 窗口高度
     */
    private int canvasHeight;

    /**
     * 构建一个指定大小，点击‘x’可以关闭的可视化窗口
     * @param title 标题
     * @param canvasWidth 窗口宽度
     * @param canvasHeight 窗口高度
     */
    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        //设置窗口内容面板大小
        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        // 通过panel控制窗口大小，不再使用frame控制大小
        /// this.setSize(canvasWidth,canvasHeight);
        //设置窗口内容面板
        this.setContentPane(canvas);
        //设置窗口和内容面板保持一致
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * 默认大小为1024*768
     * @param title 窗口标题
     */
    public AlgoFrame(String title){
        this(title,1024,768);
    }


    private class AlgoCanvas extends JPanel{

        AlgoCanvas(){
            //通过构造函数开启双缓存
            super(true);
        }

        /**
         *
         * @param g 绘制上下文环境
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;



            //具体绘制
            AlgoVisHelper.setStrokeWidth(g2d,1);
            AlgoVisHelper.addRenderingHints(g2d);
            AlgoVisHelper.setColor(g2d,Color.RED);
            if(circles!=null){
                for(Circle circle:circles){
                    if(!circle.isFilled){
                        AlgoVisHelper.strokeCircle(g2d,circle.x,circle.y,circle.getR());
                    }else {
                        AlgoVisHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());
                    }
                }
            }
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }



    }
    private Circle[] circles;

    public void render(Circle[] circles){
        this.circles=circles;
        //将所有的控件重新刷新，（清空原来所有的控件，重新调用paintComponent）
        this.repaint();
    }



    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }
}