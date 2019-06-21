package org.ywb.maze.data;

import java.io.*;
import java.util.Scanner;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 16:12
 */


public class MazeData {

    /**
     * 路
     */
    public static final char ROAD = ' ';
    /**
     * 墙
     */
    public static final char WALL = '#';
    /**
     * 路和墙的宽度（单位：像素）
     */
    public static final int BLOCK_SIZE = 8;

    /**
     * 迷宫的尺寸，长N，宽M
     */
    private int N, M;
    /**
     * 存储迷宫的二维数组
     */
    private char[][] maze;

    /**
     * 迷宫入口的坐标
     */
    private int entranceX,entranceY;

    /**
     * 迷宫出口的坐标
     */
    private int exitX,exitY;

    /**
     * 标记迷宫在某个位置是否已经走过
     */
    public boolean[][] visited;

    /**
     * 用于存储路径
     */
    public boolean[][] path;

    /**
     * 用来记录最终结果
     */
    public boolean[][] result;

    public MazeData(String filename){

        if(filename == null) {
            throw new IllegalArgumentException("Filename can not be null!");
        }
        Scanner scanner = null;
        try{
            File file = new File(filename);
            if(!file.exists()) {
                throw new IllegalArgumentException("File " + filename + " doesn't exist");
            }
            FileInputStream fis = new FileInputStream(file);
            scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");

            // 读取第一行
            String nmline = scanner.nextLine();
            String[] nm = nmline.trim().split("\\s+");

            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);

            // 读取后续的N行
            maze = new char[N][M];
            visited = new boolean[N][M];
            path = new boolean[N][M];
            result = new boolean[N][M];

            for(int i = 0 ; i < N ; i ++){
                String line = scanner.nextLine();

                // 每行保证有M个字符
                if(line.length() != M) {
                    throw new IllegalArgumentException("Maze file " + filename + " is invalid");
                }
                for(int j = 0 ; j < M ; j ++) {
                    maze[i][j] = line.charAt(j);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
        entranceX = 1;
        entranceY = 0;
        exitX = N - 2;
        exitY = M - 1;
    }

    public int N(){ return N; }
    public int M(){ return M; }
    public char getMaze(int i, int j){
        if(!inArea(i,j)) {
            throw new IllegalArgumentException("i or j is out of index in getMaze!");
        }
        return maze[i][j];
    }

    public boolean inArea(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public void print(){
        System.out.println(N + " " + M);
        for(int i = 0 ; i < N ; i ++){
            for(int j = 0 ; j < M ; j ++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
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
}
