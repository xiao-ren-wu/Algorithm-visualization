package org.ywb.data;

import java.util.Random;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/16 10:57
 */

public class SortData {

    protected int[] numbers;

    public SortData(int n, int randomBound) {
        this.numbers = new int[n];
        Random random = new Random();
        for(int i = 0;i<n;i++){
            //生成的随机数不能是0,0无法进行可视化
            do{
                numbers[i] = random.nextInt(randomBound);
            }while (numbers[i]==0);
        }
    }
    public int size(){
        return numbers.length;
    }
    public int get(int index){
        if(index<0||index>numbers.length){
            throw new IllegalArgumentException("数组长度非法");
        }
        return numbers[index];
    }
    public void swap(int i,int j){
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

}


