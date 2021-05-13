package state_pattern;

public class Status {
	
	/* 
	 * 0 HEALTHY
	 * 1 INJURED
	 * 2 DEAD
	 */
	
	protected StatusState status_state;
	
	public Status() {
		this.status_state = new Healthy(this);
	}
	
	public void nextState() {
		this.status_state = status_state.nextState();
	}
	
	public void previousState() {
		this.status_state = status_state.previousState();
	}
	
	public int getStatus() {
		return this.status_state.getStatus();
	}
}
