package org.joonzis.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex06_FileCopy {
	public static void main(String[] args) throws IOException{
		
		File file = new File("300px-Anas_platyrhynchos_LC0014.jpg");
		
		if (file.exists()) {
			BufferedInputStream bis =
					new BufferedInputStream(new FileInputStream(file));
			
			
			// 복사본 생성
			BufferedOutputStream bos =
					new BufferedOutputStream(new FileOutputStream("01px-Anas_platyrhynchos_LC0014.jpg"));
			
			byte[] buffer = new byte[1024];
			
			long start = System.currentTimeMillis();
			while ((bis.read(buffer)) != -1) {
				bos.write(buffer);
			}
			long end = System.currentTimeMillis();
			System.out.println("복사 시간 : " + (end-start) + "밀리초");
			
			// File 클래스 사용으로 인한 사용 가능한 메소드
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일경로1 : " + file.getAbsolutePath());	// 절대 경로
			System.out.println("파일경로2 : " + file.getPath());			// 상대 경로
			
			bos.close();
			bis.close();
			
		}
	}
}
