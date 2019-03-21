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

  public void addFirst(E element){
    if (start == 0 && size > 0){
      start = data.length - 1;
    }
    else if (start > 0 && size < data.length){
      start--;
    }
    else if (size == data.length){
      System.out.println("resize");
      resize(data);
    }
    data[start] = element;
    size++;
    System.out.println("start: "+start);
    System.out.println("end: "+end);
  }
  //public void addLast(E element){ }
//  public E removeFirst(){ return element;}
  //public E removeLast(){return element; }
  //public E getFirst(){ return element;}
  //public E getLast(){return element; }
  private void resize(E[] array){
    @SuppressWarnings("unchecked")
    E[] newAry = (E[])new Object[array.length * 2];
    if (start <= end){
      for (int i = start; i <= end; i++){
        newAry[i] = array[i];
      }
    }
    else{
      int index = 0;
      for (int i = start; i < data.length; i++){
        newAry[index] = array[i];
        index++;
      }
      for (int i = 0; i <= end; i++){
        newAry[index] = array[i];
        index++;
      }
    }
    start = 0;
    end = size - 1;
  }
}
