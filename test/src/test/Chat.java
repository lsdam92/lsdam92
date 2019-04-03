package test;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField whomsend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
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
	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(10, 10));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.setBackground(Color.magenta);
		panel.setBackground(Color.magenta);
		panel.setLayout(new BorderLayout(10, 20));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(20, 10));
		panel_1.setBackground(Color.magenta);
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(3, 1, 5, 5));
		panel_3.setBackground(Color.magenta);
		
		JButton rename = new JButton("\uB300\uD654\uBA85\uBCC0\uACBD");
		panel_3.add(rename);
		
		JButton paper = new JButton("\uCABD\uC9C0\uBCF4\uB0B4\uAE30");
		panel_3.add(paper);
		
		JButton close = new JButton("\uB098 \uAC00 \uAE30");
		panel_3.add(close);
		
		JList list = new JList();
		panel_1.add(list, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(5, 10));
		panel_2.setBackground(Color.magenta);
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(2, 1, 10, 10));
		panel_4.setBackground(Color.magenta);
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BorderLayout(20, 50));
		
		textField_1 = new JTextField();
		panel_5.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(20, 20));
		
		
		JLabel whom = new JLabel("\uADD3\uC18D\uB9D0");
		panel_6.add(whom, BorderLayout.WEST);
		
		whomsend = new JTextField();
		panel_6.add(whomsend, BorderLayout.CENTER);
		whomsend.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		panel_2.add(textArea, BorderLayout.CENTER);
	}

}
