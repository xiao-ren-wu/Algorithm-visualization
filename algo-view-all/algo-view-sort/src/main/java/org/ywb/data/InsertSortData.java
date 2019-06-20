package org.ywb.data;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 11:00
 */

public class InsertSortData extends SortData {
    public InsertSortData(int n, int randomBound) {
        super(n, randomBound);
    }

    private int orderedIndex = -1;

    private int currentIndex = -1;

    public int getOrderedIndex() {
        return orderedIndex;
    }

    public void setOrderedIndex(int orderedIndex) {
        this.orderedIndex = orderedIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
