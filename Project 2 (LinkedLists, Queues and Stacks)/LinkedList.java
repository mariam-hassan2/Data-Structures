import java.util.NoSuchElementException;

/* A class that represents a linked list of nodes*/
public class LinkedList<T> {
//A field that stores the first node in the list
  private LLNode<T> firstNode;
  
// constructor 
  public LinkedList(LLNode firstNode) {
    this.firstNode = firstNode;
  }
  
// A method that returns the first node
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }

  /*A method for changing the first node
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }

  // A method for checking if the list is empty 
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
// method for adding to the front of the list
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  


  // A method that prints the linkedlist
  public void print(){
    //creating a variable: pointer
    LLNode pointer = firstNode;
    //iterating though the list and printing each element
    while (pointer != null){
      System.out.println(pointer.getElement() + " ");
      pointer = pointer.next;
    }
    
  }
  //A method that revserves the linkedlist
  public void reverse(){
    //creating a variable: pointer
    LLNode pointer = firstNode;
    //creating two variables: previous and current
    LLNode prev = null;
    LLNode cur = null;
    //iterating through the list to reverse the elements
    while(pointer!=null){
      cur = pointer;
      pointer = pointer.next;
      
      cur.setNext(prev);
      prev = cur;
      firstNode = cur;
    }
}
  //a main method to test my reversemethod 
  public static void main(String[] args){
  LLNode w = new LLNode(5,null);  
  LLNode v = new LLNode(6,null); 
  LLNode x = new LLNode(7,null);
  LLNode y = new LLNode(8,null);
  LLNode z = new LLNode(9,null);
  LinkedList s = new LinkedList(w);
  System.out.println("list before reversing:");
  w.setNext(v);
  v.setNext(x);
  x.setNext(y);
  y.setNext(z);
  s.print();
  System.out.println("list after reversing:");
  s.reverse();
  s.print();
  }
}
