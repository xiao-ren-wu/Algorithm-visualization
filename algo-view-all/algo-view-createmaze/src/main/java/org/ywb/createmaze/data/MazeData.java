package org.ywb.createmaze.data;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/26 9:29
 */

public class MazeData {
    public static final char ROAD = ' ';
    public static final char WALL = '*';

    /**
     * 墙或者迷宫的宽度
     */
    public static final int blockSide = 8;

    /**
     * 迷宫的长和宽，n和m都要保证是奇数，才能生成迷宫
     */
    private int n,m;

    /**
     * 存储迷宫使用
     */
    public char[][] maze;

    /**
     * 判断该点是否遍历过
     */
    public boolean[][] visited;

    /**
     * 迷雾
     */
    public boolean[][] inMist;

    /**
     * 迷宫入口坐标
     */
    private int entranceX,entranceY;

    /**
     * 迷宫出口坐标
     */
    private int exitX,exitY;

    public MazeData(int n,int m){
        if(n%2==0||m%2==0){
            throw new IllegalArgumentException("Maze size must be odd");
        }
        this.m = m;
        this.n = n;
        maze = new char[n][m];
        visited = new boolean[n][m];
        inMist = new boolean[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i%2==1&&j%2==1){
                    maze[i][j] = ROAD;
                }else{
                    maze[i][j] = WALL;
                }
                inMist[i][j] = true;
            }
        }
        entranceX = 1;
        entranceY = 0;
        exitX = n-2;
        exitY = m-1;

        maze[entranceX][entranceY] = ROAD;
        maze[exitX][exitY] = ROAD;
    }

    /**
     * 判断坐标是否在迷宫范围内
     * @param x 横坐标
     * @param y 纵坐标
     * @return 在,返回true
     */
    public boolean inArea(int x,int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getEntranceX() {
        return entranceX;
    }

    public int getEntranceY() {
        return entranceY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public void openMist(int x, int y) {
        if(!inArea(x,y)){
            throw new IllegalArgumentException("this point is not in area");
        }
        for(int i = x-1;i<=x+1;i++){
            for(int j = y-1;j<=y+1;j++){
                if(inArea(i,j)){
                    inMist[i][j] = false;
                }
            }
        }
    }

}
