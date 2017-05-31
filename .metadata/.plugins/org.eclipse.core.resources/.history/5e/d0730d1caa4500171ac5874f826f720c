import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Employee {

	private static int NUM_OF_EMPLOYEES =5;

	PaymentSystem system = new PaymentSystem();

	private PaymentSystem paymentSystem = new PaymentSystem();

	private AtomicBoolean paymentSystemInUse = new AtomicBoolean(false);

	private static Semaphore locker = new Semaphore(NUM_OF_EMPLOYEES);

	public void takeOrder(){
		try {
			System.out.println(" Customer " + Thread.currentThread().getId() + " is Ordering.");
			locker.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void processCustOrder(){

		if(paymentSystemInUse.compareAndSet(false, true)){

		//synchronized(system){

		synchronized(paymentSystem){
			try {
				System.out.println("Thread : " +Thread.currentThread().getId() + " uses the PaymentSystem ");
				Thread.sleep(1000);
				System.out.println("Processing Order for customer " + Thread.currentThread().getId());
				system.use();
				System.out.println("Thread : " + Thread.currentThread().getId() + " drops the PaymentSystem ");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Order for cutomer " + Thread.currentThread().getId() + " has finished Processing");
		}
	
		locker.release();	
	//}
		}
	}

	public void deliverFood(){
		try {
			locker.acquire();
			Thread.sleep(1000);
			System.out.println("Customer's " + Thread.currentThread().getId() + " food is being delieverd.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Customer's " + Thread.currentThread().getId() + " food has been delivered.");
		locker.release();
	}
}
