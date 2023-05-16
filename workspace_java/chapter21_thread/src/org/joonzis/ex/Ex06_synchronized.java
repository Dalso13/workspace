package org.joonzis.ex;

class MyThread3 implements Runnable{
	/*
	 * 	Thread.wait()
	 * 	Object.notify()
	 * 
	 * 		- 모니터링 락 설정 메소드
	 * 		- synchronized 블럭 내에서 사용해야 함
	 * 
	 * 
	 */
	
	static int tot;
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println((i+1) + "더하기");
				
				tot += (i+1);
				
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
			notify(); // wait() 하고 있는 객체를 깨움
			
		}
		
	}
}


public class Ex06_synchronized {
	public static void main(String[] args) {
		Thread t2 = new Thread(new MyThread3());
		
		t2.start();
		
		// 만약 main 쓰레드가 아래의 블록이 위에 쓰레드 보다 먼저 실행디었다면 wait 하게 되면서
		// 모니터링 락을 놓고 대기
		synchronized (t2) {
			
			try {
				// t2.wait() 메소드를 호출
				// 메인 쓰레드는 정지
				// 메소드에서 다섯 번 값을 더한 뒤 notify()를 호출하게 되면 wait()에서 깨어남
				System.out.println("다른 쓰레드가 완료될 때까지 기다립니다");
				t2.wait();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("총 합 : " + MyThread3.tot);
		}
	}
}
