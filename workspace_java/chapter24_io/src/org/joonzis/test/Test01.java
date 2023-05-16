package org.joonzis.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Test01 {
	public static void main(String[] args) {
		
		// 입력
		FileInputStream fis = null;
		BufferedInputStream bis = null;
	
		// 출력
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		// 콘솔로 출력
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			file = new File("nationalAnthem.txt");
			
			// 파일 복사 붙여넣기
			
			fis = new FileInputStream("nationalAnthem.txt");
			bis = new BufferedInputStream(fis);
			
			fos = new FileOutputStream("nationalAnthem3.txt");
			bos = new BufferedOutputStream(fos);
			
			
			
			
//			 파일 읽기
			fr = new FileReader(file);
			br = new BufferedReader(fr);	
			String str = "" ;
			
			int data2;
			
//			 파일 복사 붙여넣기
			while ((data2 = bis.read()) != -1) {
				bos.write(data2);
			}
//			 파일 출력
			while (true) {
				str = br.readLine();
				if (str != null) {
					System.out.println(str);
				} else {
					break;
				}
				
			}
			
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
}
