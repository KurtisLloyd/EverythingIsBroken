import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	private static int NUM_OF_THREADS = 2;
	private static ExecutorService service = Executors.newFixedThreadPool(NUM_OF_THREADS);
	
	
	public static void main(String[] args) {
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			service.submit(new Worker());
		}


	}

}
