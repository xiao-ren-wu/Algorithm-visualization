package org.ywb.minesweeper.controller;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.minesweeper.data.MineSweeperData;
import org.ywb.views.AlgoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/22 13:47
 */

public class MineController extends BaseAlgoVisualizer<MineSweeperData> {
    private int n,m,mines;

    private MineSweeperData data;

    public MineController(AlgoFrame frame,int n,int m,int mines) {
        super(frame);
        this.m = m;
        this.n = n;
        this.mines = mines;
    }

    @Override
    public void update(MineSweeperData mineSweeperData) {
    }

    @Override
    public MineSweeperData initData() {
        this.setMouseAdapter(new AlgoMouseListener());
        data = new MineSweeperData(n,m,mines);
        return data;
    }

    private void setData(boolean isLeftClicked,int x,int y){
        if(data.inArea(x,y)){
            if(isLeftClicked){
                if(data.isMine(x,y)){
                    //游戏结束
                    for(int i = 0;i<n;i++){
                        for (int j = 0;j<m;j++){
                            if(data.isMine(i,j)){
                                data.open[i][j] = true;
                            }
                        }
                    }
                }else{
                    //没有点到雷，将周围的地方扩散开

                    data.light(x,y);
                }
            }else {
                data.flags[x][y] = !data.flags[x][y];
            }
        }
        getFrame().render(data);
    }

    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent event) {
            event.translatePoint(
                    0,
                    -(int)(getFrame().getBounds().height - getFrame().getCanvasHeight()-10)
            );            Point pos = event.getPoint();
            int w = getFrame().getCanvasWidth() / data.getM();
            int h = getFrame().getCanvasHeight() / data.getN();

            int x = pos.y / h;
            int y = pos.x / w;

            if(SwingUtilities.isLeftMouseButton(event)){
                setData(true,x,y);
            }else {
                setData(false,x,y);
            }
        }
    }
}
