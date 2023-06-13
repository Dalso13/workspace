package org.joonzis.model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download {
	public void download(HttpServletRequest request, HttpServletResponse response, String filename, String path) {
		
		// 다운로드 받을 파일의 실제 경로 구하기
		String realPath = request.getServletContext().getRealPath("/" + path);
		
		// 다운로드 받을 수 있는 문서 타입으로 설정하기
		response.setContentType("application/x-msdownload");
		
		// 파일 클래스(파일 스트림)를 통해 다운로드 할 파일 연결하기
		File file = new File(realPath + "/" + filename); 	// new File(경로 + 파일명)
		
		// 파일 이름에 공백이 있을 경우 "+" 로 출력되는 부분 수정
		filename = filename.replaceAll("\\+", "%20");
		
		// 클라이언트의 헤더 정보에 첨푸파일이 있음을 처리
		response.setHeader("Content-Disposition", "attachment; filename=" + filename + ";");
		response.setHeader("Content-Length", file.length() + "");
		
		// 실제 다운로드 하기
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			
			/* // 1. 하나씩 (int) 다운로드 받기
			int n;
			// read() 가 -1을 리턴하면 읽어 들인 파일을 모두 읽었다 판단
			while((n=bis.read()) != -1){
				bos.write(n);
				bos.flush();
			} */
			
			// 2. 전체 다운로드 받기
			byte[] buffer = new byte[(int)file.length()];		// 파일의 크기와 같은 크기의 버퍼 준비
			bis.read(buffer, 0, buffer.length);					// 버퍼 전체를 읽는다
			bos.write(buffer);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				if(bos != null) {bos.close();}
				if(bis != null) {bis.close();}
			}catch (Exception e2){
				e2.printStackTrace();
			}
			
		}
	}
}
