package org.ywb.createmaze.controller;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.createmaze.data.MazeData;
import org.ywb.createmaze.data.Position;
import org.ywb.createmaze.data.RandomQueue;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/26 9:50
 */

public class CreateMazeController extends BaseAlgoVisualizer<MazeData> {

    /**
     * 迷宫的长和宽
     */
    private int n,m;

    /**
     * 四个方向
     */
    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};

    public CreateMazeController(AlgoFrame frame,int n,int m) {
        super(frame);
        this.n = n;
        this.m = m;
    }

    @Override
    public void update(MazeData mazeData) {
       // go(mazeData,mazeData.getEntranceX(),mazeData.getEntranceY()+1);
        go3(mazeData);
    }

    /**
     * 使用随机队列生成随机迷宫
     * @param mazeData
     */
    private void go3(MazeData mazeData){
        setData(mazeData,-1,-1);
        RandomQueue<Position> queue = new RandomQueue<>();
        Position first = new Position(mazeData.getEntranceX(), mazeData.getEntranceY() + 1);
        queue.add(first);
        mazeData.visited[first.getX()][first.getY()] = true;
        mazeData.openMist(first.getX(),first.getY());
        while (queue.size()!=0){
            Position curPos = queue.remove();
            for(int i = 0;i<4;i++){
                int newX = curPos.getX()+d[i][0]*2;
                int newY = curPos.getY()+d[i][1]*2;
                if(mazeData.inArea(newX,newY)&&!mazeData.visited[newX][newY]){
                    queue.add(new Position(newX,newY));
                    mazeData.visited[newX][newY] = true;
                    mazeData.openMist(newX,newY);
                    setData(mazeData,curPos.getX()+d[i][0],curPos.getY()+d[i][1]);
                }
            }
        }
        setData(mazeData,-1,-1);
    }



    /**
     * 广度优先遍历
     * @param mazeData
     */
    private void go2(MazeData mazeData){
        setData(mazeData,-1,-1);
        LinkedList<Position> queue = new LinkedList<>();
        Position first = new Position(mazeData.getEntranceX(), mazeData.getEntranceY() + 1);
        queue.addLast(first);
        mazeData.visited[first.getX()][first.getY()] = true;
        while (queue.size()!=0){
            Position curPos = queue.removeFirst();
            for(int i = 0;i<4;i++){
                int newX = curPos.getX()+d[i][0]*2;
                int newY = curPos.getY()+d[i][1]*2;
                if(mazeData.inArea(newX,newY)&&!mazeData.visited[newX][newY]){
                    queue.addLast(new Position(newX,newY));
                    mazeData.visited[newX][newY] = true;
                    setData(mazeData,curPos.getX()+d[i][0],curPos.getY()+d[i][1]);
                }
            }
        }
        setData(mazeData,-1,-1);
    }

    /**
     * 非递归深度优先遍历
     * @param mazeData
     */
    private void go1(MazeData mazeData){
        setData(mazeData,-1,-1);
        Stack<Position> stack = new Stack<>();
        Position first = new Position(mazeData.getEntranceX(), mazeData.getEntranceY() + 1);
        stack.push(first);
        mazeData.visited[first.getX()][first.getY()] = true;
        while (!stack.empty()){
            Position curPos = stack.pop();
            for(int i = 0;i<4;i++){
                int newX = curPos.getX()+d[i][0]*2;
                int newY = curPos.getY()+d[i][1]*2;
                if(mazeData.inArea(newX,newY)&&!mazeData.visited[newX][newY]){
                    stack.push(new Position(newX,newY));
                    mazeData.visited[newX][newY] = true;
                    setData(mazeData,curPos.getX()+d[i][0],curPos.getY()+d[i][1]);
                }
            }

        }

        setData(mazeData,-1,-1);
    }


    /**
     * 深度优先遍历
     * @param data
     * @param beginX
     * @param beginY
     */
    private void go(MazeData data,int beginX,int beginY){
        setData(data,-1,-1);
        if(!data.inArea(beginX,beginY)){
            throw new IllegalArgumentException("this point not in maze area");
        }
        data.visited[beginX][beginY] = true;
        for(int i = 0;i<4;i++){
            int newX = beginX+d[i][0]*2;
            int newY = beginY+d[i][1]*2;
            if(data.inArea(newX,newY)&&!data.visited[newX][newY]){
                setData(data,beginX+d[i][0],beginY+d[i][1]);
                go(data,newX,newY);
            }
        }
        setData(data,-1,-1);
    }



    private void setData(MazeData data,int x,int y){
        if(data.inArea(x,y)){
            data.maze[x][y] = MazeData.ROAD;
        }
        this.getFrame().render(data);
        AlgoVisHelper.pause(5);
    }


    @Override
    public MazeData initData() {
        setKeyAdapter(new AlgoKeyListener());
        return new MazeData(n,m);
    }

    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
