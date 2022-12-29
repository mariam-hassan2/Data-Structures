import junit.framework.TestCase;
import java.util.Stack;
import org.junit.Assert.*;
/** A JUnit test for problem 2b
  */

public class CustomSQueueTest extends TestCase {
  public void test() throws EmptyStackException{ 
CustomSQueue temp = new CustomSQueue(new Stack());
temp.add(1);
temp.add(5);
temp.add(3);
temp.add(4);
assertEquals(temp.poll(), 1);
assertEquals(temp.poll(), 5);
assertNotSame(temp.poll(),4);
assertEquals(temp.poll(), 4);

  }
  
}
