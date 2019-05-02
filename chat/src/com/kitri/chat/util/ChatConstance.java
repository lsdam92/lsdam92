package com.kitri.chat.util;

public class ChatConstance {

	public static final int PORT = 9876;
	
//	protocol 정의
//	client  >> server
//	접속				100 | 대화명
//	모든사람메세지		200|메세지
//	특정사람메세지		250| 대상자|메세지
//	쪽지보내기			300|대상자|메세지
//	대화명변경			400|변경할대화명
//	접속종료			900|
	
	public static final int CS_CONNECT = 100;
	public static final int CS_ALL = 200;
	public static final int CS_TO = 250;
	public static final int CS_PAPER = 300;
	public static final int CS_RENAME = 400;
	public static final int CS_DISCONNECT = 900;

	
//	server  >> client
	
//	server  >> client
//	접속				100|접속자대화명
//	모든사람메세지(전체)	200|[보낸시점대화명]메세지
//	특정사람메세지(특정)	200|☆보낸사람 대화명|메세지		
//	쪽지보내기			300|보낸사람대화명|메세지
//	대화명변경			400|변경전대화명|변경할대화명
//	접속종료			900|접속장대화명
	public static final int SC_CONNECT = 100;
	public static final int SC_MESSAGE = 200;
	public static final int SC_PAPER = 300;
	public static final int SC_RENAME = 400;
	public static final int SC_DICONNECT = 900;
	
//	☆이소담☆안녕하세요.
	
//	client  >> server
}
