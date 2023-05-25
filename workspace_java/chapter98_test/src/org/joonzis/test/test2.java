package org.joonzis.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String num = sc.nextLine();
		
		File file = null;
		FileWriter fw = null;		
		BufferedWriter bw = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			file = new File("name.txt");
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write(num);
			bw.flush();
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line = "";
			while (true) {
				line = br.readLine();
				if (line != null) {
					System.out.println(line);
				} else {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
