package org.joonzis.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test2_1 {
	public static void main(String[] args) {
		
		
		// test1 파일에서 인풋 스트림 객체로 출력과 복붙을 동시에 하려했지만
		// 인풋 스트림 객체 하나로 동시에 쓰는게 불가능하기에 
		// 인풋 스트림 객체를 또 정의해서 두개의 인풋 스트림을 활용하는것 말고는 방법이 없었음
		
		
		
		
		FileInputStream fis1 = null;
		BufferedInputStream bis1 = null;
		
		InputStreamReader in = null;	// 인풋 스트림을 출력하기위한 도구
	
		
		FileOutputStream fos1 = null;
		BufferedOutputStream bos1 = null;
		
		try {
			
			// 파일 복사 붙여넣기
			fis1 = new FileInputStream("nationalAnthem.txt");
			bis1 = new BufferedInputStream(fis1);
			
			// 위와 같은 객체 새롭게 정의
			
			FileInputStream fis2 = new FileInputStream("nationalAnthem.txt");
			BufferedInputStream bis2 = new BufferedInputStream(fis2);
			
			in = new InputStreamReader(bis2 , "UTF-8");	// 파일 내용에 utf-8 인코딩을 불러온다
			
			fos1 = new FileOutputStream("nationalAnthem2.txt");
			bos1 = new BufferedOutputStream(fos1);
			
			
			int data;	// 출력을 위한 int
			int data1;
			
//			 파일 복사 붙여넣기
			
			while ((data1 = bis1.read()) != -1) {
				bos1.write(data1);
			}
			
			// FileInputStream 활용해서 한글 파일 출력
			
			while((data = in.read()) != -1) {		// 위랑 다르게 인코딩한 in 객체를 읽게 시킨다.
				System.out.print((char)data);	// ln을 안빼주면 한글자씩 출력
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (bos1 != null) {
					bos1.close();
				}
				if (fos1 != null) {
					fos1.close();
				}
				if (bis1 != null) {
					bis1.close();
				}
				if (fis1 != null) {
					fis1.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}
