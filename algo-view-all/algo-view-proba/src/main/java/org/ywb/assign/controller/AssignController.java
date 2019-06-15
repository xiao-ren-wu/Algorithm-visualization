package org.ywb.assign.controller;

import org.ywb.assign.data.Money;
import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.views.AlgoFrame;

import java.util.Arrays;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 13:06
 */

public class AssignController extends BaseAlgoVisualizer<Money> {

    public AssignController(AlgoFrame frame) {
        super(frame);
    }

    @Override
    public void update(Money money) {
        Arrays.sort(money.money);
        for(int k=0;k<50;k++) {
            for (int i = 0; i < money.money.length; i++) {
                if (money.money[i] > 0) {
                    int j = (int) (Math.random() * money.money.length);
                    money.money[i] -= 1;
                    money.money[j] += 1;
                }
            }
        }
    }

    @Override
    public Money initData() {
        Money money = new Money();
        money.money=new int[100];
        for(int i=0;i<100;i++){
            money.money[i]=100;
        }
        return money;
    }
}
