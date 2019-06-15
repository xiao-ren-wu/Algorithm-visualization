package org.ywb.assign;


import org.ywb.assign.controller.AssignController;
import org.ywb.assign.data.Money;
import org.ywb.consumer.Consumer;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 12:37
 *
 * 房间里有100个人，每个人都有100块钱，
 * 他们在玩一个游戏，每轮游戏中，每个人都要拿出一元钱给另一个人，
 * 最后这100个人的财富分布是怎样的？
 */

public class AssignMoney {
    public static void main(String[] args) {
        int canvasWidth = 1000;
        int canvasHeight = 800;
        AlgoFrame assignMoney = new AlgoFrame("assign money",canvasWidth,canvasHeight);

        assignMoney.paint((Consumer<Money>) (g, money) -> {
            AlgoVisHelper.setColor(g,AlgoVisHelper.Blue);
            int[] moneyArr = money.money;
            int w = canvasWidth/moneyArr.length;
            for(int i=0;i<moneyArr.length;i++){
                AlgoVisHelper.fillRectangle(g,
                        i*w+1,
                        canvasHeight-moneyArr[i],
                        w-1,moneyArr[i]
                );
            }
        });
        AssignController assignController = new AssignController(assignMoney);
    }
}
