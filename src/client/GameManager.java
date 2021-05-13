package client;

import java.util.Scanner;

public class GameManager {
	public void start() {
		Character c1 = new Character();
		setCharacter(c1);
		c1.getAttributes();
		
		c1.receiveDamage(10);
		c1.getAttributes();
		c1.receiveDamage(10);
		c1.getAttributes();
		c1.receiveDamage(10);
		c1.getAttributes();
		c1.receiveDamage(60);
		c1.getAttributes();
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
}
