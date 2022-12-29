import junit.framework.TestCase;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Assert;

/** A JUnit test for problem 2a
  */
public class testCustomQStack extends TestCase {
  
  public void testCustomQStack()throws EmptyQueueException {
        CustomQStack s = new CustomQStack(new LinkedList());
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        Assert.assertEquals(s.top(),8);
        Assert.assertEquals(s.pop(),8);
        Assert.assertEquals(s.top(),7);
        Assert.assertEquals(s.pop(),7);
        s.push(9);
        Assert.assertEquals(s.pop(),9);

    
  }
  
}
