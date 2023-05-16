package org.joonzis.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex05_FileCopy {
	public static void main(String[] args)	throws IOException {// try 캐치 대용	좋은 방법은 아님
		
		
//		FileInputStream fis = new FileInputStream("alphabet.txt");
//		BufferedInputStream bis = new BufferedInputStream(fis);
		// 위와 동일		
		BufferedInputStream bis =	new BufferedInputStream(new FileInputStream("alphabet.txt"));
			
		
//		FileOutputStream fos = new FileOutputStream("alphabet2.txt");
//		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// 위와 동일 (필드 하나 만드는 과정 생략
		BufferedOutputStream bos =	new BufferedOutputStream(new FileOutputStream("alphabet2.txt"));
		
		int data;
		while ((data = bis.read()) != -1) {	// data에 bis.read 를 해주고 그 값이 -1 (아무것도 안들어감) 이 아니면 
			bos.write(data);			// bos.write(data) 해줌
		}
		bis.close();
		bos.close();
	}
}
