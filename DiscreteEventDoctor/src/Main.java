import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
public static final int NUM_OF_SHOPPERS = 30;
	
	static ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_SHOPPERS);
	
	public static void main(String [] args){
		for (int i = 0; i < NUM_OF_SHOPPERS; i++) {
			pool.submit(new Shopper(i));
		}
	}
}
