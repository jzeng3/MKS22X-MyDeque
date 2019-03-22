public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  // initiate deque with an empty array of 10 elements, set size, start, end to 0 by default
  public MyDeque(){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[10];
      data = d;
      size = 0;
      start = 0;
      end = 0;
     }

// initiate deque with an empty array of specified capacity, set size, start, end to 0 by default
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[initialCapacity];
      data = d;
      size = 0;
      start = 0;
      end = 0;
    }

  // return number of elements in deque
  public int size(){
   return size;
 }

  // for printing out deque
  public String toString(){
    String dataStr = "";
    dataStr += "[";
    if (size > 0){
      // if start is less than end, just add every element from start to end
      if (start <= end){
      for (int i = start; i <= end; i++){
        dataStr += data[i];
        if (i != end){
          dataStr += ", ";
        }
      }
    }
     /* if array "loops around," add elements from START of deque to end of the array,
        then from beginning to END of deque */
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

  // add element to beginning of deque
  public void addFirst(E element){
    if (start == 0 && size > 0 && size < data.length){
      start = data.length - 1;
    }
    else if (start > 0 && size < data.length){
      start--;
    }
    else if (size >= data.length){
      System.out.println("resize to add "+element);
      resize(data);
      start = data.length - 1;
    }
    data[start] = element;
    size++;
    System.out.println("start: "+start);
    System.out.println("end: "+end);
  }

  public void addLast(E element){
    if (size >= data.length){
      System.out.println("resize to add "+element);
      resize(data);

      end++;
    }
    else{
      if (size > 0){
        end++;
      }
      if (end >= data.length){
        end = 0;
      }
    }
    data[end] = element;
    size++;
    System.out.println("element: "+element+" start: "+start);
    System.out.println("end: "+end);
  }
 public E removeFirst(){
   E old = data[start];
   if (size > 0){
     data[start] = null;
    if (start <= end || start < data.length - 1){
      start++;
    }
    else{
      start = 0;
    }
    size--;
   }
   System.out.println("start now: "+start);
   return old;
 }
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
        System.out.println(newAry[index]);
        index++;
      }
      for (int i = 0; i <= end; i++){
        newAry[index] = array[i];
        System.out.println(newAry[index]);
        index++;
      }
    }
    data = newAry;
    start = 0;
    end = size() - 1;
    System.out.println("end after resize: "+end);
    System.out.println(toString());
  }
}
