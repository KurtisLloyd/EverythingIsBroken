import java.util.concurrent.Semaphore;

public class Resources {
	public static Object checkOutLine = new Object();
	public static final int NUMBER_OF_CARTS = 2;
	public static long MEAN_CART_WAIT_TIME = 3*60*1000;
	public static long MEAN_SHOPPING_TIME = 20*60*1000;
	public static long MEAN_CHECKOUT_TIME = 10*60*1000;
	public static long MEAN_LEAVING_TIME = 5*60*1000;
	
	public static Semaphore locke = new Semaphore(NUMBER_OF_CARTS);
	
	private static long simulationClock;
	
	private static Object clockLock = new Object();
	
	public static void initClock(long startTime){
		if(simulationClock != 0){
			throw new RuntimeException("Broken");
		}
		synchronized(clockLock){
			simulationClock = startTime;
		}
	}
	
	public static void incrementClock(long milliseconds){
		synchronized(clockLock){
			simulationClock += milliseconds;
		}
	}
	public static long getSimulationClock(){
		return simulationClock;
	}

}
