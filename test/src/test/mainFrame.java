package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class mainFrame extends JFrame implements ActionListener{
	private JButton b1;
	private JButton b2;
	
	
	View1 v1 = new View1(); 
	View2 v2 = new View2(); 
	
	CardLayout card = new CardLayout();
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
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
	public mainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 546, 543);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(card);
		panel.add("view1", v1);
		panel.add("view2", v2);
		card.show(panel, "view1");
	
		panel.setBounds(12, 63, 500, 430);
		contentPane.add(panel);
		
		b1 = new JButton("\uD654\uBA741");
		b1.setBounds(12, 10, 109, 43);
		contentPane.add(b1);
		
		b2 = new JButton("\uD654\uBA742");
		b2.setBounds(133, 10, 109, 43);
		contentPane.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == b1) {
			card.show(panel, "view1");
		}else if(ob == b2){
			card.show(panel, "view2");
		}
	}

}
