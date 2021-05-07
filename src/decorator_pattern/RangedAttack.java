package decorator_pattern;

public class RangedAttack extends AttackDecorator{
	private int ranged_attack_value = 9;
	
	public RangedAttack(Attack attack) {
		super(attack);
	}

	public int get_attack_value() {
		return get_attack().get_attack_value() + this.ranged_attack_value;
	}

}