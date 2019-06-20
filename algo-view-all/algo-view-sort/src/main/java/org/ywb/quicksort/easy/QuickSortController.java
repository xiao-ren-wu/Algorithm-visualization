package org.ywb.quicksort.easy;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.QuickSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 13:42
 */

public class QuickSortController extends BaseAlgoVisualizer<QuickSortData> {

    private int n;

    public QuickSortController(AlgoFrame frame,int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(QuickSortData data) {
        setData(data,-1, -1, -1, -1, -1);
        quickSort(data,0, data.size()-1);
        setData(data,-1, -1, -1, -1, -1);
    }

    @Override
    public QuickSortData initData() {
        return new QuickSortData(n,super.getFrame().getCanvasHeight(), QuickSortData.Type.NearlyOrdered);
    }

    private void quickSort(QuickSortData data,int l, int r){

        if( l > r ) {
            return;
        }

        if( l == r ){
            setData(data,l, r, l, -1, -1);
            return;
        }

        setData(data,l, r, -1, -1, -1);

        int p = partition(data,l, r);
        quickSort(data,l, p-1 );
        quickSort(data,p+1, r);
    }

    private int partition(QuickSortData data,int l, int r){

        int v = data.get(l);
        setData(data,l, r, -1, l, -1);

        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for( int i = l + 1 ; i <= r ; i ++ ){
            setData(data,l, r, -1, l, i);
            if( data.get(i) < v ){
                j ++;
                data.swap(j, i);
                setData(data,l, r, -1, l, i);
            }
        }
        data.swap(l, j);
        setData(data,l, r, j, -1, -1);
        return j;
    }

    private void setData(QuickSortData data,int l, int r, int fixedPivot, int curPivot, int curElement){
        data.l = l;
        data.r = r;
        if(fixedPivot != -1) {
            data.fixedPivots[fixedPivot] = true;
        }
        data.curPivot = curPivot;
        data.curElement = curElement;

        getFrame().render(data);
        AlgoVisHelper.pause(50);
    }
}
