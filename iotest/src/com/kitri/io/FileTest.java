package com.kitri.io;

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		try {
			File infile = new File("f:\\iotest\\hello.txt");
			in = new FileInputStream(infile);
			long length = infile.length();
			byte b[] = new byte[(int) length];
			int x = in.read(b);
			String str = new String(b, 0, x);
			System.out.println(x + "bytes read!!!");
			System.out.println(str);

//			파일에 write한다
			File outfile = new File("f:\\iotest\\hello_copy.txt");
			out = new FileOutputStream(outfile);
			out.write(b);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 파일안의 텍스트를 가져옴
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close();
				if(out != null)
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
