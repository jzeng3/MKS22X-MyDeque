import java.util.*;

public class Calculator{
    public static void main(String[] args){
      eval("10 2.0 +");
    }
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> deque = new MyDeque<Double>();
      String[] evalAry = s.split(" ");
      System.out.println(Arrays.toString(evalAry));
      for (int i = 0; i < evalAry.length; i++){
        if (evalAry.length == 1 &&
        (evalAry[i] == "+" || evalAry[i] == "-" || evalAry[i] == "*" || evalAry[i] == "/" || evalAry[i] == "%")){
            if (deque.size() >= 2){
              double num2 = deque.removeLast();
              double num1 = deque.removeLast();
              if (evalAry[i] == "+"){
                deque.addLast(num1 + num2);
              }
              if (evalAry[i] == "-"){
                deque.addLast(num1 - num2);
              }
              if (evalAry[i] == "*"){
                deque.addLast(num1 * num2);
              }
              if (evalAry[i] == "/"){
                deque.addLast(num1 / num2);
              }
              if (evalAry[i] == "%"){
                if (num2 != 0){
                  deque.addLast(num1 % num2);
                }
                else{
                  deque.addLast(0.0);
                }
              }
            }
          }
          try{
             System.out.println( Double.parseDouble(evalAry[i]) );

          }
          catch (NumberFormatException e){
          }
          System.out.println(i);

        }

        return 1.0;

      }

}
