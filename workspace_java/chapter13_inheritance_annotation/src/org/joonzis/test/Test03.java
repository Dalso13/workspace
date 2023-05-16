package org.joonzis.test;

class Employee {
	String name;
	String dept;
	public Employee() {}
	public Employee(String name,String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	void output() {
		System.out.println("이름 : " + name );
		System.out.println("부서 : " + dept);
	}
	
}
class SalaryWorker extends Employee{
	int salary;
	public SalaryWorker() {}
	public SalaryWorker(String name,String dept,int salary) {
		super(name,dept);
		this.salary = salary;
	}
	
	private int pay() {		//좋은 방식인지는 모르겠지만 이렇게하면 자식 클래스 값이 잘 출력됨
		return salary;
	}
	
	@Override
	void output() {
		super.output();
		System.out.println("기본급 : " + pay() + "원");
		
	}
	
}
class SalesWorker extends SalaryWorker{
	double salesIncentive;
	public SalesWorker() {}
	public SalesWorker(String name,String dept,int salary, double salesIncentive) {
		super(name,dept,salary);
		this.salesIncentive = salesIncentive;
	}
	
	int salespay() {
		return (int)(salary / salesIncentive);
	}
	int pay() {
		return salespay() + salary;
	}
	
	@Override
	void output() {
		super.output();
		System.out.println("판매 인센티브 : " + salesIncentive + "%");
		System.out.println("수당 : " + salespay() + "원");
		System.out.println("총 급여 : " + pay() + "원");
	}
	
}
class PartTimeWorker extends Employee{
	int workTime;
	int payPerHour;
	public PartTimeWorker() {}
	public PartTimeWorker(String name,String dept,int workTime,int payPerHour) {
		super(name,dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}
	
	int pay() {
		return payPerHour * workTime;
	}
	
	@Override
	void output() {
		super.output();
		System.out.println("시급 : " + payPerHour + "원");
		System.out.println("일한 시간 : " + workTime + "시간");
		System.out.println("주급 : " + pay() + "원");
		
	}
	
	
}

public class Test03 {
	
//Q3. Test03.java 상속 관계로 구현하시오.
//SalaryWorker.java			- 필드 : String name, String dept, int salary
//							- 메소드 : Constructor, int pay(), output()	
//SalesWorker.java			- 필드 : String name, String dept, int salary , double salesIncentive
//							- 메소드 : Constructor, int pay(), output(), int salesPay()
//PartTimeWorker.java			- 필드 : String name, String dept, int workTime, int payPerHour
//							- 메소드 : Constructor, int pay(), output()
//→ 부모클래스는 알아서 만들어보자!(Employee)
//SalaryWorker extends Employee
//SalesWorker extends SalaryWorker
//PartTimeWorker extends Employee
//	
//String name : 이름
//String dept : 부서
//int salary : 기본급(월급)
//double salesIncentive : 판매 인센티브
//int workTime : 근무시간
//int payPerHour : 시급
	
	public static void main(String[] args) {
		SalaryWorker num1 = new SalaryWorker("장동완", "인사과",2000000);
		SalesWorker num2 = new SalesWorker("김동완", "행정과", 1500000 ,10);
		PartTimeWorker num3 = new PartTimeWorker("박동완", "영업과" , 52 , 15000);
		
		num1.output();
		System.out.println("------------------");
		num2.output();
		System.out.println("------------------");
		num3.output();
	}
}
