package client;

import decorator_pattern.*;
import state_pattern.Status;

public class Character {
	/*
	* 1 = WARRIOR
	* 2 = MAGE
	* 3 = HUNTER
	*/
	
	private int total_hp;
	private int hp;
	private int defense;
	private Attack attack;
	private Status status = new Status();
	
	protected void setCharacterClass(int character_class) {
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
		
		setAttributes(a, hp);
	}
	
	private void setAttributes(Attack a, int hp) {
		this.attack = a;
		this.total_hp = hp;
		this.hp = hp;
		this.defense = 0;
	}
	
	public void getAttributes() {
		System.out.println("\nHP: " + this.total_hp);
		System.out.println("\nCurrent HP: " + this.hp);
		System.out.println("\nAttack power: " + this.attack.get_attack_value());
		System.out.println("\nDefenses: " + this.defense);
	}
	
	protected void receiveDamage(int dmg) {
		this.hp = this.hp - dmg;
		
		if(status.getStatus() == 0) {
			status.nextState();
			improveDefenseStat();
		}else if(this.hp <= 0) {
			status.nextState();
		}
		
		System.out.println(status.getStatus());
	}
	
	protected void receiveHeal(int heal) {
		this.hp = this.hp + heal;
		if(this.hp > this.total_hp/2) {
			status.previousState();
		}
	}
	
	private void improveDefenseStat() {
		this.defense = 20;
	}
}