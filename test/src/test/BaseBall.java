package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public class BaseBall extends JFrame {

	private JPanel contentPane;
	private JTextField tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseBall frame = new BaseBall();
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
	public BaseBall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC785\uB825");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 419, 57, 34);
		contentPane.add(lblNewLabel);
		
		tf = new JTextField();
		tf.setBounds(76, 419, 283, 34);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(365, 10, 108, 443);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(5, 1, 0, 10));
		
		JButton newG = new JButton("\uC0C8\uAC8C\uC784");
		newG.setBorder(new TitledBorder(null, "new", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		newG.setBackground(Color.CYAN);
		panel.add(newG);
		
		JButton clear = new JButton("\uC9C0\uC6B0\uAE30");
		panel.add(clear);
		
		JButton dap = new JButton("\uC815\uB2F5");
		panel.add(dap);
		
		JButton fontC = new JButton("\uAE00\uC790\uC0C9");
		panel.add(fontC);
		
		JButton exit = new JButton("\uC885\uB8CC");
		panel.add(exit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 345, 402);
		contentPane.add(scrollPane);
		
		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
	}
}
