package org.ywb.quicksort.twoway;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.QuickSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 13:59
 */

public class QuickSortTwoWayController extends BaseAlgoVisualizer<QuickSortData> {

    private int n;


    public QuickSortTwoWayController(AlgoFrame frame,int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(QuickSortData data) {
        setData(data,-1, -1, -1, -1, -1, -1);

        quickSort2Ways(data,0, data.size()-1);

        setData(data,-1, -1, -1, -1, -1, -1);
    }

    @Override
    public QuickSortData initData() {
        return new QuickSortData(n,getFrame().getCanvasHeight(), QuickSortData.Type.Identical);
    }

    private void setData(QuickSortData data, int l, int r, int fixedPivot, int curPivot, int curL, int curR){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1){
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curL = curL;
        data.curR = curR;
        getFrame().render(data);
        AlgoVisHelper.pause(50);
    }
    private void quickSort2Ways(QuickSortData data,int l, int r){

        if( l > r ) {
            return;
        }
        if( l == r ) {
            setData(data,l, r, l, -1, -1, -1);
            return;
        }

        setData(data,l, r, -1, -1, -1, -1);

        int p = partition(data,l, r);
        quickSort2Ways(data,l, p-1 );
        quickSort2Ways(data,p+1, r);
    }

    private int partition(QuickSortData data,int l, int r){
        int p = (int)(Math.random()*(r-l+1)) + l;
        setData(data,l, r, -1, p, -1, -1);
        data.swap(l, p);
        int v = data.get(l);
        setData(data,l, r, -1, l, -1, -1);
        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        setData(data,l, r, -1, l, i, j);
        while( true ){
            while( i <= r && data.get(i) < v ){
                i ++;
                setData(data,l, r, -1, l, i, j);
            }

            while( j >= l+1 && data.get(j) > v ){
                j --;
                setData(data,l, r, -1, l, i, j);
            }

            if( i > j ) {
                break;
            }
            data.swap( i, j );
            i ++;
            j --;
            setData(data,l, r, -1, l, i, j);
        }
        data.swap(l, j);
        setData(data,l, r, j, -1, -1, -1);
        return j;
    }
}
