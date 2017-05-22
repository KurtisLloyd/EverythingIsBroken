import java.util.concurrent.Semaphore;

public class Resources {
	public static Object buffectTable = new Object();
	public static final int COUNT_TABLES = 2;
	public static long MEAN_TABLE_WAIT_TIME = 15*60*1000;
	public static long MEAN_FOOD_GETTING_TIME = 5*60*1000;
	public static long MEAN_CONSUMING_TIME_PER_DISH = 7*60*1000;
	public static long MEAN_LEAVING_TIME = 5*60*1000;
	
	public static Semaphore lock = new Semaphore(COUNT_TABLES);
	
	private static long simulationClock;
	

	private static Object clockLock = new Object();
	
	public static void initClock(long startTime){
		if(simulationClock != 0){
			throw new RuntimeException("Brokent");
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
