 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class ChildPage extends JFrame {

	private JPanel contentPane;
    Child child ;
    QuestionPage questionPage;
    private List<Question> test;
    private Question question;
    private int number1,number2;
    private int questionNum;
	
    
    
    
	public ChildPage(String childName) {
		  test=new ArrayList<Question>();
		   try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
	            questionNum = Integer.parseInt(reader.readLine());
	            System.out.println("Number of questions-"+questionNum);
	            for (int i = 0; i <questionNum; i++) {
	                 number1=Integer.parseInt(reader.readLine());
	                 number2=Integer.parseInt(reader.readLine());
	                 System.out.println(i+1+"-question "+"A-"+number1+" B- "+number2);
	                 question=new Question(number1,number2);
	                 test.add(question);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		child=new Child(childName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton startBtn = new JButton("Start");
		startBtn.setForeground(new Color(83, 84, 255));
		startBtn.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionPage=new QuestionPage(childName);
                questionPage.setVisible(true);
                
			}
		});
		startBtn.setBounds(164, 117, 117, 29);
		contentPane.add(startBtn);
		
		JLabel pressLbl = new JLabel("Press Button For Start");
		pressLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pressLbl.setBounds(125, 84, 214, 20);
		contentPane.add(pressLbl);
		
		JLabel nameLbl = new JLabel("Welcome "+childName);
		nameLbl.setBounds(30, 18, 130, 16);
		contentPane.add(nameLbl);
	}
}
