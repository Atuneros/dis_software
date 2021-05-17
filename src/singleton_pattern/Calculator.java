package singleton_pattern;

public final class Calculator {
	private static Calculator uniqueInstance;
	
	private Calculator() {
	}
	
	public static Calculator getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Calculator();
		}
		return uniqueInstance;
	}
	
	public int evaluateDamage(int attacker, int hp_defender, int defense_defender) {
		return hp_defender + defense_defender - attacker;
	}
}
