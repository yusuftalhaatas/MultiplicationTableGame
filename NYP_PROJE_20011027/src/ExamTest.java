import org.junit.Test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ExamTest {
    @Test
    public void testGenerateTest() {
        Exam exam = new Exam(5, 1, 10);
        List<Question> test = exam.getTest();
        
        assertEquals(5, test.size());
        for (Question question : test) {
            int number1 = question.getNumber1();
            int number2 = question.getNumber2();
            
            assertTrue(number1 >= 1 && number1 <= 10);
            assertTrue(number2 >= 1 && number2 <= 10);
        }
    }
    
    
}
