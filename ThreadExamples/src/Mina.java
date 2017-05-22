import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mina {

	
	public static void main(String[] args) {
		final int NUM_WORKERS = 2;
		List<Worker> workers = new ArrayList<>();
		
		ExecutorService ThreadService = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < NUM_WORKERS; i++) {
			Worker w = new Worker(i);
			workers.add(w);
		}
		for (int i = 0; i < NUM_WORKERS; i++) {
			ThreadService.submit(workers.get(i));
		}
		
	
		
		
	}
}
