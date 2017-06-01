
public class StoreEvent {
	private ShopperEvent eventType;
	
	private int shopperId;
	
	private long duration;
	
	public StoreEvent(int shopperID, ShopperEvent type){
		this.setShopperId(shopperID);
		this.setEventType(type);
	}
	public long calculateDuration(){
		long meanTime = -1;
		switch(eventType){
		case CheckedOut:
			meanTime = Resources.MEAN_CHECKOUT_TIME;
			break;
		case Departed:
			meanTime = Resources.MEAN_LEAVING_TIME;
			break;
		case GotCart:
			meanTime = Resources.MEAN_CART_WAIT_TIME;
			break;
		case Shopped:
			meanTime = Resources.MEAN_SHOPPING_TIME;
			break;
		default:
			break;
		}
		return Math.round(Math.log((1 - Math.random()) * meanTime));
	}
	
	public ShopperEvent getEventType(){
		return eventType;
	}
	public void setEventType(ShopperEvent eventType){
		this.eventType = eventType;
	}
	public int getShopperId(){
		return shopperId;
	}
	public void setShopperId(int shopperId){
		this.shopperId = shopperId;
	}
	public long getDuration(){
		return duration;
	}
	public void setDuration(long duration){
		this.duration = duration;
	}

}
