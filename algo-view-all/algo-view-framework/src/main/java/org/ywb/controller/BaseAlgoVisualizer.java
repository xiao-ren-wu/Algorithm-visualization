package org.ywb.controller;

import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 11:08
 */

public abstract class BaseAlgoVisualizer<T> {

    private T t;

    /**
     * 视图层
     */
    private AlgoFrame frame;

    /**
     * 键盘事件
     */
    private KeyAdapter keyAdapter;

    /**
     * 鼠标事件
     */
    private MouseAdapter mouseAdapter;

    /**
     * 是否死循环执行更新数据的方法
     */
    private Boolean always = true;

    /**
     * 程序暂停时间（单位：毫秒），默认为50毫秒
     * 【注意】只有更新数据处于死循环执行状态才生效
     */
    private int pause = 50;

    /**
     * 核心方法，主要用于连接数据的初始化，数据的更新以及数据传递个视图层的工作
     */
    public BaseAlgoVisualizer(AlgoFrame frame){

        // 初始化视图
        EventQueue.invokeLater(() -> {
            this.frame = frame;
            t = this.initData();

            if(null!=keyAdapter) {
                frame.addKeyListener(keyAdapter);
            }
            if(null!=mouseAdapter) {
                frame.addMouseListener(mouseAdapter);
            }
            new Thread(()->{
                while (true){
                    //更新数据
                    this.update(t);
                    //将更新的数据传递给视图层
                    frame.render(t);
                    if(!always){
                        break;
                    }else{
                        AlgoVisHelper.pause(pause);
                    }
                }
            }).start();
        });
    }

    public void setKeyAdapter(KeyAdapter keyAdapter) {
        this.keyAdapter = keyAdapter;
    }

    public void setMouseAdapter(MouseAdapter mouseAdapter) {
        this.mouseAdapter = mouseAdapter;
    }

    /**
     * 更新数据
     * @param t 更新的数据
     */
    public abstract void update(T t);

    /**
     * 初始化数据
     * @return t 返回初始化的数据
     */
    public abstract T initData();

    /**
     * 是否开启更新数据方法死循环执行（默认死循环）
     * @param always true死循环
     */
    public void setAlways(Boolean always) {
        this.always = always;
    }

    /**
     * 设置程序暂停时间，只有在更新数据是死循环的情况下才生效
     * @param pause 单位：毫秒
     */
    public void setPause(int pause) {
        this.pause = pause;
    }

    public AlgoFrame getFrame() {
        return frame;
    }
}