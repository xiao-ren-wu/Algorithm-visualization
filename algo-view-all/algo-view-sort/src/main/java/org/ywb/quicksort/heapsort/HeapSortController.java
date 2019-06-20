package org.ywb.quicksort.heapsort;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.HeapSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/20 15:18
 */

public class HeapSortController extends BaseAlgoVisualizer<HeapSortData> {

    private int n;

    public HeapSortController(AlgoFrame frame,int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(HeapSortData data) {
        setData(data,data.size());
        // 建堆
        for( int i = (data.size()-1-1)/2 ; i >= 0 ; i -- ){
            shiftDown(data,data.size(), i);
        }

        // 堆排序
        for( int i = data.size()-1; i > 0 ; i-- ){
            data.swap(0, i);
            shiftDown(data,i, 0);
            setData(data,i);
        }

        setData(data,0);
    }

    @Override
    public HeapSortData initData() {
        return new HeapSortData(n,getFrame().getCanvasHeight());
    }

    private void shiftDown(HeapSortData data,int n, int k){

        while( 2*k+1 < n ){
            int j = 2*k+1;
            if( j+1 < n && data.get(j+1) > data.get(j) ) {
                j += 1;
            }
            if( data.get(k) >= data.get(j) ) {
                break;
            }
            data.swap(k, j);
            setData(data,data.heapIndex);

            k = j;
        }
    }

    private void setData(HeapSortData data,int heapIndex){

        data.heapIndex = heapIndex;

        getFrame().render(data);
        AlgoVisHelper.pause(50);
    }
}
