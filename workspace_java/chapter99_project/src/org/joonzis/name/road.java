package org.joonzis.name;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.joonzis.status.PlayerStatus;

public class road implements Player{
	File file = null;
	FileReader fr = null;
	BufferedReader br = null;
	Scanner sc = new Scanner(System.in);
	
	public void road() {
		try {
			System.out.println("\n1. 불러오기  2. 저장파일 삭제   3. 나가기 : ");
			String yesOrNo = sc.nextLine();
			
			if (yesOrNo.equals("1")) {
			} else if (yesOrNo.equals("2")) {
				saveDelete();
			} else if (yesOrNo.equals("3"))	{
				title.name();}
			else if (yesOrNo.length() > 10) {
				System.out.println("다시 입력해 주세요.");
				road();
			} else {
				System.out.println("다시 입력해 주세요.");
				road();
			}
			
			System.out.println("불러올 파일 입력 : ");
			String files = (sc.nextLine() + ".txt");
			file = new File(files);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line2 = "";
			String line = "";
			while (true) {
				line = br.readLine();
				if (line != null) {
					line2 += line;
				} else {
					break;
				}
			}
			String line3[] = line2.replaceAll(" ","").split(",");

			List<String> line4 = new ArrayList<String>();
			for (int j = 0; j < line3.length; j ++) {
				line4.add(line3[j]);
			}

			System.out.println(line4.get(1));
			player.setHp(Integer.parseInt(line4.get(3)));
			player.setMp(Integer.parseInt(line4.get(5)));
			player.setLevel(Integer.parseInt(line4.get(7)));
			player.setExp(Integer.parseInt(line4.get(9)));
			player.saveBank(Integer.parseInt(line4.get(11)));

			stat.statusWindow();
			System.out.println("로드 하였습니다");
		} catch (IOException e) {
			System.out.println("저장된 파일을 찾을수 없습니다.");
		}
	}
	
	public void saveDelete() {
		String name;
		System.out.print("삭제할 이름 입력 : ");
		name = sc.nextLine().replaceAll(" ", "");

		if (name.equals(null) || name.equals("")) {
			System.out.println("공백값은 저장할수 없습니다.");
			saveDelete();
		}
		if (name.length() > 12) {
			System.out.println("다시 입력해 주세요");
			saveDelete();
		}

		String fileName = "C:\\dev\\workspace\\workspace_java\\chapter99_project\\" + name + ".txt";

		File deleteFile = new File(fileName);

		if (deleteFile.exists()) {

			// 파일을 삭제합니다.
			deleteFile.delete();
			System.out.println("파일을 삭제하였습니다.");
			road();

		} else {
			System.out.println("파일이 존재하지 않습니다.");
			road();
		}
	}
}