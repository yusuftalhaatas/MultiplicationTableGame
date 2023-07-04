import java.awt.EventQueue;

import javax.management.loading.PrivateClassLoader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField numberQuestionField;
	private JTextField childNameField;
	Admin admin;
	Exam exam;
	private JTextField aField;
	private JTextField bField;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AdminPage(String adminName) {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("AdminPage");
		
		admin=new Admin(adminName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		numberQuestionField = new JTextField();
		numberQuestionField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		numberQuestionField.setBounds(243, 30, 76, 41);
		contentPane.add(numberQuestionField);
		numberQuestionField.setColumns(10);
		
		JLabel questionLbl = new JLabel("Enter number of questions");
		questionLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		questionLbl.setBounds(19, 42, 212, 16);
		contentPane.add(questionLbl);
		
		JLabel lblNewLabel = new JLabel("Enter name of the child");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(19, 220, 212, 16);
		contentPane.add(lblNewLabel);
		
		childNameField = new JTextField();
		childNameField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		childNameField.setBounds(210, 211, 110, 34);
		contentPane.add(childNameField);
		childNameField.setColumns(10);
		
		JButton childNameBtn = new JButton("Add");
		childNameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Child child =new Child(childNameField.getText());
				admin.addChild(child);
			}
		});
		childNameBtn.setBounds(331, 210, 92, 41);
		contentPane.add(childNameBtn);
		
		JButton finishBtn = new JButton("Finish");
		finishBtn.setForeground(UIManager.getColor("Button.light"));
		finishBtn.setBackground(new Color(8, 74, 217));
		finishBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    final int numberQuestion=Integer.parseInt(numberQuestionField.getText());
			    final int a=Integer.parseInt(aField.getText());
			    final int b=Integer.parseInt(bField.getText());
				admin.saveToFile();
				exam=new Exam(numberQuestion,a,b);
				exam.testSaveToFile();
				Login login =new Login();
				login.setVisible(true);
				dispose();
			}
		});
		finishBtn.setBounds(343, 263, 117, 50);
		contentPane.add(finishBtn);
		
		JLabel nameLbl= new JLabel("Welcome "+adminName);
		nameLbl.setBounds(19, 6, 137, 16);
		contentPane.add(nameLbl);
		
		JLabel lblEnterAb = new JLabel("Enter a-b");
		lblEnterAb.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblEnterAb.setBounds(19, 134, 212, 16);
		contentPane.add(lblEnterAb);
		
		aField = new JTextField();
		aField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		aField.setColumns(10);
		aField.setBounds(155, 114, 76, 41);
		contentPane.add(aField);
		
		bField = new JTextField();
		bField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		bField.setColumns(10);
		bField.setBounds(243, 114, 76, 41);
		contentPane.add(bField);
	}
	
	
}
