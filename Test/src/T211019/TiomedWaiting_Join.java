package T211019;
class MyThread1 extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(long i=0;i<1000000000L;i++) {}
	}
	
}
class MyThread2 extends Thread{
	MyThread1 myThread1;
	public MyThread2(MyThread1 myThread1) {
		this.myThread1 = myThread1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			myThread1.join(3000);
		}catch(InterruptedException e) {
			System.out.println("--join(...) 진행중 interrupt() 발생");
			for(long i=0;i<1000000000L;i++) {}
		}
	}
	
}
public class TiomedWaiting_Join {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread1 myThread1 = new MyThread1();
		MyThread2 myThread2 = new MyThread2(myThread1);
		myThread1.start();
		myThread2.start();
		try {Thread.sleep(100);}catch(InterruptedException e) {}
		System.out.println("MyThread1 State = "+myThread1.getState());
		System.out.println("MyThread2 State = "+myThread2.getState());
		myThread2.interrupt();
		try {Thread.sleep(100);}catch(InterruptedException e) {}
		System.out.println("MyThread1 State = "+myThread1.getState());
		System.out.println("MyThread2 State = "+myThread2.getState());
	}

}
