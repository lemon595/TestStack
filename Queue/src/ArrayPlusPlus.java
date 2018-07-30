/**
 *   这个类使用泛型  支持任意数据类型   增加了动态数组
 * @author lyj
 * @date 2018/7/25 - 16:33
 */
public class ArrayPlusPlus<E> {

    private  E [] data;   //存放数据的

    private int size;      //data 数组中究竟有多少个有效的元素


    /**
     *   希望这个数组开多大的容量
     * @param caacity
     */
    public ArrayPlusPlus(int caacity){

        data = (E[]) new Object[caacity];
        size =0;
    }

    /**
     * 默认的构造函数，给数组的容量设为了10  在这里用this 指向的是上面的方法
     */
    public ArrayPlusPlus(){
        this(10);
    }


    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return  size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCaacity(){
        return  data.length;
    }


    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmty(){
        return size==0;
    }

    /**
     * 向所有元素后添加一个新元素
     * @param e
     */
    public void  addList(E e){

      /*  //添加数据的操作要考虑这个数组是不是已经存满了，如果存满了就不能继续存，需要做对应的处理
        if (size ==data.length){
            throw  new IllegalArgumentException("AddList failed.array is full.");
        }

        data[size]=e;    //先进行赋值
        size ++;        //让size 指向后面一个元素的位置 类似指针*/

      add(size,e);  //复用add 方法
    }


    /**
     * 向所有元素前面添加一个新元素
     * @param e
     */
    public void  addFirst(E e){
        add(0,e);
    }



    /**
     *   在第index 个位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index ,E e){

        //考虑index 是不是合法的  1.index 不能为负数  第二  index 不能是大于size 的，否则就不是紧密的排列了
        if (index <0 || index >size){
            throw  new IllegalArgumentException("Add failed.1.index 不能为负数  第二  index 不能是大于size 的，否则就不是紧密的排列了");
        }

        //添加数据的操作要考虑这个数组是不是已经存满了，如果存满了就不能继续存，需要做对应的处理 扩容处理
        if (size ==data.length){
            resize(2*data.length);
        }

        //给后一个位置赋值成前一个位置的值
       for (int i=size-1; i>=index; i--){
            data[i+1]=data[i];
       }

        data[index] =e;
        size ++;
    }


    /**
     * 获取index 索引位置的元素
     * @param index
     * @return
     */
  public  E get(int index){
        if (index <0 || index >=size){
            throw  new IllegalArgumentException("get failed .index is illegal");
        }
        return data[index];
    }



    public E getLast(){
      return  get(size-1);
    }


    public E getFirst(){
      return  get(0);
    }

    /**
     * 修改index 索引位置的元素
     * @param index
     * @param e
     */
   public  void  set(int index,E e){
        if (index <0 || index >=size){
            throw  new IllegalArgumentException("get failed .index is illegal");
        }

        data[index] =e;

    }

    /**
     * 查找数组中是否有元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i] ==e){
                return true;
            }
        }
        return  false;
    }


    /***
     *   找到这个元素，并返回索引  找到的话放回索引，没有找到的话，则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)){
                return  i;
            }
        }
        return -1;
    }


    /**
     *   删除索引对应的元素，删除元素作为返回值返回
     * @param index
     * @return
     */
    public E remove(int index){

        if (index <0 || index >=size){
            throw  new IllegalArgumentException("get failed .index is illegal");
        }
        E ret=data[index];  //存起来，最后作为返回值
       for (int i= index +1;i<size;i++){
            data[i-1]=data[i];
        }
        size --;
       data[size] = null;

       if (size ==data.length /4  && data.length /2 !=0){
           resize(data.length/2);
       }

        return ret;
    }


    /**
     * 删除第一个元素
     * @return
     */
    public  E removeFirst(){
      return  remove(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void  removeElement(E e){
        int index= find(e);
        if (index != -1){
            remove(index);
        }
    }






    /**
     * 自己重写的一个tostring 方法
     * @return
     */
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array:size =%d , caacity =%d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);

            if (i != size - 1) {
                res.append(",");
            }

        }
        res.append(']');

        return  res.toString();
    }

    /**
     * 扩容方法
     * @param newCapatity
     */
        private  void  resize(int newCapatity){
        E[] newData= (E[]) new Object[newCapatity];
        for (int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data =newData;
        }


    }

