import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainDekkers {
	
	
	
	public static void main(String [] args){
		
		final int numberOfThreads = 2;
		DekkerWorker worker = new DekkerWorker();
		
		new Thread(){
			@Override
			public void run(){
				worker.dekker1();
			}
		}.start();
	
		new Thread(){
			@Override
			public void run(){
				worker.dekker2();
			}
		}.start();
		
		
		
	}
	
}
