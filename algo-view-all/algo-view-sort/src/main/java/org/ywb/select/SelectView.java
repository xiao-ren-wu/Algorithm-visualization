package org.ywb.select;


import org.ywb.data.SelectionSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;


/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 9:30
 */

public class SelectView {
    public static void main(String[] args) {
        AlgoFrame<SelectionSortData> selectSort = new AlgoFrame<>("select sort", 500, 300);
        selectSort.paint((g, ssd) -> {
            int canvasWidth = selectSort.getCanvasWidth();
            int canvasHeight = selectSort.getCanvasHeight();
            //计算每个矩形的宽度
            int w = canvasWidth/ssd.size();
            for(int i = 0;i<ssd.size();i++){
                if(i<ssd.getOrderedIndex()){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Red);
                }else{
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Grey);
                }
                if(i==ssd.getCurrentCompareIndex()){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.LightBlue);
                }
                if(i==ssd.getCurrentMinIndex()){
                    AlgoVisHelper.setColor(g,AlgoVisHelper.Indigo);
                }
                AlgoVisHelper.fillRectangle(
                        g,i*w,canvasHeight-ssd.get(i),
                        w-1,
                        ssd.get(i)
                        );
            }
        });
        SelectController selectController = new SelectController(selectSort, 50);
        selectController.setAlways(false);

    }
}
