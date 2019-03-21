public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[10];
      data = d;
      size = 0;
     }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
      size = 0;
    }
  public int size(){
   return size;
 }
  public String toString(){ }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(E element){ }
  public E removeLast(E element){ }
  public E getFirst(E element){ }
  public E getLast(E element){ }
}
