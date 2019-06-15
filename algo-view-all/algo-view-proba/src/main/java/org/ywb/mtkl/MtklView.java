package org.ywb.mtkl;


import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.awt.*;
import java.util.ArrayList;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 15:33
 */

public class MtklView {
    public static void main(String[] args) {
        AlgoFrame<Contain> pi = new AlgoFrame<>("Pi", 500, 500);
        pi.paint((g, contain) -> {
            AlgoVisHelper.setStrokeWidth(g,3);
            AlgoVisHelper.setColor(g,AlgoVisHelper.Blue);
            AlgoVisHelper.strokeCircle(g,contain.getCircle().getX(),contain.getCircle().getY(),contain.getCircle().getR());

            ArrayList<Point> pointList = contain.getPointList();
            for(int i = 0 ; i < pointList.size() ; i ++){
                Point p = pointList.get(i);
                if(contain.getCircle().contain(p)){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Red);
                }else{
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Green);
                }
                AlgoVisHelper.fillCircle(g,p.x,p.y,3);
            }
        });
        ComputePiController piController = new ComputePiController(pi);
        piController.setN(10000);
        piController.setAlways(false);

    }
}
