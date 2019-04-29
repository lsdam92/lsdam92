package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Paper extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paper frame = new Paper();
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
	public Paper() {
		super("쪽지보내기~~~");
		JPanel p1 = new JPanel();
		p1.setBounds(5, 5, 424, 36);
		JPanel p15 = new JPanel();
		JLabel from = new JLabel("From :");
		JLabel from2 = new JLabel("from");
		JPanel p16 = new JPanel();
		JLabel to = new JLabel("T o :" );
		JPanel p2 = new JPanel();
		p2.setBounds(5, 20, 424, 214);
		JTextArea letter = new JTextArea();
		letter.setBounds(0, 21, 424, 193);
		JPanel p3 = new JPanel();
		p3.setBounds(5, 234, 424, 23);
		JPanel p31 = new JPanel();
		JButton send = new JButton("\uBCF4\uB0B4\uAE30");
		JButton send2 = new JButton("\uCDE8 \uC18C");
		JPanel p32 = new JPanel();
		JButton button = new JButton("\uB2F5 \uBCC0");
		JButton button_1 = new JButton("\uCDE8 \uC18C");
		JLabel to2 = new JLabel("to");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.yellow);
		contentPane.setLayout(null);
		contentPane.add(p1);
		
		p1.setLayout(new GridLayout(1, 2, 20, 20));
		p1.add(p15);
		p1.setBackground(Color.yellow);
		p1.add(p16);
		
		p15.setLayout(new BorderLayout(20, 20));
		p15.add(from, BorderLayout.WEST);
		p15.add(from2, BorderLayout.CENTER);
		p15.setBackground(Color.yellow);
		
		p16.setLayout(new BorderLayout(20, 20));
		p16.add(to, BorderLayout.WEST);
		p16.setBackground(Color.yellow);
		p16.add(to2, BorderLayout.CENTER);
		
		from2.setOpaque(true);
		from2.setBackground(new Color(255, 102, 0));;
		from2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		to2.setHorizontalAlignment(SwingConstants.CENTER);
		to2.setOpaque(true);
		to2.setBackground(new Color(255, 102, 0));
		
		contentPane.add(p2);
		
		p3.add(p32, "name_24726848341566");
		p2.setLayout(null);
		p2.add(letter);
		p3.setLayout(new CardLayout(0, 0));
		p3.add(p31, "name_24723827392647");
		
		
		contentPane.add(p3);
		p31.add(new Label(""));
		p31.add(send);
		p31.add(send2);
		p31.setLayout(new GridLayout(1, 4, 10, 0));
		p31.add(new Label(""));
		p31.setBackground(Color.yellow);
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		p32.setBackground(Color.yellow);
		p32.setLayout(new GridLayout(1, 4, 10, 0));
		p32.add(new JLabel(""));
		p32.add(button);
		p32.add(button_1);
		p32.add(new JLabel(""));
		
		
		
		
		
	}

}
