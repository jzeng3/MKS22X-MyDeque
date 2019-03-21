public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[10];
      data = d;
      size = 0;
      start = 0;
      end = 0;
     }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
      size = 0;
      start = 0;
      end = 0;
    }
  public int size(){
   return size;
 }
  public String toString(){
    String dataStr = "";
    dataStr += "[";
    if (size > 0){
      if (start <= end){
      for (int i = start; i <= end; i++){
        dataStr += data[i];
        if (i != end){
          dataStr += ", ";
        }
      }
    }
      else{
        for (int i = start; i < data.length; i++){
          dataStr += data[i] + ", ";
        }
        for (int i = 0; i <= end; i++){
          dataStr += data[i];
          if (i != end){
            dataStr += ", ";
          }
        }
      }
    }
    dataStr += "]";
    return dataStr;
  }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(E element){ return element;}
  public E removeLast(E element){return element; }
  public E getFirst(E element){ return element;}
  public E getLast(E element){return element; }
}
