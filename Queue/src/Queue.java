/**
 * @author lyj
 * @date 2018/7/30 - 15:42
 */
public interface Queue<E> {

    int getSize();
    boolean isEmty();
    void  enqueue(E e);
    E dequeue();
    E getFront();




}
