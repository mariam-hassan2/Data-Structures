// A class that represents node
public class LLNode<T> {
  // the element stored in the node
  public T element;
  
  /** a reference to the next node of the list */
  public LLNode<T> next;
  
  // the constructor

  public LLNode(T element, LLNode<T> next) {
    this.element = element;
    this.next = next;
  }
  
 // A method that returns the element stored in the node
  public T getElement() {
    return element;
  }
  
 // A method that returns the next element 
  public LLNode<T> getNext() {
    return next;
  }
  
// A method for changing the element
  public void setElement(T element) {
    this.element = element;
  }

  //A method that changes the next node 
  public void setNext(LLNode<T> next) {
    this.next = next;
  }
  
}
