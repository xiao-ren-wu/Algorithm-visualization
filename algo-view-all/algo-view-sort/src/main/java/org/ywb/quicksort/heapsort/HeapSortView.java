package org.ywb.quicksort.heapsort;

import org.ywb.consumer.Consumer;
import org.ywb.data.HeapSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.awt.*;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 15:26
 */

public class HeapSortView {
    public static void main(String[] args) {
        AlgoFrame<HeapSortData> heapSortAlgoFrame = new AlgoFrame<>("headSort", 500, 300);
        heapSortAlgoFrame.paint((g2d, data) -> {
            int w = heapSortAlgoFrame.getCanvasWidth()/data.size();
            for(int i = 0 ; i < data.size() ; i ++ ) {
                if ( i >= data.heapIndex) {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Red);
                }
                else {
                    AlgoVisHelper.setColor(g2d, AlgoVisHelper.Grey);
                }
                AlgoVisHelper.fillRectangle(g2d, i * w, heapSortAlgoFrame.getCanvasHeight() - data.get(i), w - 1, data.get(i));
            }
        });
        HeapSortController heapSortController = new HeapSortController(heapSortAlgoFrame, 50);
        heapSortController.setAlways(false);
    }
}
