
public class DekkerWorker implements Runnable {
	
	private DekkerShared shared = new DekkerShared();
	
	
	public DekkerWorker(){
		
	}

	@Override
	public void run() {

	}
	
	public void dekker1(){
		System.out.println("Thread: " + Thread.currentThread().getId() + " is Starting!");
		shared.setModify(0,true);
		while(shared.getWantToModify(1)){
			if(shared.getTurn() != 0){
				shared.setModify(0, false);
				while(shared.getTurn() != 0){
					try {
						Thread.sleep(1000);
						System.out.println("Thread "+ Thread.currentThread().getId() + " is waiting!");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				shared.setModify(0, true);
			}
		}
		System.out.println("Incrementing");
		shared.incValue();	
		shared.setTurn(1);
		shared.setModify(0, false);
		System.out.println("Value is now: " + shared.getToInc());
		System.out.println("Thread: " + Thread.currentThread().getId() + " is Ending!");
	}
	public void dekker2(){
		System.out.println("Thread: " + Thread.currentThread().getId() + " is Starting!");
		shared.setModify(1,true);
		while(shared.getWantToModify(0)){
			if(shared.getTurn() != 1){
				shared.setModify(1, false);
				while(shared.getTurn() != 1){
					try {
						Thread.sleep(1000);
						System.out.println("Thread "+ Thread.currentThread().getId() + " is waiting!");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				shared.setModify(1, true);
			}
		}
		System.out.println("Incrementing");
		shared.incValue();	
		shared.setTurn(0);
		shared.setModify(1, false);
		System.out.println("Value is now: " + shared.getToInc());
		System.out.println("Thread: " + Thread.currentThread().getId() + " is Ending!");
	}

}
