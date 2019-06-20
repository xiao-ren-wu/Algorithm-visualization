package org.ywb.merge;

import org.ywb.data.MergeSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import static org.ywb.tools.AlgoVisHelper.*;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 12:49
 */

public class MergeSortView {
    public static void main(String[] args) {
        AlgoFrame<MergeSortData> mergeSortFrame = new AlgoFrame<>("mergerSort", 500, 300);
        mergeSortFrame.paint((g, msd) -> {
            int w = mergeSortFrame.getCanvasWidth()/msd.size();
            for(int i=0;i<msd.size();i++){
                if(i>=msd.getL()&&i<=msd.getR()){
                    setColor(g,Green);
                }else{
                    setColor(g,Grey);
                }
                if(i>=msd.getL()&&i<=msd.getMergeIndex()){
                    setColor(g,Red);
                }
                AlgoVisHelper.fillRectangle(
                        g,i*w,mergeSortFrame.getCanvasHeight()-msd.get(i),
                        w-1,msd.get(i));
            }
        });
        MergeController mergeController = new MergeController(mergeSortFrame, 50);
        mergeController.setAlways(false);
    }
}
