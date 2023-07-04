import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField admin;
	private JTextField child;
	private JOptionPane alertJOptionPane;

	 Admin savedAdmin = null;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Login() {
		
	        try {
	            savedAdmin = loadFromFile();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 52, 468, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		
		admin = new JTextField();
		admin.setBounds(149, 64, 155, 52);
		panel.add(admin);
		admin.setColumns(10);
		
		child = new JTextField();
		child.setColumns(10);
		child.setBounds(149, 142, 155, 52);
		panel.add(child);
		
		JButton adminBtn = new JButton("Admin Enter");
		adminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    AdminPage adminPage=new AdminPage(admin.getText());
			    adminPage.setVisible(true);
				dispose();
			}
		});
		adminBtn.setBounds(316, 68, 117, 47);
		panel.add(adminBtn);
		
		JButton childbtn = new JButton("Child Enter");
		childbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(savedAdmin.checkChild(child.getText())) {
					 ChildPage childPage=new ChildPage(child.getText());
					 childPage.setVisible(true);
					 System.out.println(savedAdmin.getName()+"'s Child "+ child.getText());
					 dispose();
				 }
				 else {
					 alertJOptionPane.showMessageDialog(panel, "Not fount child");

				}
			}
		});
		childbtn.setBounds(316, 146, 117, 47);
		panel.add(childbtn);
		
		JButton resultBtn = new JButton("See Results");
		resultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChildResultsPage childResultsPage=new ChildResultsPage();
				childResultsPage.setVisible(true);
				
			}
		});
		resultBtn.setBackground(new Color(238, 238, 238));
		resultBtn.setForeground(new Color(36, 48, 124));
		resultBtn.setBounds(72, 252, 117, 47);
		panel.add(resultBtn);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setBounds(39, 64, 89, 52);
		panel.add(lblNewLabel);
		
		JLabel lblChildName = new JLabel("Child Name");
		lblChildName.setBounds(39, 142, 89, 52);
		panel.add(lblChildName);
	}
	
	public static Admin loadFromFile() {
        Admin admin = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("admin.txt"))) {
            String name = reader.readLine();
            int childCount = Integer.parseInt(reader.readLine());
            admin = new Admin(name);
            for (int i = 0; i < childCount; i++) {
                String childName = reader.readLine();
                Child child = new Child(childName);
                admin.addChild(child);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
	
}
