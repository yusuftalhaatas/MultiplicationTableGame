import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class QuestionPage extends JFrame {

    private JPanel contentPane;
    private JTextField answerField;
    private JOptionPane alertJOptionPane;
    private boolean answer;
    private Timer timer;
    private int time;

    private List<Question> test;
    private int questionNum;
    private Question question;
    private int number1, number2;
    private int currentQuestionIndex;
    private JLabel number_1;
    private JLabel number_2;
    private JLabel timeLabel;
    
    
    private int wrongAnswer=0,trueAnswer=0;
    private int totalTime;

    /**
     * Launch the application.
     */
   

    /**
     * Create the frame.
     */
    public QuestionPage(String childName) {

        test = new ArrayList<Question>();
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            questionNum = Integer.parseInt(reader.readLine());
            System.out.println("Number of questions-" + questionNum);
            for (int i = 0; i < questionNum; i++) {
                number1 = Integer.parseInt(reader.readLine());
                number2 = Integer.parseInt(reader.readLine());
                System.out.println(i + 1 + "-question " + "A-" + number1 + " B- " + number2);
                question = new Question(number1, number2);
                test.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 511, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        alertJOptionPane = new JOptionPane();
        JButton okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int userAnswer = Integer.parseInt(answerField.getText());
                Question currentQuestion = test.get(currentQuestionIndex);
                int correctAnswer = currentQuestion.getResult();

                if (userAnswer == correctAnswer) {
                    JOptionPane.showMessageDialog(contentPane, "Correct Answer");
                    trueAnswer++;
                } else {
                    JOptionPane.showMessageDialog(contentPane,
                            "Wrong Answer. Correct Answer is " + correctAnswer);
                    wrongAnswer++;
                }

                currentQuestionIndex++; // Bir sonraki soruya geç

                if (currentQuestionIndex < test.size()) {
                    // Bir sonraki soruyu göster
                    showQuestion(test.get(currentQuestionIndex));
                } else {
                    // Tüm sorular tamamlandı, mesaj göster ve pencereyi kapat
                	writeResultsToCSV(childName, trueAnswer, wrongAnswer, totalTime);
                    JOptionPane.showMessageDialog(contentPane, "All questions answered");
                    ResultPage resultPage=new ResultPage(wrongAnswer, trueAnswer, totalTime);
                    resultPage.setVisible(true);
                    dispose();
                }
            }
        });
        okBtn.setForeground(UIManager.getColor("Button.light"));
        okBtn.setFont(new Font("Lucida Grande", Font.BOLD, 26));
        okBtn.setBounds(357, 182, 109, 63);
        contentPane.add(okBtn);

        number_1 = new JLabel("");
        number_1.setFont(new Font("Lucida Grande", Font.BOLD, 26));
        number_1.setBounds(28, 80, 86, 50);
        contentPane.add(number_1);

        JLabel xLbl = new JLabel("X");
        xLbl.setForeground(new Color(83, 84, 255));
        xLbl.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        xLbl.setHorizontalAlignment(SwingConstants.CENTER);
        xLbl.setBounds(111, 80, 86, 50);
        contentPane.add(xLbl);

        number_2 = new JLabel("");
        number_2.setFont(new Font("Lucida Grande", Font.BOLD, 26));
        number_2.setBounds(209, 80, 86, 50);
        contentPane.add(number_2);

        JLabel equLbl = new JLabel("=");
        equLbl.setForeground(new Color(83, 84, 255));
        equLbl.setFont(new Font("Lucida Grande", Font.BOLD, 27));
        equLbl.setHorizontalAlignment(SwingConstants.CENTER);
        equLbl.setBounds(270, 79, 86, 50);
        contentPane.add(equLbl);

        answerField = new JTextField();
        answerField.setHorizontalAlignment(SwingConstants.CENTER);
        answerField.setFont(new Font("Lucida Grande", Font.BOLD, 26));
        answerField.setBounds(349, 80, 130, 50);
        contentPane.add(answerField);
        answerField.setColumns(10);

        JLabel questionCounterLbl = new JLabel(childName);
        questionCounterLbl.setBounds(19, 24, 61, 16);
        contentPane.add(questionCounterLbl);

        timeLabel = new JLabel("0 s");
        timeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        timeLabel.setBounds(424, 24, 61, 25);
        contentPane.add(timeLabel);

        currentQuestionIndex = 0; // İlk soruya başla
        showQuestion(test.get(currentQuestionIndex)); // İlk soruyu göster

        // Timer başlat
        time = 0;
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                time++;
                timeLabel.setText(time + " s");
                totalTime=time;
            }
        });
        timer.start();
    }

    private void showQuestion(Question question) {
        // Soruyu ekranda göstermek için gerekli işlemler
        number_1.setText(String.valueOf(question.getNumber1()));
        number_2.setText(String.valueOf(question.getNumber2()));
    }
    
    public static void writeResultsToCSV(String childName, int trueAnswer, int wrongAnswer, int totalTime) {
        String filePath = "results.csv";
        File dosya = new File(filePath);

        try (FileWriter fileWriter = new FileWriter(dosya, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            String satir = childName + "," + trueAnswer + "," + wrongAnswer + "," + totalTime;
            bufferedWriter.write(satir);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
