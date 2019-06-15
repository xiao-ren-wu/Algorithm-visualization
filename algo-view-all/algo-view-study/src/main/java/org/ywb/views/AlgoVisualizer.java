package org.ywb.views;

import org.ywb.domain.Circle;
import org.ywb.view.AlgoFrame;
import org.ywb.view.AlgoVisHelper;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/14 22:35
 */

public class AlgoVisualizer {

    private Circle[] circles;

    private AlgoFrame algoFrame;

    private int sceneWidth;

    private int sceneHeight;

    private final char space = ' ';

    /**
     * 动画是否执行中
     */
    private boolean isAnimated = true;


    /**
     * 画圆动画构造函数
     *
     * @param sceneWidth  屏幕宽度
     * @param sceneHeight 屏幕高度
     * @param n           圆的数量
     * @param r           圆半径（单位：像素）
     */
    public AlgoVisualizer(int sceneWidth, int sceneHeight, int n, int r) {
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        circles = new Circle[n];
        for (int i = 0; i < n; i++) {
            circles[i] = new Circle(r);
            circles[i].x = (int) (Math.random() * (sceneWidth - 2 * r)) + r;
            circles[i].y = (int) (Math.random() * (sceneHeight - 2 * r)) + r;
            circles[i].vx = ((int) (Math.random() * 11)) - 5;
            circles[i].vy = ((int) (Math.random() * 11)) - 5;
        }
    }

    /**
     * 运行圆动画
     */
    public void run() {
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            //添加键盘监听
            algoFrame.addKeyListener(new AlgoKeyListener());
            //添加鼠标监听
            algoFrame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                while (true) {
                    //绘制数据
                    algoFrame.render(circles);
                    AlgoVisHelper.pause(20);
                    //更新数据
                    if (isAnimated) {
                        for (Circle circle : circles) {
                            circle.move(0, 0, sceneWidth, sceneHeight);
                        }
                    }
                }
            }).start();
        });
    }

    /**
     * 键盘事件
     */
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if (space == e.getKeyChar()) {
                isAnimated = !isAnimated;
            }
        }
    }

    private class AlgoMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,-(algoFrame.getBounds().height-algoFrame.getCanvasHeight()));
            Point point = e.getPoint();
            for(Circle circle:circles){
                if(circle.contain(e.getPoint())){
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }
}
