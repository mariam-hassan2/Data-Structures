import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;
import java.lang.Exception;

// 2a
// A class for problem 2a (provided a Junit Test)
public class CustomQStack{
  // A field that stores a queue
  Queue<Integer> queue = new LinkedList<Integer>();
  // A constructor
  public CustomQStack(Queue queue){
    this.queue = queue;
  }
  /* A method that implements the push method in stacks
   * @param: int value*/
  public void push(int value){
    // created a variable to store the size of the queue
    int capacity = queue.size();
    //adding the element to the queue
    queue.add(value);
    //iterating through the list 
    for(int i =0; i < capacity; i++){
    queue.add(queue.remove());
    }
  }
  // A method that implements the pop method in stacks
  public int pop() throws EmptyQueueException{
    //Checking if the queue is empty and throws an exception if it's empty
    if(queue.isEmpty()){
     throw new EmptyQueueException();
    }
    //returning the element that was removed
    int removed = queue.remove();
    return removed;
    
  }
  // A method that returns the top of the stack
  public int top()throws EmptyQueueException{
    if(queue.isEmpty()){
      throw new EmptyQueueException();
    }
    return queue.peek();
  }
  //A method that checks if teh stack is empty
  public boolean isEmpty()
    {
        return queue.isEmpty();
    }     
}