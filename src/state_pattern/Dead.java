package state_pattern;

public class Dead extends StatusState{

	public Dead(Status status) {
		super(status);
	}
	
	public StatusState nextState() {
		return this;
	}

	public StatusState previousState() {
		return null;
	}

	public int getStatus() {
		return 2;
	}

}
