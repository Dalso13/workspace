package org.joonzis.name;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Save implements Player {
	private Scanner sc = new Scanner(System.in);
	private File file = null;
	private FileWriter fw = null;
	private BufferedWriter bw = null;
	private String name;
	private String fileName = "0";

	public void saveFilter() {
		try {
			System.out.print("저장할 이름 입력 : ");
			name = sc.nextLine().replaceAll(" ", "");
		
			if (name.equals(null) || name.equals("")) {
				System.out.println("공백값은 저장할수 없습니다.");
				saveFilter();
			} 
			if (name.length() > 12) {
				System.out.println("다시 입력 해주세요");
				saveFilter();
			}
			
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File f, String name1) {
					return name1.contains(name);
				}
			};
			
			String DATA_DIRECTORY = "C:\\dev\\workspace\\workspace_java\\chapter99_project";
			File dir = new File(DATA_DIRECTORY);
			String[] filenames = dir.list(filter);
			for (String filename1 : filenames) {
				fileName = filename1;
			}
			save();
		} catch (NullPointerException e) {
			System.out.println("에러남");
			saveFilter();
		}
	}

	public void save() {
		try {
			String name1 = (name + ".txt");
			if (fileName.equals(name1)) {
				System.out.println("기존에 저장된 파일이 있습니다 덮어 씌우겠습니까?\n1.yes\t2.no");
				String yesOrNo = sc.nextLine();
				if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equals("1")) {
					System.out.println("덮어 씌웠습니다");
				} else if (yesOrNo.equalsIgnoreCase("no") || yesOrNo.equals("2")) {
					System.out.println("저장할 이름을 다시 입력해주세요.");
					saveFilter();
				} else if (yesOrNo.length() > 10) {
					System.out.println("다시 입력해 주세요.");
					save();
				}	else {
					System.out.println("다시 입력해 주세요");
					save();
				}
			}
			System.out.println(name + ".txt 로 저장하였습니다.");

			file = new File(name + ".txt");
			fw = new FileWriter(file, false);

			bw = new BufferedWriter(fw);

			bw.write("이름 , " + (player.getName()) + ", \n");
			bw.write("Hp , " + (player.getHp()) + ", \n");
			bw.write("Mp , " + (player.getMp()) + ", \n");
			bw.write("Level , " + (player.getLevel()) + ", \n");
			bw.write("Exp , " + (player.getExp()) + ", \n");
			bw.write("소지금 , " + (player.getBank()) + "\n");

			bw.flush();
			
			stat.statusWindow();
		} catch (IOException e) {
			System.out.println("다시 입력해주세요");
			save();
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("다시 입력해주세요");
			save();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
