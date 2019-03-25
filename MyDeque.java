import java.util.*;
import java.io.*;
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

  // see placement of each deque element in data
  public String toStringDebug(){
    String debug = "";
    debug += "(start, end): "+start+" , "+end + "|| ";
    debug += "[";
    for (int i = 0; i < data.length; i++){
      debug += i+": "+data[i]+", \n";
    }
    debug += "]";
    return debug;
  }

  // add element to beginning of deque
  public void addFirst(E element){
    // throw exception if attempting to add null element
    if (element == null){
      throw new NullPointerException();
    }
    // if array is full, resize array and set START as the last index of the array
    if (size >= data.length){
      resize(data);
      start = data.length - 1;
    }
    else{
      // if there's one element in the array at index 0, move START to the last index of the array
      if (start == 0 && size > 0 ){
        start = data.length - 1;
      }
      // otherwise, move START one index left
      else if (start > 0){
        start--;
      }
    }
    // set value of array at START as the given element and update size
    data[start] = element;
    size++;
  }

  // add element to the end of the deque
  public void addLast(E element){
    // throw exception if trying to add null element
    if (element == null){
      throw new NullPointerException();
    }
    // if array is full, resize array and update END
    if (size >= data.length){
      resize(data);
      end++;
    }
    else{
      // if there's at least one element in the deque, update end
      if (size > 0){
        end++;
      }
      // if end of array is reached, "loop" END around to the beginning of the array
      if (end >= data.length){
        end = 0;
      }
    }
    // set value of array at END as the given element and update size
    data[end] = element;
    size++;
  }

  // remove element from the beginning of the deque
  public E removeFirst(){
    // if deque is empty, throw exception
    if (size == 0){
      throw new NoSuchElementException();
    }

    // store old value at the START and reset value of array at START
    E old = data[start];
    data[start] = null;

    // update START by moving it by one to the right, or "looping" around to the beginning of the array
    if (size == 1){
      start = end;
    }
    else if (start < data.length - 1){
      start++;
    }
    else if (start >= data.length - 1){
      start = 0;
    }

    // update size and return the old element
    size--;

    return old;
  }

  // remove element from end of the deque
  public E removeLast(){
      // if deque is empty, throw exception
    if (size == 0){
      throw new NoSuchElementException();
    }

    // store old value at the END and reset value of array at END
    // also update size
    E old = data[end];
    data[end] = null;
    size--;
    // update END by moving it one to the left or "looping" around the array
    if (start <= end){
      if (size() >= 1){
        end--;
      }
    }
    else{
      if (end == 0){
        end = data.length - 1;
      }
    }
    //  return old element
    return old;
  }
  // retrieve the first element of the deque
  public E getFirst(){
    // if deque is empty, throw exception
    if (size == 0){
      throw new NoSuchElementException();
    }
    // otherwise, return element of array at START
    return data[start];
  }

  // retrieve the last element of the deque
  public E getLast(){
    // if deque is empty, throw exception
    if (size == 0){
      throw new NoSuchElementException();
    }

    // otherwise, return element of array at END
    return data[end];
  }

  public int getStart(){
    return start;
  }
  public int getEnd(){
    return end;
  }
  // resize array by copying over values to a new array with double capacity
  private void resize(E[] array){
    // make new array with double capacity
    @SuppressWarnings("unchecked")
    E[] newAry = (E[])new Object[array.length * 2];

    // copy over all the values of the array if start is less than end
    if (start <= end){
      for (int i = start; i <= end; i++){
        newAry[i] = array[i];
      }
    }
    else{
      /* If the values of the array loop around,
      copy from START to end of the array, then from index 0 to END of the array
      */
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

    // set new array as data, reset start and end
    data = newAry;
    start = 0;
    if (size() > 1){
      end = size() - 1;
    }else{
      end = 0;
    }
  }

}
