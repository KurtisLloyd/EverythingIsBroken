import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDekkers {
	
	
	
	public static void main(String [] args){
		
		final int numberOfThreads = 2;
		List<DekkerWorker> workers = new ArrayList<>();
		
		ExecutorService threadService = Executors.newFixedThreadPool(numberOfThreads);
		
		for (int i = 0; i < numberOfThreads; i++) {
			DekkerWorker worker = new DekkerWorker();
			workers.add(worker);
		}
		for(DekkerWorker worker: workers){
			threadService.submit(worker);
		}
		
	}
	
}
