package org.ywb.maze.controller;

import org.ywb.controller.BaseAlgoVisualizer;
import org.ywb.maze.data.MazeData;
import org.ywb.maze.data.Position;
import org.ywb.tools.AlgoVisHelper;
import org.ywb.views.AlgoFrame;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1.3
 * @since 2019/6/20 18:30
 */

public class MazeDataController extends BaseAlgoVisualizer<MazeData> {

    private static final int d[][] = {{-1,0},{0,1},{1,0},{0,-1}};


    public MazeDataController(AlgoFrame frame) {
        super(frame);
    }

    @Override
    public void update(MazeData mazeData) {
        //递归深度优先遍历
//        setData(mazeData,-1,-1,false);
//        if(!go(mazeData,mazeData.getEntranceX(),mazeData.getEntranceY())){
//            System.out.println("迷宫无解！！！");
//        }
//        setData(mazeData,-1,-1,false);


        //-------------------------------
        //广度优先遍历
        run(mazeData);

        //-------------------------------
        //非递归深度优先遍历
//        go(mazeData);
    }



    @Override
    public MazeData initData() {
        return new MazeData("H:\\Algorithm-visualization\\algo-view-all\\algo-view-maze\\src\\main\\resources\\maze_101_101.txt");
    }


    public void setData(MazeData data,int x,int y,boolean flag){
        if(data.inArea(x,y)) {
            data.path[x][y] = flag;
        }
        getFrame().render(data);
        AlgoVisHelper.pause(10);
    }

    private void go(MazeData data) {
        setData(data, -1, -1, false);

        Stack<Position> stack = new Stack<>();
        Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
        stack.push(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        while (!stack.empty()) {
            Position curPos = stack.pop();
            setData(data, curPos.getX(), curPos.getY(), true);

            if (curPos.getX() == data.getExitX() && curPos.getY() == data.getExitY()) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curPos.getX() + d[i][0];
                int newY = curPos.getY() + d[i][1];

                if (data.inArea(newX, newY)
                        && !data.visited[newX][newY]
                        && data.getMaze(newX, newY) == MazeData.ROAD) {
                    stack.push(new Position(newX, newY,curPos));
                    data.visited[newX][newY] = true;
                }
            }

            setData(data, -1, -1, false);
        }
    }

    /**
     * 从终点开始寻找路径
     * @param des 终点坐标
     */
    private void findPath(MazeData data,Position des) {
        Position cur = des;
        while (cur!=null){
            data.result[cur.getX()][cur.getY()]=true;
            cur = cur.getPrev();
        }
    }

    private void run(MazeData data){

        setData(data,-1, -1, false);

        LinkedList<Position> queue = new LinkedList<>();
        Position entrance = new Position(data.getEntranceX(), data.getEntranceY());
        queue.addLast(entrance);
        data.visited[entrance.getX()][entrance.getY()] = true;

        boolean isSolved = false;

        while(queue.size() != 0){
            Position curPos = queue.pop();
            setData(data,curPos.getX(), curPos.getY(), true);

            if(curPos.getX() == data.getExitX() && curPos.getY() == data.getExitY()){
                isSolved = true;
                findPath(data,curPos);
                break;
            }

            for(int i = 0 ; i < 4  ; i ++){
                int newX = curPos.getX() + d[i][0];
                int newY = curPos.getY() + d[i][1];

                if(data.inArea(newX, newY)
                        && !data.visited[newX][newY]
                        && data.getMaze(newX, newY) == MazeData.ROAD){
                    queue.addLast(new Position(newX, newY, curPos));
                    data.visited[newX][newY] = true;
                }
            }

        }

        if(!isSolved) {
            System.out.println("The maze has no Solution!");
        }
        setData(data,-1, -1, false);
    }
}
