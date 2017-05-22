
public class DekkerShared {
	private int toInc = 0;
	
	private boolean[] wantToModify;
	private int turn = 0;
	
	
	
	public DekkerShared(){
		wantToModify = new boolean[2];
		wantToModify[0] = false;
		wantToModify[1] = false;
		setTurn(0);
		
	}
	
	
	public void setTurn(int turn){
		this.turn = turn;
	}
	
	public int getTurn(){
		return this.turn;
	}
	public int getToInc(){
		return toInc;
	}
	
	public void incValue(){
		toInc++;
	}
	
	public void setModify(int index, boolean toChange){
		wantToModify[index] = toChange;
	}
	
	public boolean getWantToModify(int index){
		return wantToModify[index];
	}

}
