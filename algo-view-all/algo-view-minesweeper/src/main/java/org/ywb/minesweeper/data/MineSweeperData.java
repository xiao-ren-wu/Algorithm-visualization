package org.ywb.minesweeper.data;

import java.util.Objects;
import java.util.Random;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/22 10:40
 */

public class MineSweeperData {
    private static final String BASE_PATH;
    public static final String BLOCK_IMAGE_URL;
    public static final String FLAG_IMAGE_URL;
    public static final String MINE_IMAGE_URL;

    public static final int BLOCK_SIZE = 32;
    /**
     * 雷区的长和宽
     */
    private int n, m;
    /**
     * 用来标记雷区中指定的坐标是否有雷，true==雷
     */
    private boolean[][] mines;

    /**
     * 用来标记棋盘中打开的区域
     */
    public boolean[][] open;

    /**
     * 用来标记用户是否标记指定位置
     */
    public boolean[][] flags;

    /**
     * 用来标记雷数
     */
    public int[][] numbers;

    static {
        BASE_PATH = Objects.requireNonNull(MineSweeperData.class.getClassLoader().getResource("")).getPath();
        BLOCK_IMAGE_URL = BASE_PATH + "block.png";
        FLAG_IMAGE_URL = BASE_PATH + "flag.png";
        MINE_IMAGE_URL = BASE_PATH + "mine.png";
    }

    /**
     * 通过图片的索引获取图片的路径
     *
     * @param index 图片索引
     * @return imagePath
     */
    public static String numberImageUrl(int index) {
        if (index < 0 || index > 8) {
            throw new IllegalArgumentException("No Such image");
        }
        return BASE_PATH + index + ".png";
    }

    public MineSweeperData(int n, int m, int mineNumber) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Mine sweeper size is invalid!");
        }
        if (mineNumber < 0 || mineNumber > n * m) {
            throw new IllegalArgumentException("mine number is larger than the size");
        }
        this.n = n;
        this.m = m;
        mines = new boolean[n][m];
        open = new boolean[n][m];
        flags = new boolean[n][m];
        numbers = new int[n][m];
        generateMines(mineNumber);
        calculateNumbers();
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public boolean isMine(int x, int y) {
        if (!inArea(x, y)) {
            throw new IllegalArgumentException("Out of index in isMine function");
        }
        return mines[x][y];
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private void generateMines(int mineNumber) {
        for (int i = 0; i < mineNumber; i++) {
            int x = i / m;
            int y = i % m;
            mines[x][y] = true;
        }
        Random random = new Random();
        for (int i = n * m - 1; i >= 0; i--) {
            int x1 = i / m;
            int y1 = i % m;

            int randomNumber = random.nextInt(i + 1);

            int x2 = randomNumber / m;
            int y2 = randomNumber % m;

            swap(x1, y1, x2, y2);
        }
    }

    private void swap(int x1, int y1, int x2, int y2) {
        boolean t = mines[x1][y1];
        mines[x1][y1] = mines[x2][y2];
        mines[x2][y2] = t;
    }

    /**
     * 计算每个格子的雷数量
     */
    private void calculateNumbers(){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mines[i][j]){
                    numbers[i][j] = -1;
                }
                numbers[i][j] = 0;
                for(int ii = i-1;ii<=i+1;ii++){
                    for(int jj = j-1;jj<=j+1;jj++){
                        if(inArea(ii,jj)&&mines[ii][jj]){
                            numbers[i][j]++;
                        }
                    }
                }
            }
        }
    }
}
