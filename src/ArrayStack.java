/**
 * @author lyj
 * @date 2018/7/30 - 13:40
 */
public class ArrayStack<E> implements  Stack {

    ArrayPlusPlus<E> array;

    public ArrayStack(int capacity){
        array =new ArrayPlusPlus<>(capacity);
    }


    public ArrayStack(){
     array =new ArrayPlusPlus<>();
    }


    public int getCapatity(){
        return array.getCaacity();
    }




    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return array.isEmty();
    }

    @Override
    public void push(Object o) {
        array.addList((E) o);
    }


    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize() -1){
                res.append(",");
            }
        }
        res.append("] top");
        return  res.toString();
    }


}
