import java.util.concurrent.Semaphore;

public class Resource {
	private int counter = 0;
	Semaphore locker = new Semaphore(1);
	public int getCounter(){
		return counter;
	}
	public void incCounter(){
		counter++;
	}
	public void lockValue(){
		try {
			locker.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void releaseValue(){
		locker.release();
	}
	

}
