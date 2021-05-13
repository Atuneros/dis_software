package state_pattern;

public class Healthy extends StatusState{

	public Healthy(Status status) {
		super(status);
	}
	
	public StatusState nextState() {
		return new Injured(status);
	}

	public StatusState previousState() {
		return null;
	}

	public int getStatus() {
		return 0;
	}

}
