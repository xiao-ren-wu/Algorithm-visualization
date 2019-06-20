package org.ywb.select;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.SelectionSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 9:13
 */

public class SelectController extends BaseAlgoVisualizer<SelectionSortData> {

    private int n;

    public SelectController(AlgoFrame frame, int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(SelectionSortData ssd) {
        AlgoVisHelper.pause(5000);
        setData(ssd,0,-1,-1);
        //封装排序逻辑
        for(int i = 0;i<ssd.size();i++){
            int minIndex = i;
            setData(ssd,i,i,-1);
            for(int j = i+1;j<ssd.size();j++){
                setData(ssd,minIndex,i,j);
                if(ssd.get(minIndex)>ssd.get(j)) {
                    minIndex = j;
                }
            }
            ssd.setOrderedIndex(ssd.getOrderedIndex()+1);
            ssd.swap(i,minIndex);
            setData(ssd,-1,i+1,-1);
        }
        setData(ssd,-1,ssd.size(),-1);
    }

    @Override
    public SelectionSortData initData() {
        return new SelectionSortData(n, super.getFrame().getCanvasHeight());
    }

    private void setData(SelectionSortData ssd, int min, int ordered, int comparing){
        ssd.setOrderedIndex(ordered);
        ssd.setCurrentCompareIndex(comparing);
        ssd.setCurrentMinIndex(min);
        getFrame().render(ssd);
        AlgoVisHelper.pause(40);
    }



}
