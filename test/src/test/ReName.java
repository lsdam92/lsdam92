package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.paint.Color;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReName extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReName frame = new ReName();
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
	public ReName() {
		super("대화명 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new java.awt.Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(153, 153, 204));
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(20, 20));
		
		JLabel old = new JLabel("     Old Name :  ");
		old.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(old, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("oldname");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(153, 153, 204));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(20, 20));
		
		JLabel neww = new JLabel("     New Name :");
		panel_1.add(neww, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new java.awt.Color(153, 153, 204));
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new java.awt.Color(153, 153, 204));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2,10,0));
		
		JButton btnNewButton = new JButton("\uBCC0\uACBD");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		panel_3.add(btnNewButton_1);
	}

}
