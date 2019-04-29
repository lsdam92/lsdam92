package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;

public class Login extends JFrame {
	private JTextField ipTF;
	private JTextField nameTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("Login!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel p1 = new JPanel();
		panel.add(p1);
		p1.setLayout(null);
		p1.setBackground(Color.white);
		
		JLabel label1 = new JLabel(" I      P  :");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(12, 10, 89, 34);
		p1.add(label1);
		
		ipTF = new JTextField();
		ipTF.setBounds(113, 10, 159, 34);
		p1.add(ipTF);
		ipTF.setColumns(10);
		
		JPanel p2 = new JPanel();
		panel.add(p2);
		p2.setLayout(null);
		p2.setBackground(Color.white);
		
		JLabel label2 = new JLabel("\uB300 \uD654 \uBA85 :");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(12, 10, 89, 34);
		p2.add(label2);
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		nameTF.setBounds(113, 10, 159, 34);
		p2.add(nameTF);
		
		JPanel p3 = new JPanel();
		panel.add(p3);
		p3.setLayout(null);
		p3.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 260, 34);
		p3.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		
		JButton ok = new JButton("\uD655\uC778");
		ok.setBounds(44, 0, 70, 34);
		panel_1.add(ok);
		ok.setBackground(Color.white);
		
		JButton cancel = new JButton("\uCDE8\uC18C");
		cancel.setBounds(134, 0, 70, 34);
		panel_1.add(cancel);
		cancel.setBackground(Color.white);
		setBackground(Color.white);
	}
}
