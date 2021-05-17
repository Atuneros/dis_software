package abstract_factory_pattern;

import java.util.ArrayList;

import strategy_pattern.AggressiveStrategy;
import strategy_pattern.ContextStrategy;
import template_pattern.Attack;
import template_pattern.Heal;
import template_pattern.TemplateMethod;

public class HarpyStage2 implements Harpy{
	private int attack_power, hp, behaviour;
	ContextStrategy context = new ContextStrategy(new AggressiveStrategy());
	TemplateMethod template;
	
	public HarpyStage2(int ap, int hp) {
		this.attack_power = ap;
		this.hp = hp;
		this.behaviour = context.setStrategy();
		
		if(this.behaviour == 0) {
			template = new Heal();
		}else {
			template = new Attack();
		}
	}
	
	public int getAttackPower() {
		return this.attack_power;
	}

	public int getHP() {
		return this.hp;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}

	public String getDescription() {
		return "Harpía de la tundra";
	}

	public int getBehaviour() {
		return this.behaviour;
	}

	public ArrayList<Integer> getActionsSequence() {
		return template.execTemplate();
	}

}
