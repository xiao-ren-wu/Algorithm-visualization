package org.ywb.quicksort.easy;

import org.ywb.data.QuickSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import static org.ywb.tools.AlgoVisHelper.*;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 13:54
 */

public class QuickSortView {
    public static void main(String[] args) throws InterruptedException {
        AlgoFrame<QuickSortData> quickSortFrame = new AlgoFrame<>("quicksort", 500, 300);
        quickSortFrame.paint((g2d, data) -> {
            int w = quickSortFrame.getCanvasWidth()/data.size();
            for(int i = 0;i<data.size();i++){
                if ( i >= data.l && i <= data.r) {
                    AlgoVisHelper.setColor(g2d, Green);
                }
                else {
                    AlgoVisHelper.setColor(g2d, Grey);
                }
                if( i == data.curPivot ){
                    AlgoVisHelper.setColor(g2d, Indigo);}
                if( i == data.curElement) {
                    AlgoVisHelper.setColor(g2d, LightBlue);
                }
                if( data.fixedPivots[i] ) {
                    AlgoVisHelper.setColor(g2d, Red);
                }

                AlgoVisHelper.fillRectangle(
                        g2d,
                        i*w,quickSortFrame.getCanvasHeight()-data.get(i),
                        w-1,data.get(i));
            }
        });
        QuickSortController quickSortController = new QuickSortController(quickSortFrame, 50);
        quickSortController.setAlways(false);
    }
}
