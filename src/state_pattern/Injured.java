package state_pattern;

public class Injured extends StatusState{

	public Injured(Status status) {
		super(status);
	}
	
	public StatusState nextState() {
		return new Dead(status);
	}

	public StatusState previousState() {
		return new Healthy(status);
	}

	public int getStatus() {
		return 1;
	}

}
