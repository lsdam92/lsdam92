package com.kitri.chat.client;

import java.awt.event.*;import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import com.kitri.chat.util.ChatConstance;

public class Login extends JFrame implements ActionListener,ListSelectionListener, Runnable{
	Socket socket;
	String myid;
	BufferedReader in;
	OutputStream out;
	
	JLabel ip;
	JLabel name;
	JTextField ipTf;
	JTextField nameTf;
	JButton cancel;
	JButton ok;
	
	Chat chat;
	Paper paper;
	Rename rename;

	public Login() {
		super("Login!!");
		initGUI();
		
		chat = new Chat();
		paper = new Paper();
		rename = new Rename();
	
		
//		login창 event 등록
		nameTf.addActionListener(this);
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
//		Chat창 event 등록
		chat.globalsend.addActionListener(this);
		chat.whomsend.addActionListener(this);
		chat.paper.addActionListener(this);
		chat.rename.addActionListener(this);
		chat.exit.addActionListener(this);
		chat.list.addListSelectionListener(this);
		chat.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				closeProcess();
			}
		});
		
//		Paper창 event등록
		paper.answer.addActionListener(this);
		paper.ok.addActionListener(this);
		paper.cancel.addActionListener(this);
		 
		
		
//		Rename창 event 등록
		
		rename.ok.addActionListener(this);
		rename.cancel.addActionListener(this);
		rename.newname.addActionListener(this);
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			getContentPane().setBackground(new java.awt.Color(244,243,242));
			{
				ip = new JLabel();
				getContentPane().add(ip);
				ip.setText("\uc544\uc774\ud53c");
				ip.setBounds(12, 12, 60, 30);
				ip.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				ip.setFocusable(false);
				ip.setRequestFocusEnabled(false);
				ip.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				name = new JLabel();
				getContentPane().add(name);
				name.setText("\ub300\ud654\uba85");
				name.setBounds(12, 47, 60, 30);
				name.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
				name.setFocusable(false);
				name.setRequestFocusEnabled(false);
				name.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				ipTf = new JTextField();
				getContentPane().add(ipTf);
				ipTf.setBounds(78, 12, 209, 30);
			}
			{
				nameTf = new JTextField();
				getContentPane().add(nameTf);
				nameTf.setBounds(78, 47, 209, 30);
			}
			{
				ok = new JButton();
				getContentPane().add(ok);
				ok.setText("\ub85c\uadf8\uc778");
				ok.setBounds(83, 83, 61, 32);
				ok.setBackground(new java.awt.Color(237,236,233));
				ok.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			{
				cancel = new JButton();
				getContentPane().add(cancel);
				cancel.setText("\ucde8 \uc18c");
				cancel.setBounds(153, 83, 59, 32);
				cancel.setBackground(new java.awt.Color(237,236,233));
				cancel.setBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false));
			}
			pack();
			this.setSize(303, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login inst = new Login();
				inst.setLocationRelativeTo(null);
				inst.setResizable(false);
				inst.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == nameTf || ob == ok) {
			connectProcess();
		}else if(ob == cancel) {
			System.exit(0);
		}else if(ob == chat.globalsend) {
			globalsendProcess();
		}else if(ob == chat.whomsend) {
			whomsendProcess();
		}else if(ob == chat.paper) {
			paperProcess();
		}else if(ob == chat.rename) {
			rename.oldname.setText(myid);
			rename.setVisible(true);
		}else if(ob == chat.exit) {
			closeProcess();
		}else if(ob == paper.answer) {
			answerProcess();
		}else if(ob == paper.cancel) {
			paper.setVisible(false);
		}else if(ob == paper.ok) {
			okProcess();
		}else if(ob == rename.cancel) {
			rename.setVisible(false);
		}else if(ob == rename.newname || ob ==rename.ok) {
			renameProcess();
		}
		
	}




	
	private void renameProcess() {
		
		String newname = rename.newname.getText().trim();
		if(newname.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "공백 입니다", "공백오류" , JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		sendMessage(ChatConstance.CS_RENAME + "|"+ newname);
		myid = newname;
		rename.newname.setText("");

		rename.setVisible(false);
	}

	private void paperProcess() {
//		String selName = chat.list.getSelectedValue();
		
		paper.card.show(paper.cardp, "ok");
		paper.from.setText(myid);
		paper.to.setText(chat.whom.getText());
		paper.letter.setText("");
		paper.setVisible(true);
		
	}

	private void okProcess() {
		String msg = paper.letter.getText().trim();
		paper.letter.setText("");
		if(msg.isEmpty()) {
			return;
	}
		String to = paper.to.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요." , "대상자오류" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(to.contentEquals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 쪽지?." , "대상자오류" , JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		sendMessage(ChatConstance.CS_PAPER + "|"+ to + "|" + msg);
		paper.from.setText(to);
		
		
		paper.setVisible(false);
	}


	private void answerProcess() {
//		String msg = paper.letter.getText().trim();
//		String selName = chat.list.getSelectedValue();
		paper.to.setText(paper.from.getText());
		paper.from.setText(myid);
		paper.letter.setText("");
		paper.card.show(paper.cardp, "ok");
//		if(msg.isEmpty()) {
//			return;
//	}
//		sendMessage(ChatConstance.CS_PAPER + "|"+ selName + "|" + msg);
	
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		String selName = chat.list.getSelectedValue();
		chat.whom.setText(selName);
		
	
	}

	
	private void closeProcess() {
		sendMessage(ChatConstance.CS_DISCONNECT + "|");
		
	}

//	1. 메세지 get(유효성검사 대상자, 자신 , 메세지)
//	2. server로 메세지 전송.
	private void whomsendProcess() {
		String msg = chat.whomsend.getText().trim();
		chat.whomsend.setText("");
		if(msg.isEmpty()) {
			return;
		}
		String to = chat.whom.getText();
		if(to.isEmpty()) {
			JOptionPane.showMessageDialog(chat, "대상자를 선택하세요." , "대상자오류" , JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(to.contentEquals(myid)) {
			JOptionPane.showMessageDialog(chat, "자신에게 귓속말?." , "대상자오류" , JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		sendMessage(ChatConstance.CS_TO + "|"+ to + "|" + msg);
		viewMessage("★" + to + "★" + msg);
	}
	
//	1. 메세지 get(유효성검사)
//	2. server로 메세지 전송.
private void globalsendProcess() {
		String msg = chat.globalsend.getText().trim();
		chat.globalsend.setText("");
		if(msg.isEmpty()) {
			return;
		}
		sendMessage(ChatConstance.CS_ALL + "|" + msg);
	}

//	1.ip, 대화명 get(유효성검사(대화명3글자.)
//	2. 1의 ip를 이용해서 Socket생성.
//	3. IO(bufferedReader, OutputStream) 생성.
//	4. login창 닫고, chat창 열기.
//	5. server로 메세지 전송.
//	6. Thread 생성.
	private void connectProcess() {
		String ip = ipTf.getText().trim();
		myid = nameTf.getText().trim();
		if(myid.length() < 3) {
			JOptionPane.showMessageDialog(this, "대화명은 3자리 이상입니다.", "대화명오류" , JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			socket = new Socket(ip, ChatConstance.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = socket.getOutputStream();
			this.setVisible(false);
			chat.setVisible(true);
			sendMessage(ChatConstance.CS_CONNECT + "|" + myid);	//\n을 반드시보내야 한다
			new Thread(this).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMessage(String msg) {
		try {
			out.write((msg + "\n").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public void run() {
		boolean flag = true;
		while(flag) {
			try {
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지 : " + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch(protocol) {
					case ChatConstance.SC_CONNECT : {
//						100|접속자대화명
						String tmp = st.nextToken();
						viewMessage("[알림] " + tmp + "님이 접속하였습니다. \n");
						
						chat.listData.add(tmp);
						chat.list.setListData(chat.listData);
					}break;
					case ChatConstance.SC_MESSAGE : {
//						200|[안효인]안녕하세요.
//						200|☆홍길동☆|안녕?
						String tmp = st.nextToken();
						viewMessage(tmp);
						chat.listData.add(tmp);
						chat.list.setListData(chat.listData);
						
											
					}break;
					case ChatConstance.SC_PAPER : {
						
						String from = st.nextToken();
						String tmp = st.nextToken();
						
						viewPaper(from,tmp);
					
						
					}break;
					case ChatConstance.SC_RENAME : {
						
						String to = st.nextToken();
						String temp = st.nextToken();
						chat.listData.setElementAt(temp, chat.listData.indexOf(to));
						chat.list.setListData(chat.listData);
						viewMessage("[알림]" + to + "님이" + temp + "님으로 대화명 변경.");
						
						
						
					}break;
					
					case ChatConstance.SC_DICONNECT : {
//						900|나가는사람
						String tmp = st.nextToken();	//나가는사람 대화명
						if(!tmp.equals(myid)) {
							viewMessage("[알림]" + tmp + "님이 접속을 종료하였습니다.");
							chat.listData.remove(tmp);	//lsit에서 지우고
							chat.list.setListData(chat.listData);	//list에 적용
						}else {
							flag = false;
							in.close();
							out.close();
							socket.close();
//							chat.setVisible(false);
							System.exit(0);
						}
					}break;
					}
				}catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
				
	}
	
	private void viewMessage(String msg) {
		chat.area.append(msg+"\n");
		chat.area.setCaretPosition(chat.area.getDocument().getLength());
	}
	private void viewPaper(String from,String tmp) {
		

		paper.card.show(paper.cardp, "answer");
		paper.from.setText(from);
		paper.to.setText(myid);
		paper.letter.setText(tmp);
		paper.setVisible(true);

		
	}

	}

