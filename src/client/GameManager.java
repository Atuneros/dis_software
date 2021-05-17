package client;

import java.util.ArrayList;
import java.util.Scanner;

import abstract_factory_pattern.Enemy;
import abstract_factory_pattern.EnemyFactory;
import abstract_factory_pattern.Goblin;
import abstract_factory_pattern.Harpy;
import abstract_factory_pattern.Stage1Enemies;
import abstract_factory_pattern.Stage2Enemies;
import abstract_factory_pattern.Wyrm;
import singleton_pattern.Calculator;

public class GameManager {
	
	final int GOBLIN1_AP_VALUE = 14;
	final int GOBLIN1_HP_VALUE = 60;
	final int GOBLIN2_AP_VALUE = 19;
	final int GOBLIN2_HP_VALUE = 66;
	
	final int WYRM1_AP_VALUE = 20;
	final int WYRM1_HP_VALUE = 70;
	final int WYRM2_AP_VALUE = 25;
	final int WYRM2_HP_VALUE = 76;
	
	final int HARPY1_AP_VALUE = 15;
	final int HARPY1_HP_VALUE = 65;
	final int HARPY2_AP_VALUE = 19;
	final int HARPY2_HP_VALUE = 71;
	
	public void start() {
		Character c1 = new Character();
		EnemyFactory enemies_stage_1 = new Stage1Enemies();
		EnemyFactory enemies_stage_2 = new Stage2Enemies();
		
		boolean flag = true;
		
		setCharacter(c1);
		
		Goblin g1 = enemies_stage_1.createGoblin(GOBLIN1_AP_VALUE, GOBLIN1_HP_VALUE);
		Goblin g2 = enemies_stage_2.createGoblin(GOBLIN2_AP_VALUE, GOBLIN2_HP_VALUE);
		
		Wyrm w1 = enemies_stage_1.createWyrm(WYRM1_AP_VALUE, WYRM1_HP_VALUE);
		Wyrm w2 = enemies_stage_2.createWyrm(WYRM2_AP_VALUE, WYRM2_HP_VALUE);
		
		Harpy h1 = enemies_stage_1.createHarpy(HARPY1_AP_VALUE, HARPY1_HP_VALUE);
		Harpy h2 = enemies_stage_2.createHarpy(HARPY2_AP_VALUE, HARPY2_HP_VALUE);
		
		System.out.println("\nNuestro héroe se aventura hacia el desierto...\n");
		
		int turno = (int) Math.floor(Math.random()*2);
		if(flag = combat(c1, g1, turno)) {
			turno = (int) Math.floor(Math.random()*2);
			if(flag = combat(c1, w1, turno)) {
				turno = (int) Math.floor(Math.random()*2);
				if(flag = combat(c1, h1, turno)) {
					turno = (int) Math.floor(Math.random()*2);
					if(flag = combat(c1, g2, turno)){
						turno = (int) Math.floor(Math.random()*2);
						if(flag = combat(c1, w2, turno)) {
							turno = (int) Math.floor(Math.random()*2);
							combat(c1, h2, turno);
						}
					}
				}
			}
		}
		if(flag) {
			System.out.println("TE HAS PASADO EL JUEGO");
		}else {
			System.out.println("HAS MUERTO DE FORMA MISERABLE");
		}
	}
	
	private void setCharacter(Character c) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Selecciona una clase: \n");
		System.out.println("1. Guerrero");
		System.out.println("2. Mago");
		System.out.println("3. Cazador");
		
