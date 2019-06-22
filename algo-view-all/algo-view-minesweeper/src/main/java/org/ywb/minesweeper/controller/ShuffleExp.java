package org.ywb.minesweeper.controller;

import java.util.Arrays;
import java.util.Random;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/22 14:30
 */

public class ShuffleExp {

    private static
    void shuffle(int[] arr){
        Random random = new Random();
        for(int i = 0;i<arr.length;i++){
            int x = random.nextInt(arr.length-i)+i;
            int t = arr[i];
            arr[i] = arr[x];
            arr[x] = t;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0;i<arr.length;i++){
            arr[i] = i+1;
        }
        shuffle(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
