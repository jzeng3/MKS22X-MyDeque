import java.util.*;

public class Calculator{
    public static void main(String[] args){
      System.out.println(eval("10 2.0 +"));
      System.out.println(eval("11 3 - 4 + 2.5 *"));
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
      System.out.println(eval("1 2 3 4 5 + * - -"));
      System.out.println(eval("1 2 /"));
      System.out.println(eval("3 0 /"));
      System.out.println(eval("0 3 %"));
      System.out.println(eval("42 1 + 2 3 4 + - *"));
    }
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      // instantiate new deque of doubles
      MyDeque<Double> deque = new MyDeque<Double>();
      // place space-separated substrings into a string array
      String[] evalAry = s.split(" ");

      // loop through the string array
      for (int i = 0; i < evalAry.length; i++){
        // if the current element is an operator
        if (evalAry[i].length() == 1 &&
        ( evalAry[i].equals("+") || evalAry[i].equals("-") || evalAry[i].equals("*")
        || evalAry[i].equals("/") || evalAry[i].equals("%") )){
            // store and remove the last two elements in the deque
            if (deque.size() >= 2){
              double num2 = deque.removeLast();
              double num1 = deque.removeLast();
              // perform the indicated operation and add the resulting double to the deque
              if (evalAry[i].equals("+")){
                deque.addLast(num1 + num2);
              }
              if (evalAry[i].equals("-")){
                deque.addLast(num1 - num2);
              }
              if (evalAry[i].equals("*")){
                deque.addLast(num1 * num2);
              }
              if (evalAry[i].equals("/")){
                if (num2 != 0){
                  deque.addLast(num1 / num2);
                }
                else{
                  deque.addLast(0.0); // in case of division by 0
                }
              }
              if (evalAry[i].equals("%") ){
                if (num2 != 0){
                  deque.addLast(num1 % num2);
                }
                else{
                  deque.addLast(0.0); // in case of mod by 0
                }
              }
            }
          }
          else{
            // if element is not an operator, parse it as a double and add it to the deque
             deque.addLast(Double.parseDouble(evalAry[i]) );
          }

        }
        // at the end, there should be one number, which is returned
        return deque.getFirst();

      }

}
