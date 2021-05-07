package client;

import java.util.Scanner;

public class GameManager {
	public void start() {
		Character c1 = new Character();
		set_character(c1);
		c1.get_attributes();
	}
	
	private void set_character(Character c) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Selecciona una clase: \n");
		System.out.println("1. Guerrero");
		System.out.println("2. Mago");
		System.out.println("3. Cazador");
		
		c.set_character_class(sc.nextInt());
	}
}
