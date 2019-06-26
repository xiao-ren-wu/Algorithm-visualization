package org.ywb.createmaze.data;

import java.util.LinkedList;

/**
 * @author YuWenbo
 * e-mail 18629015421@163.com
 * github https://github.com/xiao-ren-wu
 * @version 1
 * @since 2019/6/26 11:02
 */

public class RandomQueue<E> {
    private LinkedList<E> queue;

    public RandomQueue() {
        this.queue= new LinkedList<>();
    }

    public void add(E e){
        if(Math.random()<0.5){
            queue.addFirst(e);
        }else{
            queue.addLast(e);
        }
    }

    public E remove(){
        if(queue.size()==0){
            throw new IllegalArgumentException("no element");
        }
        if(Math.random()<0.5){
            return queue.removeFirst();
        }else {
            return queue.removeLast();
        }
    }

    public int size(){
       return queue.size();
    }

    public boolean empty(){
        return queue.size()==0;
    }
}
