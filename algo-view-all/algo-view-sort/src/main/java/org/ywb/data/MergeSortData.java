package org.ywb.data;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 12:44
 */

public class MergeSortData extends SortData{

    /**
     * 递归区间的左右边界
     */
    private int l,r;

    private int mergeIndex;

    public MergeSortData(int n, int randomBound) {
        super(n, randomBound);
    }

    public int getL() {
        return l;
    }

    public int[] numbers(){
        return numbers;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getMergeIndex() {
        return mergeIndex;
    }

    public void setMergeIndex(int mergeIndex) {
        this.mergeIndex = mergeIndex;
    }
}
