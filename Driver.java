public class Driver{
  public static void main(String[] args){
    MyDeque<Integer> deque = new MyDeque<Integer>();
    System.out.println(deque.size());
    System.out.println(deque);
    deque.addFirst(1);
    System.out.println(deque.size());
    System.out.println(deque);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    deque.addFirst(5);
    deque.addFirst(6);
    deque.addFirst(7);
    deque.addFirst(8);
    deque.addFirst(9);
    deque.addFirst(10);
    deque.addFirst(11);
    System.out.println(deque.size());
    System.out.println(deque);
  }
}
