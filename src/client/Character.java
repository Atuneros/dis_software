package client;

import decorator_pattern.Attack;
import decorator_pattern.BasicAttack;
import decorator_pattern.MagicAttack;
import decorator_pattern.MeleeAttack;
import decorator_pattern.RangedAttack;

public class Character {
	/*
	* 1 = WARRIOR
	* 2 = MAGE
	* 3 = HUNTER
	*/
	
	private int hp;
	private Attack attack;
	
	protected void set_character_class(int character_class) {
		Attack a = null;
		int hp = 0;
		
		if(character_class == 1) {
			a = new MeleeAttack(new BasicAttack());
			hp = 120;
		}else if(character_class == 2) {
			a = new MagicAttack(new BasicAttack());
			hp = 90;
		}else if(character_class == 3) {
			a = new RangedAttack(new BasicAttack());
			hp = 100;
		}
		
		set_attributes(a, hp);
	}
	
	private void set_attributes(Attack a, int hp) {
		this.attack = a;
		this.hp = hp;
	}
	
	public void get_attributes() {
		System.out.println("\nHP: " + this.hp);
		System.out.println("\nAttack power: " + this.attack.get_attack_value());
	}

}