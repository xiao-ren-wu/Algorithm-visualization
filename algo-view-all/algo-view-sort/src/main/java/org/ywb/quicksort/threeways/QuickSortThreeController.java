package org.ywb.quicksort.threeways;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.QuickSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 14:35
 */

public class QuickSortThreeController extends BaseAlgoVisualizer<QuickSortData> {

    private int n;

    public QuickSortThreeController(AlgoFrame frame,int n) {
        super(frame);
        this.n = n;
    }


    @Override
    public void update(QuickSortData data) {
        setData(data,-1, -1, -1, -1, -1, -1);

        quickSort3Ways(data,0, data.size()-1);

        setData(data,-1, -1, -1, -1, -1, -1);
    }

    @Override
    public QuickSortData initData() {
        return new QuickSortData(n,getFrame().getCanvasHeight());
    }
    private void quickSort3Ways(QuickSortData data,int l, int r){

        if( l > r ) {
            return;
        }

        if( l == r ) {
            setData(data,l, r, l, -1, -1, -1);
            return;
        }

        setData(data,l, r, -1, -1, -1, -1);

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int p = (int)(Math.random()*(r-l+1)) + l;
        setData(data,l, r, -1, p, -1, -1);

        data.swap(l, p);
        int v = data.get(l);
        setData(data,l, r, -1, l, -1, -1);

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        setData(data,l, r, -1, l, lt, gt);

        while( i < gt ){
            if( data.get(i) < v ){
                data.swap( i, lt+1);
                i ++;
                lt ++;
            }
            else if( data.get(i) > v ){
                data.swap( i, gt-1);
                gt --;
            }
            else { // arr[i] == v
                i++;
            }

            setData(data,l, r, -1, l, i, gt);
        }

        data.swap( l, lt );
        setData(data,l, r, lt, -1, -1, -1);

        quickSort3Ways(data,l, lt-1 );
        quickSort3Ways(data,gt, r);
    }

    private void setData(QuickSortData data,int l, int r, int fixedPivot, int curPivot, int curL, int curR){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPivots[fixedPivot] = true;
            int i = fixedPivot;
            while(i < data.size() && data.get(i) == data.get(fixedPivot)){
                data.fixedPivots[i] = true;
                i ++;
            }
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;

        getFrame().render(data);
        AlgoVisHelper.pause(50);
    }
}
