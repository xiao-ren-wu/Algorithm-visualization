package org.ywb.insert;

import org.ywb.data.InsertSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 11:03
 */

public class SelectView {
    public static void main(String[] args) {
        AlgoFrame<InsertSortData> insertSort = new AlgoFrame<>("insertSort", 500, 300);
        insertSort.paint((g, isd) -> {
            int w = insertSort.getCanvasWidth()/isd.size();
            for(int i = 0;i<isd.size();i++){
                if(i<isd.getOrderedIndex()){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Red);
                }else{
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Grey);
                }
                if(i==isd.getCurrentIndex()){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.LightBlue);
                }
                AlgoVisHelper.fillRectangle(
                        g,i*w,insertSort.getCanvasHeight()-isd.get(i),
                        w-1,isd.get(i));
            }
        });
        InsertController insertController = new InsertController(insertSort, 50);
        insertController.setAlways(false);
    }
}
