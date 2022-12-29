import java.util.Stack;
import java.lang.*;
import org.junit.Assert.*;

//2b
// A class for problem 2b (provided a Junit Test)
public class CustomSQueue<Integer>{
  //Creating two fields for storing two stacks 
  Stack stack1 = new Stack();
  Stack stack2 = new Stack();
  
  //Constructor
  public<Integer> CustomSQueue(Stack s1){
  stack1 = s1; 
  }
  //A method that implements removing an element from a queue
  public int poll()throws EmptyStackException{
    // Checking if the stack is empty and throws an exception based on that
    if(stack1.empty()){
      throw new EmptyStackException();
    }
    //Returning the removed element
    int removed = (int)stack1.pop();
    return removed;
  }
  /*Helper method: swaps two stacks 
   * @param: two stacks 
   * */
  public void swap(Stack s1, Stack s2){
      while(!s1.empty()){
      s2.push(s1.pop());
    }
  }
  // A method taht implements adding an element in queues 
  public void add(int element){
    // swapping the two stacks 
     swap(stack1,stack2);
    // adding the new element
    stack1.push(element);
    //swapping back again
    swap(stack2,stack1);
    }
}