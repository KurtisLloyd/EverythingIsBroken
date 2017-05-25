
public class PaymentSystem {

	public void use(){
		System.out.println( "Thread " + Thread.currentThread().getId() + " is using the payment system");
	}
	private boolean inUse = false;
	
	
	public boolean getPaymentSystem(){
		return this.inUse;
	}
	public void setPaymentSystem(boolean toPass){
		this.inUse = toPass;

	}
}
