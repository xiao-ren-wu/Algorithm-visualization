package org.ywb.mtkl;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 15:26
 */

public class ComputePiController extends BaseAlgoVisualizer<Contain> {

    private int N;

    public void setN(int n) {
        N = n;
    }

    public ComputePiController(AlgoFrame frame) {
        super(frame);
    }

    @Override
    public void update(Contain contain) {

        ArrayList<Point> points = new ArrayList<>();
        contain.setPointList(points);

        int circleArea = 0;


        for(int i=0;i<N;i++){
            int x = (int) (Math.random() * getFrame().getCanvasWidth());
            int y = (int) (Math.random() * getFrame().getCanvasWidth());
            Point point = new Point(x, y);
            contain.getPointList().add(point);
            AlgoVisHelper.pause(20);
            getFrame().render(contain);
            int squareArea = points.size();
            if(contain.getCircle().contain(point)){
                circleArea++;
            }
            double pi = 4*(double)circleArea/squareArea;
            System.out.println(pi);
        }
    }

    @Override
    public Contain initData() {
        Contain contain = new Contain();
        int width = super.getFrame().getCanvasWidth();
        Circle circle = new Circle(width / 2, width / 2, width / 2);
        contain.setCircle(circle);
        return contain;
    }
}
