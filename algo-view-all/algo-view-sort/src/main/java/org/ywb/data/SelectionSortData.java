package org.ywb.data;

import java.util.Random;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 9:15
 */

public class SelectionSortData extends SortData{

    /**
     * [0...orderedIndex]已排好序
     */
    private int orderedIndex = -1;

    /**
     * 当前找到最小元素的索引
     */
    private int currentMinIndex = -1;

    /**
     * 当前比较的元素索引
     */
    private int currentCompareIndex = -1;

    public SelectionSortData(int n, int randomBound) {
        super(n, randomBound);
    }

    public int getOrderedIndex() {
        return orderedIndex;
    }

    public int getCurrentMinIndex() {
        return currentMinIndex;
    }

    public int getCurrentCompareIndex() {
        return currentCompareIndex;
    }

    public void setOrderedIndex(int orderedIndex) {
        this.orderedIndex = orderedIndex;
    }

    public void setCurrentMinIndex(int currentMinIndex) {
        this.currentMinIndex = currentMinIndex;
    }

    public void setCurrentCompareIndex(int currentCompareIndex) {
        this.currentCompareIndex = currentCompareIndex;
    }
}
