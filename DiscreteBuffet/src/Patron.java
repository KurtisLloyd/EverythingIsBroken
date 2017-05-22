import java.util.ArrayList;
import java.util.List;

public class Patron implements Runnable {
	private PatronStates state;
	
	List<BuffetEvent> events = new ArrayList<>();
	
	private int id;
	
	public Patron(int id){
		this.setId(id);
		this.setState(PatronStates.WAITING);
		this.events.add(new BuffetEvent(id,PatronEvents.Seated));
		this.events.add(new BuffetEvent(id,PatronEvents.GotFood));
		this.events.add(new BuffetEvent(id,PatronEvents.DoneEating));
		this.events.add(new BuffetEvent(id,PatronEvents.Departed));		
	}

	public PatronStates getState() {
		return state;
	}

	public void setState(PatronStates state) {
		this.state = state;
	}

	public List<BuffetEvent> getEvents() {
		return events;
	}

	public void setEvents(List<BuffetEvent> events) {
		this.events = events;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		
		try {
			getTable(this.events.get(0));
			processRegularEvent(this.events.get(0), PatronStates.GETTING);
			getFood(this.events.get(1));
			processRegularEvent(this.events.get(1), PatronStates.CONSUMING);
			eatFood(this.events.get(2));
			processRegularEvent(this.events.get(2), PatronStates.DONE);
			leave(this.events.get(3));
			processRegularEvent(this.events.get(3), PatronStates.LEAVING);
			System.out.println( "Thread " + id +" Total Time: " + Resources.getSimulationClock());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		
	}
	private void processRegularEvent(BuffetEvent event , PatronStates state){
		long waitTime = event.calculateDuration();
		event.setDuration(waitTime);
		Resources.incrementClock(waitTime);
	}
	private void getTable(BuffetEvent event) throws InterruptedException {
		System.out.println("Thread " + id + " aquired a table.");
		Resources.lock.acquire();
		this.setState(PatronStates.GETTING);
		
	}
	private void getFood(BuffetEvent event){
		System.out.println("Thread " + id + " recieved their food!");
		this.setState(PatronStates.CONSUMING);
	}
	private void eatFood(BuffetEvent event){
		System.out.println("Thread " + id + " ate their food");
		this.setState(PatronStates.DONE);
	}
	private void leave(BuffetEvent event){
		System.out.println("Thread " + id + " left their table");
		Resources.lock.release();
		this.setState(PatronStates.LEAVING);
	}

}
