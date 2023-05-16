package org.joonzis.test;

interface Car{
	void info();
}

class Bus implements Car{
	@Override
	public void info() {
	}
}
class CityTourBus extends Bus{
	@Override
	public void info() {
		System.out.println("광역 버스");
		
	}
}
class SeoulBus extends Bus{
	@Override
	public void info() {
		
		System.out.println("서울 버스");
	}
}
class Taxi implements Car{
	@Override
	public void info() {
		System.out.println("택시");
		
	}
}
class Bicycle{
	@Override
	public String toString() {
		return "자전거";
	
	}
}

public class Test04 {
//	Q4. Test04.java
//	interface Car					메소드 : info();
//	class Bus implements Car
//	class CityTourBus extends Bus
//	class SeoulBus extends Bus
//	class Taxi implements Car
//	Class Bicycle
//	Class Test04					메소드 : static <T extends Car> void onlyCar(T car) 
//	 - CityTourBus, SeoulBus, Taxi 정보 출력
	
	static <T extends Car> void onlyCar(T car) {
			car.info();
	}
	
	
	public static void main(String[] args) {
		Car bus1 = new CityTourBus();
		Car bus2 = new SeoulBus();
		Car bus3 = new Taxi();
		
		onlyCar(bus1);
		onlyCar(bus2);
		onlyCar(bus3);
//		onlyCar(new Bicycle());
		
		
	}
}
