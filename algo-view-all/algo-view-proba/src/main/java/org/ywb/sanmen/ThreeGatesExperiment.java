package org.ywb.sanmen;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/15 17:27
 */

public class ThreeGatesExperiment {
    private int N;
    public ThreeGatesExperiment(int N){
        if(N<=0){
            throw new IllegalArgumentException("N must be large than 0!");
        }
        this.N = N;
    }

    /**
     * 计算完N次的胜率
     * @param changeDoor 参赛者的选择true不换
     */
    public void run(boolean changeDoor){
        int wins = 0;
        for(int i = 0;i<N;i++){
            if(play(changeDoor)){
                wins++;
            }
        }
        System.out.println(changeDoor?"change":"not Change");
        System.out.println("wins rate:"+(double)wins/N);
    }

    /**
     * 玩一次的结果
     * @param changeDoor 参赛者的选择true不换
     * @return 赢了true
     */
    private boolean play(boolean changeDoor){
        // Door 0,1,2
        int prizeDoor = (int)(Math.random()*3);
        int playerChoice = (int)(Math.random()*3);
        if(playerChoice==prizeDoor){
            return !changeDoor;
        }else {
            return changeDoor;
        }
    }

    public static void main(String[] args){
        ThreeGatesExperiment threeGatesExperiment = new ThreeGatesExperiment(10000000);
        threeGatesExperiment.run(true);
        threeGatesExperiment.run(false);
    }

}
