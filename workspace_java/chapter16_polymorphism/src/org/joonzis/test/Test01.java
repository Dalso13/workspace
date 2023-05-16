package org.joonzis.test;
class Employee{
	private String name, dept;
	

	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	public int pay() {
		return 0;
	}
	public void output() {
		System.out.println(name);
		System.out.println(dept);
	}
	
	
}
class SalaryWorker extends Employee{
	private int salary;
	
	
	
	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}

	@Override
	public int pay() {
		return salary;
	}
	
	@Override
	public void output() {
		super.output();
		System.out.println(salary);
	}
	

}
class SalesWorker extends SalaryWorker{
	private int salesVolume;
	private double salesIncentive;
	
	
	
	
	public SalesWorker(String name, String dept, int salary) {
		super(name, dept, salary);
	}
	
	public void setSalesIncentive(double salesIncentive) {
		this.salesIncentive = salesIncentive;
		
		
	}
	
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		
		if (salesVolume >= 1000) {
			setSalesIncentive(10);
		} else if (salesVolume >= 500) {
			setSalesIncentive(5);
		} else {
			setSalesIncentive(1);
		}
	}
	
	
	private int salesPay() {
		return (int)(salesVolume * (salesIncentive/100));
	}	
	
	@Override
	public int pay() {
		return super.pay() + salesPay();
	}
	@Override
	public void output() {
		super.output();
		
		System.out.println(salesVolume);
		System.out.println(salesIncentive);
		System.out.println(salesPay());
		System.out.println(pay());
	}

	
}
class PartTimeWorker extends Employee{
	private int workTime, payPerHour;
	
	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}

	@Override
	public int pay() {
		return workTime * payPerHour;
	}
	
	@Override
	public void output() {
		super.output();
		System.out.println(workTime);
		System.out.println(payPerHour);
		System.out.println(pay());
		
	}
	

}

public class Test01{
//	Q1.Test01.java
//
//	Employee 클래스			필드 : String name, String dept
//							메소드 : Constructor, int pay(), void output()
//	SalaryWorker 클래스		필드 : int salary
//							메소드 : Constructor, int pay(), void output()
//	SalesWorker 클래스		필드 : int salesVolume, 
//								double salesIncentive --> 인센티브 비율(1000이상 10%, 500이상 5% 나머지 1%)
//							메소드 : Constructor, int pay(), void output(),
//									 int salesPay(),
//									 void setSalesVolume(salesVolume), 
//									 void setSalesIncentive(salesIncentive)
//	PartTimeWorker 클래스	필드 : int workTime, int payPerHour
//							메소드 : Constructor, int pay(), void output()
//	★
//	필드는 전부 private
//	SalaryWorker extends Employee
//	SalesWorker extends SalaryWorker
//	PartTimeWorker extends Employee
//
	public static void main(String[] args) {
		
		Employee emp[] = new Employee[3];
		
		emp[0] = new SalaryWorker("장동완", "인사과", 200);
		emp[1] = new SalesWorker("김동완", "영업과", 210);
		emp[2] = new PartTimeWorker("박동완", "보안과", 52, 10000);

		if (emp[1] instanceof SalesWorker ) {
			((SalesWorker)emp[1]).setSalesVolume(1000);
		}
		
		for (int i = 0; i < emp.length; i++) {
			emp[i].output();
			System.out.println("------------");
		}
		
	}
}
