import org.junit.Test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class AdminTest {
    @Test
    public void testAddChild() {
        Admin admin = new Admin("John");
        Child child = new Child("Alice");
        
        admin.addChild(child);
        List<Child> children = admin.getChildList();
        
        assertEquals(1, children.size());
        assertTrue(children.contains(child));
    }
    
    @Test
    public void testCheckChild() {
        Admin admin = new Admin("John");
        Child child1 = new Child("Alice");
        Child child2 = new Child("Bob");
        
        admin.addChild(child1);
        
        assertTrue(admin.checkChild("Alice"));
        assertFalse(admin.checkChild("Bob"));
    }
    
   
}
