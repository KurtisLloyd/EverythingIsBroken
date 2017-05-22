import java.util.Random;

public class Worker implements Runnable {
	
	private static Random rando = new Random();
	private  int myIndex;
	private  int otherIndex;
	
	public Worker(int index){
		this.myIndex = index;
		this.otherIndex = index ==0 ? 1: 0;
	}
	
	private static int sleepTime(){
		return rando.nextInt(4000) + 2000;
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + " starting");
		int v = 0;
		try{
			SharedResource.wantToModify[myIndex] = true;
			while(SharedResource.wantToModify[otherIndex]){
				if(SharedResource.turn != myIndex){
					SharedResource.wantToModify[myIndex] = false;
					while(SharedResource.turn != myIndex){
						Thread.sleep(1000);
					}
					SharedResource.wantToModify[myIndex] = true;
					
				}
				
			}
			System.out.println("Thread: " + myIndex + " allowed to modify");
			 v = SharedResource.value;
			Thread.sleep(sleepTime());
			v++;
			SharedResource.value = v;
			
		
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Thread " + Thread.currentThread().getId() + " Ending" + " value: " + v);
		SharedResource.turn = myIndex == 0?1:0;
		SharedResource.wantToModify[myIndex] = false;
		
	}
	

}
