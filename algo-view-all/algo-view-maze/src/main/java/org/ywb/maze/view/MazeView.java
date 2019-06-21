package org.ywb.maze.view;

import org.ywb.maze.controller.MazeDataController;
import org.ywb.maze.data.MazeData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import static org.ywb.tools.AlgoVisHelper.*;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 18:37
 */

public class MazeView {
    public static void main(String[] args) {

        AlgoFrame<MazeData> mazeFrame = new AlgoFrame<>("maze",101*MazeData.BLOCK_SIZE,101*MazeData.BLOCK_SIZE);
        mazeFrame.paint((g2d, mazeData) -> {
            int w = mazeFrame.getCanvasWidth()/mazeData.N();
            int h = mazeFrame.getCanvasHeight()/mazeData.M();
            for(int i = 0;i<mazeData.N();i++){
                for(int j = 0;j<mazeData.M();j++){
                    if(mazeData.getMaze(i,j)==MazeData.ROAD){
                        AlgoVisHelper.setColor(g2d,White);
                    }else {
                        AlgoVisHelper.setColor(g2d,Green);
                    }
                    if(mazeData.path[i][j]){
                        setColor(g2d,Red);
                    }
                    if(mazeData.result[i][j]){
                        setColor(g2d,Yellow);
                    }
                    AlgoVisHelper.fillRectangle(g2d,j*w,i*h,w,h);
                }
            }
        });
        MazeDataController controller = new MazeDataController(mazeFrame);
        controller.setAlways(false);
    }
}
