package org.ywb.maze.data;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/21 11:08
 */

public class Position {
    private int x,y;
    /**
     * 存储节点的前驱
     */
    private Position prev;
    public Position(int x,int y,Position prev){
        this.x = x;
        this.y = y;
        this.prev = prev;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.prev = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getPrev() {
        return prev;
    }
}
