import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static final int NUM_OF_PATRONS = 4;
	
	static ExecutorService pool = Executors.newFixedThreadPool(NUM_OF_PATRONS);
	
	public static void main(String [] args){
		for (int i = 0; i < NUM_OF_PATRONS; i++) {
			pool.submit(new Patron(i));
		}
	}

}
