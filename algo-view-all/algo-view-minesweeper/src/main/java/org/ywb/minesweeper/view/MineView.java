package org.ywb.minesweeper.view;

import org.ywb.minesweeper.controller.MineController;
import org.ywb.minesweeper.data.MineSweeperData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import static org.ywb.minesweeper.data.MineSweeperData.*;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/22 13:51
 */

public class MineView {
    public static void main(String[] args) {
        AlgoFrame<MineSweeperData> mineSweeperFrame = new AlgoFrame<>("mine sweeper",20* BLOCK_SIZE,20* BLOCK_SIZE);
        mineSweeperFrame.paint((g2d, data) -> {
            int w = mineSweeperFrame.getCanvasWidth()/data.getN();
            int h = mineSweeperFrame.getCanvasHeight()/data.getM();

            for(int i = 0;i<data.getN();i++){
                for(int j = 0;j<data.getM();j++){
                    if(!data.open[i][j]){
                        if(data.flags[i][j]) {
                            AlgoVisHelper.putImage(g2d, j*w,i*h, FLAG_IMAGE_URL);
                        }else {
                            AlgoVisHelper.putImage(g2d, j*w,i*h, BLOCK_IMAGE_URL);
                        }
                    }else{
                        if(data.isMine(i,j)){
                            AlgoVisHelper.putImage(g2d,j*w,i*h,MINE_IMAGE_URL);
                        }else {
                            AlgoVisHelper.putImage(g2d,j*w,i*h,numberImageUrl(data.numbers[i][j]));
                        }
                    }
                }
            }
        });
        MineController mineController = new MineController(mineSweeperFrame, 20, 20, 50);
        mineController.setAlways(false);
    }
}
