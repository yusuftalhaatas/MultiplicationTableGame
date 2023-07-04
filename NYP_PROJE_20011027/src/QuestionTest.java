import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTest {
    @Test
    public void testGetResult() {
        Question question = new Question(2, 3);
        int result = question.getResult();
        assertEquals(6, result);
    }

    @Test
    public void testGetNumber1() {
        Question question = new Question(2, 3);
        int number1 = question.getNumber1();
        assertEquals(2, number1);
    }

    @Test
    public void testGetNumber2() {
        Question question = new Question(2, 3);
        int number2 = question.getNumber2();
        assertEquals(3, number2);
    }
}
