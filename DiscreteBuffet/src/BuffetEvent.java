
public class BuffetEvent {
	private PatronEvents eventType;
	
	private int patronId;
	
	private long duration; //milliseconds
	
	
	public BuffetEvent(int patronID, PatronEvents type){
		this.setPatronId(patronID);
		this.setEventType(type);
	}
	public long calculateDuration(){
		long meanTime = -1;
		switch(eventType){
		case Departed:
			meanTime = Resources.MEAN_LEAVING_TIME;
			break;
		case DoneEating:
			meanTime = Resources.MEAN_CONSUMING_TIME_PER_DISH;
			break;
		case GotFood:
			meanTime = Resources.MEAN_FOOD_GETTING_TIME;
			break;
		case Seated:
			meanTime = Resources.MEAN_TABLE_WAIT_TIME;
			break;
		default:
			break;
		
		}
		return Math.round(Math.log( (1 -Math.random()) * meanTime));
	}

	public PatronEvents getEventType() {
		return eventType;
	}

	public void setEventType(PatronEvents eventType) {
		this.eventType = eventType;
	}

	public int getPatronId() {
		return patronId;
	}

	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	
	

}
