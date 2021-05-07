package decorator_pattern;

public class BasicAttack implements Attack{

	private int attack_damage = 10;
	
	public int get_attack_value() {
		return attack_damage;
	}
	
}
