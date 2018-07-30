/**
 * @author lyj
 * @date 2018/7/30 - 13:38
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();



}
