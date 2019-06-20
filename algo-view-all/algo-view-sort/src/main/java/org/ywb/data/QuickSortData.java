package org.ywb.data;

import java.util.Arrays;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 13:30
 */

public class QuickSortData extends SortData {

    public enum Type{
        /**
         * 默认排序
         */
        Default,
        /**
         * 生成有序的测试数据
         */
        NearlyOrdered,

        /**
         * 生成一致的测试数据
         */
        Identical
    }

    public int l,r;

    public boolean[] fixedPivots;

    public int curPivot;

    public int curElement;



    /**
     * 双路排序使用
     */
    public int curL,curR;

    public QuickSortData(int n, int randomBound) {
        this(n,randomBound,Type.Default);
    }

    public QuickSortData(int n,int randomBound,Type dataType){
        super(n,randomBound);
        fixedPivots = new boolean[n];

        if(dataType==Type.NearlyOrdered){
            Arrays.sort(numbers);
        }else if(dataType==Type.Identical){
            numbers = Arrays.stream(numbers).map(a->50).toArray();
        }
    }
}
