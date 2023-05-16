package org.joonzis.test;



public class Test05 {
//	Q5.Test05.java
//	성(lastName), 이름(firstName)을 각각 입력 받아
//	하나의 이름(fullName)을 완성하시오. StringBuffer 클래스를 이용하시오.
//	위의 방식으로 두 이름을 입력 받아 두 이름(fullName)의 동등 비교를 진행하시오.
	public static void main(String[] args) {
		
		String lastName = new String("동완");
		String firstName = new String("장");
		
		String lastName1 = new String("동완");
		String firstName1 = new String("장");
		
		StringBuffer fullName = new StringBuffer(lastName + firstName);
		StringBuffer fullName1 = new StringBuffer(lastName1 + firstName1);
		StringBuffer fullName2 = new StringBuffer(lastName + firstName);
		StringBuffer fullName3 = new StringBuffer();
		StringBuffer fullName4 = new StringBuffer();
		
		
		fullName3.append(lastName).append(firstName);
		fullName4.append(lastName).append(firstName);
		
		System.out.println(fullName + "" + fullName.hashCode());
		System.out.println(fullName1 + "" + fullName1.hashCode());
		System.out.println(fullName2 + "" + fullName2.hashCode());
		System.out.println(fullName3 + "" + fullName3.hashCode());
		System.out.println(fullName4 + "" + fullName4.hashCode());
		
		
		// StringBuffer 객체가 아닌 String 값의 비교
		
		if (fullName.toString().equals(fullName1.toString())){
			System.out.println("동등1");
		} else if (fullName.equals(fullName2)) {
			System.out.println("동등2");
		} else if (fullName.equals(fullName3)) {
			System.out.println("동등3");
		}else if (fullName3.equals(fullName4)) {
			System.out.println("동등3");
		} else {
			System.out.println("다른 이름");
		}
		
		
	}

}
