package org.joonzis.ex;

public class Ex03_TeamMain {
	public static void main(String[] args) {
	Ex03_Team team = new Ex03_Team("장");
	team.output();
	Ex03_Team team1 = new Ex03_Team("김");
	team1.output();
	Ex03_Team team2 = new Ex03_Team("박");
	team2.output();
	
	
	System.out.println("전체 팀원 : " + Ex03_Team.count + "명");
	
	}

			
	
	
	
}
