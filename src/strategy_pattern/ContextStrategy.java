package strategy_pattern;

public class ContextStrategy {
	private Strategy algorithm;
	
	public ContextStrategy(Strategy algorithm) {
		this.algorithm = algorithm;
	}
	
	public int setStrategy() {
		return algorithm.implementStrategy();
	}
}
