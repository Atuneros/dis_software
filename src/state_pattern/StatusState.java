package state_pattern;

public abstract class StatusState {
	protected Status status;
	
	public StatusState(Status status) {
		this.status = status;
	}
	
	public abstract StatusState nextState();
	public abstract StatusState previousState();
	public abstract int getStatus();
}
