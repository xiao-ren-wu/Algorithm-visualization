package org.ywb.insert;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.InsertSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 11:01
 */

public class InsertController extends BaseAlgoVisualizer<InsertSortData> {

    private int n;

    public InsertController(AlgoFrame frame, int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(InsertSortData isd) {
        AlgoVisHelper.pause(5000);
        setData(isd,-1,-1);
        for(int i = 0;i<isd.size();i++){
            setData(isd,i,i);
            for(int j = i;j>0&&isd.get(j)<isd.get(j-1);j--){
                isd.swap(j,j-1);
                setData(isd,i+1,j-1);
            }
        }
        setData(isd,isd.size(),-1);
    }

    @Override
    public InsertSortData initData() {
        return new InsertSortData(n, super.getFrame().getCanvasHeight());
    }

    private void setData(InsertSortData ssd,int ordered, int comparing){
        ssd.setOrderedIndex(ordered);
        ssd.setCurrentIndex(comparing);
        getFrame().render(ssd);
        AlgoVisHelper.pause(50);
    }
}
