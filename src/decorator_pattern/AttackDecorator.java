package decorator_pattern;

public abstract class AttackDecorator implements Attack{
	
	private Attack attack;
	
	public AttackDecorator(Attack attack) {
		set_attack(attack);
	}
	
	protected void set_attack(Attack attack) {
		this.attack = attack;
	}
	
	protected Attack get_attack() {
		return attack;
	}

}
