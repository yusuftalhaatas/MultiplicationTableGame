import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exam {
    private int questionNum;
    private int a;
    private int b;
    private List<Question> test;
    private int i;
    private Question question;
    Random random = new Random();
    private int number1, number2;

    public Exam(int questionNum, int a, int b) {
        this.questionNum = questionNum;
        this.a = a;
        this.b = b;
        this.test = new ArrayList<Question>(); // test listesini başlat
        generateTest();
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void generateTest() {
        for (i = 0; i < questionNum; i++) {
            number1 = random.nextInt(b - a + 1) + a;
            number2 = random.nextInt(b - a + 1) + a;
            question = new Question(number1, number2);
            //System.out.println(question.getNumber1()+"*"+question.getNumber2()+"="+question.getResult());
            test.add(question);
        }
    }

    public int getQuestionNum() {
        return questionNum;
    }

    public void testSaveToFile() {
    	
        try (PrintWriter writer = new PrintWriter(new FileWriter("test.txt"))) {
        	System.out.println("test saved to test.txt file");
        	writer.println(questionNum);
            for (Question question : this.test) {
                int number1 = question.getNumber1();
                int number2 = question.getNumber2();
                int result = question.getResult();
                writer.println(number1);
                writer.println(number2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   public List<Question> getTest(){
	   return test;
   }
}
