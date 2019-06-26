package org.ywb.createmaze.view;

import org.ywb.createmaze.controller.CreateMazeController;
import org.ywb.createmaze.data.MazeData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import static org.ywb.createmaze.data.MazeData.blockSide;
import static org.ywb.tools.AlgoVisHelper.*;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/26 9:40
 */

public class CreateMazeView {
    public static void main(String[] args) {

        int n = 101;
        int m = 101;
        AlgoFrame<MazeData> createMazeFrame = new AlgoFrame<>("create maze",n*blockSide,m*blockSide);
        createMazeFrame.paint((g2d, data) -> {
            int w = createMazeFrame.getCanvasWidth()/data.getN();
            int h = createMazeFrame.getCanvasHeight()/data.getM();
            for(int i = 0;i<data.getN();i++){
                for(int j = 0;j<data.getM();j++){
                    if(false){//data.inMist[i][j]
                        AlgoVisHelper.setColor(g2d,Black);
                    }
                    else if(data.maze[i][j] == MazeData.WALL){
                        AlgoVisHelper.setColor(g2d,LightBlue);
                    }else{
                        AlgoVisHelper.setColor(g2d,White);
                    }
                    AlgoVisHelper.fillRectangle(g2d,j*w,i*h,w,h);
                }
            }
        });

        CreateMazeController createMazeController = new CreateMazeController(createMazeFrame, n, m);
        createMazeController.setAlways(false);
    }
}
