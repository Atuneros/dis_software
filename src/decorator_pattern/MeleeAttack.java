package decorator_pattern;

public class MeleeAttack extends AttackDecorator{
	private int melee_attack_value = 7;
	
	public MeleeAttack(Attack attack) {
		super(attack);
	}

	public int get_attack_value() {
		return get_attack().get_attack_value() + this.melee_attack_value;
	}
}
