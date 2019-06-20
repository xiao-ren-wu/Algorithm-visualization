package org.ywb.merge;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.data.MergeSortData;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.util.Arrays;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 12:33
 */

public class MergeController extends BaseAlgoVisualizer<MergeSortData> {

    private int n;

    public MergeController(AlgoFrame frame, int n) {
        super(frame);
        this.n = n;
    }

    @Override
    public void update(MergeSortData msd) {
        AlgoVisHelper.pause(5000);
        setData(msd,-1, -1, -1);

        mergeSort(msd,0, msd.size()-1);

        setData(msd,0, msd.size()-1, msd.size()-1);
    }

    @Override
    public MergeSortData initData() {
        return new MergeSortData(n, getFrame().getCanvasHeight());
    }

    private void mergeSort(MergeSortData data, int l, int r) {

        if (l >= r) {
            return;
        }
        setData(data, l, r, -1);
        int mid = (l + r) / 2;
        mergeSort(data, l, mid);
        mergeSort(data, mid + 1, r);
        merge(data,l, mid, r);
    }

    private void merge(MergeSortData data,int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(data.numbers(), l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            // 如果左半部分元素已经全部处理完毕
            if (i > mid) {
                data.numbers()[k] = aux[j - l];
                j++;
            } else if (j > r) {
                // 如果右半部分元素已经全部处理完毕
                data.numbers()[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                // 左半部分所指元素 < 右半部分所指元素
                data.numbers()[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                data.numbers()[k] = aux[j - l];
                j++;
            }
            setData(data,l, r, k);
        }
    }

    private void setData(MergeSortData data, int l, int r, int mergeIndex) {
        data.setL(l);
        data.setR(r);
        data.setMergeIndex(mergeIndex);
        super.getFrame().render(data);
        AlgoVisHelper.pause(100);
    }

}
