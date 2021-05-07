package decorator_pattern;

public class MagicAttack extends AttackDecorator{
	private int magic_attack_value = 12;
	
	public MagicAttack(Attack attack) {
		super(attack);
	}

	public int get_attack_value() {
		return get_attack().get_attack_value() + this.magic_attack_value;
	}

}
