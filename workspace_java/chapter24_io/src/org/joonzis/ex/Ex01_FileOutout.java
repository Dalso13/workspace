package org.joonzis.ex;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01_FileOutout {
	public static void main(String[] args) {
		
		
		// 바이트 기반 스트림
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			/*	FileOutputStream (생성한 파일의 경로 및 파일 이름)
			 * 	-	경로 지정을 안하면 현재 디렉토리에 파일 생성(상대 경로)
			 * 	-ex) c:/file/alphabet.txt(절대 경로).
			 */
			
			fos = new FileOutputStream("alphabet.txt");
			bos = new BufferedOutputStream(fos);
			
			char ch = 'A';		// 아스키 코드 시작 문자
			while (true) {
				bos.write(ch);
				if(ch == 'z')	// 아스키 코드 종료 문자
					break;
				ch++; 	// 아스키 코드표 상 다음 문자로 증가
			}
			
			bos.flush();	// 버퍼 비워주기
			
			System.out.println("alphabet.txt 파일 생성!");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	finally {
			// 버퍼를 사용한 클래스는 finally 에서 close() 를 통해 메모리 관리를 효과적으로 할 수 있다.
			
			try {
				// 선행 생성된 역순으로 닫아준다.
				if (bos != null) {
					bos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				
			}
			
		}
		
		
		
	}
}	