		c.setCharacterClass(sc.nextInt());
	}
	
	private boolean combat(Character c, Enemy e, int turno) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> enemy_actions_sequence = new ArrayList<Integer>();
		Calculator calc = Calculator.getInstance();
		
		int damage, temp_def = 0, temp_def_enemy = 0;
		
		enemy_actions_sequence = e.getActionsSequence();
		
		System.out.println("UN "+e.getDescription()+" APARECE!");
		sc.nextLine();
		
		
		if(turno == 0) {
			System.out.println("ATACAS TÚ PRIMERO\n");
			
			while(e.getHP()>0 && c.getCurrentHP()>0) {
				System.out.println("Selecciona una acción:");
				System.out.println("1. Atacar");
				System.out.println("2. Defender");
					
				if(sc.nextInt() == 1) {
					damage = calc.evaluateDamage(c.getAttackPower(), e.getHP(), temp_def_enemy);
					e.setHP(damage);
					temp_def_enemy = 0;
					System.out.println("CAUSAS " + c.getAttackPower() + " PUNTOS DE DAÑO");
					System.out.println("EL ENEMIGO TIENE " + e.getHP() + " PUNTOS DE VIDA");
					sc.nextLine();
				}else {
					temp_def = 5;
				}
				if(e.getHP()>0) {
					if(enemy_actions_sequence.get(0)==0) {
						enemy_actions_sequence.remove(0);
						if(enemy_actions_sequence.isEmpty()) {
							enemy_actions_sequence = e.getActionsSequence();
						}
						System.out.println(e.getDescription()+" SE DEFIENDE Y AUMENTA SU DEFENSA TEMPORALMENTE");
						temp_def_enemy = 10;
						System.out.println("TE QUEDAN " + c.getCurrentHP() + " PUNTOS DE VIDA");
					}else {
						enemy_actions_sequence.remove(0);
						if(enemy_actions_sequence.isEmpty()) {
							enemy_actions_sequence = e.getActionsSequence();
						}
						damage = calc.evaluateDamage(e.getAttackPower(), c.getCurrentHP(), c.getDefenses()+temp_def);
						c.receiveDamage(damage);
						temp_def = 0;
						System.out.println(e.getDescription()+" ATACA Y CAUSA "+e.getAttackPower()+" PUNTOS DE DAÑO");
						System.out.println("TE QUEDAN " + c.getCurrentHP() + " PUNTOS DE VIDA");
					}
					
				}else {
					System.out.println("HAS DERROTADO A "+e.getDescription());
				}
			}
			if(c.getCurrentHP()<=0) {
				return false;
			}else {
				return true;
			}
		}else {
			System.out.println(e.getDescription()+" ATACA PRIMERO\n");
			while(e.getHP()>0 && c.getCurrentHP()>0) {
				if(enemy_actions_sequence.get(0)==0) {
					enemy_actions_sequence.remove(0);
					if(enemy_actions_sequence.isEmpty()) {
						enemy_actions_sequence = e.getActionsSequence();
					}
					System.out.println(e.getDescription()+" SE DEFIENDE Y AUMENTA SU DEFENSA TEMPORALMENTE");
					temp_def_enemy = 10;
					System.out.println("TE QUEDAN " + c.getCurrentHP() + " PUNTOS DE VIDA");
				}else {
					enemy_actions_sequence.remove(0);
					if(enemy_actions_sequence.isEmpty()) {
						enemy_actions_sequence = e.getActionsSequence();
					}
					damage = calc.evaluateDamage(e.getAttackPower(), c.getCurrentHP(), c.getDefenses()+temp_def);
					c.receiveDamage(damage);
					temp_def = 0;
					System.out.println(e.getDescription()+" ATACA Y CAUSA "+e.getAttackPower()+" PUNTOS DE DAÑO");
					System.out.println("TE QUEDAN " + c.getCurrentHP() + " PUNTOS DE VIDA");
					sc.nextLine();
				}
				if(c.getCurrentHP()<=0) {
					return false;
				}
				System.out.println("Selecciona una acción:");
				System.out.println("1. Atacar");
				System.out.println("2. Defender");
					
				if(sc.nextInt() == 1) {
					damage = calc.evaluateDamage(c.getAttackPower(), e.getHP(), temp_def_enemy);
					e.setHP(damage);
					temp_def_enemy = 0;
					System.out.println("CAUSAS " + c.getAttackPower() + " PUNTOS DE DAÑO");
					System.out.println("EL ENEMIGO TIENE " + e.getHP() + " PUNTOS DE VIDA");
				}else {
					temp_def = 5;
				}
			}
			if(c.getCurrentHP()<=0) {
				return false;
			}else {
				return true;
			}
		}
		
	}
}
