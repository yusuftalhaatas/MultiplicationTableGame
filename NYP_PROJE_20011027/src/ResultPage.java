import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ResultPage extends JFrame {

	private JPanel contentPane;

	
	public ResultPage(int wrongAnswer,int correctAnswer,int totalTime) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel timeLbl = new JLabel("Total Time: "+totalTime);
		timeLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		timeLbl.setBounds(45, 49, 198, 34);
		contentPane.add(timeLbl);
		
		JLabel trueAnswerLbl = new JLabel("Correct Answer: "+correctAnswer);
		trueAnswerLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		trueAnswerLbl.setBounds(45, 114, 198, 34);
		contentPane.add(trueAnswerLbl);
		
		JButton okBtn = new JButton("OK");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okBtn.setBounds(282, 241, 117, 43);
		contentPane.add(okBtn);
		
		JLabel lblWrongAnswer = new JLabel("Wrong Answer: "+wrongAnswer);
		lblWrongAnswer.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblWrongAnswer.setBounds(45, 180, 198, 34);
		contentPane.add(lblWrongAnswer);
		
		JLabel lblNewLabel = new JLabel("You Finished The Test");
		lblNewLabel.setForeground(new Color(90, 243, 87));
		lblNewLabel.setBackground(new Color(90, 243, 87));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 21, 248, 16);
		contentPane.add(lblNewLabel);
	}
}
