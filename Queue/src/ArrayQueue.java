/**
 * @author lyj
 * @date 2018/7/30 - 15:43
 */

public class ArrayQueue<E> implements  Queue {

    private ArrayPlusPlus<E> array;

    public ArrayQueue(int capacity){
        array=new ArrayPlusPlus<>(capacity);
    }

    public ArrayQueue(){
        array=new ArrayPlusPlus<>();
    }

    public int getCapacity(){
        return  array.getCaacity();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmty() {
        return array.isEmty();
    }

    @Override
    public void enqueue(Object o) {
        array.addList((E) o);
    }

    @Override
    public Object dequeue() {
        return array.removeFirst();
    }

    @Override
    public Object getFront() {
        return array.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Queue:");
        res.append("front[");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize() -1){
                res.append(",");
            }
        }
        res.append("] tail");
        return  res.toString();
    }


    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i%3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }


        } 
    }

}
