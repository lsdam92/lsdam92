package test;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class View1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public View1() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\uC120\uD0DD\uC0AD\uC81C");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC800\uC7A5");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uCD94\uAC00");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uC804\uCCB4\uC0AD\uC81C");
		panel.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);

	}

}
