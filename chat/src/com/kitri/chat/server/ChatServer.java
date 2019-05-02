package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;

public class ChatServer implements Runnable {

	ServerSocket ss;
	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>(); // ChatClient �� �ᵵ�ȴ�

	public ChatServer() {
		try {
			ss = new ServerSocket(ChatConstance.PORT); // ChatConstance ��� class final ����� �����Ͽ� �־��ش�.
			System.out.println("Ŭ���̾�Ʈ ���� �����.....");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override // ����ó����
	public void run() {
		while (true) {
			try {
				Socket socket = ss.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ���� : " + socket);
				new ChatClient(socket).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class ChatClient extends Thread {

		String name;
		BufferedReader in;
		OutputStream out;
		Socket socket;

		public ChatClient(Socket socket) {
			try {
				this.socket = socket;
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override // run methodó�� �޼���ó��
		public void run() {
			boolean flag = true;
			while (flag) {
				try {
					String msg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : " + msg);
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					switch (protocol) {
					case ChatConstance.CS_CONNECT: {
//							100|��ȿ��
						name = st.nextToken();// ��ȿ��
//							int size = list.size();
//							for (int i = 0; i < size; i++) {
//								ChatClient cc = list.get(i);
//							}
						multicast(ChatConstance.SC_CONNECT + "|" + name); // ���� �����Ѹ�������� ������

						list.add(this); // list�� �������� �ڽ�����
						for (ChatClient cc : list) {
							unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
						}
					}
						break;
					case ChatConstance.CS_ALL: {
//							200|�ȳ��ϼ���.
						String tmp = st.nextToken();
						multicast(ChatConstance.SC_MESSAGE + "|[" + name + "]" + tmp);
					}
						break;
					case ChatConstance.CS_TO: {
//							250|ȫ�浿|�ȳ�?
						String to = st.nextToken(); // ȫ�浿
						String tmp = st.nextToken(); // �ȳ�?
						for (ChatClient cc : list) {
							if (cc.name.contentEquals(to)) {
								cc.unicast(ChatConstance.SC_MESSAGE + "|��" + name + "��" + tmp);
								break;
							}
						}
					}
						break;
					case ChatConstance.CS_PAPER: {
						String to = st.nextToken(); // ȫ�浿
						String tmp = st.nextToken(); // �ȳ�?
						
						for (ChatClient cc : list) {
							if (cc.name.contentEquals(to)) {
								cc.unicast(ChatConstance.SC_PAPER + "|" +name +"|"+ tmp);
								break;
							}
						}
					}
						break;
					case ChatConstance.CS_RENAME: {
						String newname = st.nextToken();	 //��ȭ��
						
						multicast(ChatConstance.SC_RENAME + "|" + name + "|" +newname);
						name = newname;
						
					}
						break;
					case ChatConstance.CS_DISCONNECT: {
//						900|
						multicast(ChatConstance.SC_DICONNECT + "|" + name);
						list.remove(this);
						flag = false;
						in.close();
						out.close();
						socket.close();

					}
						break;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		private void multicast(String msg) {
			for (ChatClient cc : list) {
				cc.unicast(msg);
			}
		}

		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//			ChatServer cs = new ChatServer();
//			Thread t = new Thread(cs);
//			t.start();
		new Thread(new ChatServer()).start();
	}

}
