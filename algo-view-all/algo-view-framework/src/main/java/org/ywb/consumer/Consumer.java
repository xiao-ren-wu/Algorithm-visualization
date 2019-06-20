package org.ywb.consumer;

import java.awt.*;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 11:19
 */
@FunctionalInterface
public interface Consumer<T> {
    /**
     * 封装绘画逻辑
     * @param g2d 画笔
     * @param t 数据
     */
    void accept(Graphics2D g2d, T t);
}
