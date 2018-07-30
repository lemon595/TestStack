import java.awt.*;

/**
 * @author lyj
 * @date 2018/7/30 - 16:23
 *
 *
 * 循环队列
 *
 */
public class LoopQueue<E> implements  Queue{


    private E[] data;
    private int front,tail;  //分别指向队首指向的索引和队尾指向的索引
    private int size; //队列中有多少个元素


    public LoopQueue(int capacity){
        data= (E[]) new Object[capacity+1];
        front=0;
        size=0;
        tail=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return  data.length-1;
    }





    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmty() {
        return front==tail;
    }

    @Override
    public void enqueue(Object e) {

        if ((tail+1) % data.length == front){  //队列满了
            resize(getCapacity()*2);
        }

        data[tail]= (E) e;
        tail =(tail+1)%data.length;
        size++;
    }


    private void resize(int newCapacity) {

        E[] newData= (E[]) new Object[newCapacity+1];

        for (int i = 0; i < size; i++) {
            newData[i]=data[(i+ front)%data.length];
        }

        data=newData;
        front =0;
        tail=size;
    }

    @Override
    public Object dequeue() {

        if (isEmty()){
            throw  new  IllegalArgumentException("Cannot dequeue from an empty queue");
        }

        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4 && getCapacity()/2!=0){
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public Object getFront() {

        if (isEmty()){
            throw  new  IllegalArgumentException(" dequeue is emty");
        }
        return data[front];
    }


    @Override
    public String toString(){

        StringBuilder res=new StringBuilder();
        res.append(String.format("queue:size =%d  ,  capacity =%d \n",size,getCapacity()));
        res.append("front[");

        for (int i = front; i!=tail; i=(i+1)%data.length) {
            res.append(data[i]);

            if ((i+1)%data.length != tail){
                res.append(",");
            }

        }


        res.append("]tail");
        return  res.toString();

    }


    public static void main(String[] args) {
        LoopQueue<Integer> queue=new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3 ==2){
                queue.dequeue();
            }
            System.out.println(queue);

        }

    }



}
