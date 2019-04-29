package com.kitri.io;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NotePadFrame extends JFrame implements ActionListener {

	private JPanel contentPane;

//	NotePad notePad;

	private JMenuBar mb;
	private JMenu file;
	private JMenuItem open;
	private JMenuItem save;
	private JMenu help;
	private JTextArea editor;
	private JMenuItem exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotePadFrame frame = new NotePadFrame();
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
	public NotePadFrame() {
		super("NotePad");
		mb = new JMenuBar();
		file = new JMenu("\uD30C \uC77C");
		open = new JMenuItem("\uC5F4\uAE30");
		save = new JMenuItem("\uC800\uC7A5");
		help = new JMenu("\uB3C4\uC6C0\uB9D0");
		editor = new JTextArea();
		exit = new JMenuItem("\uB2EB\uAE30");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(mb);

		file.setHorizontalAlignment(SwingConstants.CENTER);
		file.add(open);
		file.add(save);
		file.add(exit);

		mb.add(file);
		mb.add(help);
		open.setHorizontalAlignment(SwingConstants.CENTER);
		save.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		help.setHorizontalAlignment(SwingConstants.CENTER);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(editor, BorderLayout.CENTER);

		file.addActionListener(this);
		exit.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);
		help.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == open) {
			JFileChooser jfc = new JFileChooser();
			jfc.showOpenDialog(this);
			BufferedReader fin = null;
			File file = jfc.getSelectedFile();
			if(file != null) {
				String infile = file.getPath();
				try {
					fin = new BufferedReader(new InputStreamReader(new FileInputStream(new File(infile))));
					editor.setText("");
					String str = null;
					while((str = fin.readLine()) != null) {
						editor.append(str + "\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}finally {
					try {
						fin.close();
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}
				}
			}

	}else if(ob == save) {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File("f:\\javadata\\javasource"));
		jfc.showSaveDialog(this);
		
		String data = editor.getText();
		System.out.println(data);
		FileWriter fw = null;
		File file = jfc.getSelectedFile();
		String outfile = file.getPath();
		try {
			fw = new FileWriter(new File(outfile));
			fw.write(data.replace("\n", "\r\n"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				if(fw != null)
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
}