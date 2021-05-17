package abstract_factory_pattern;

public class Stage1Enemies implements EnemyFactory{

	public Goblin createGoblin(int attack_power, int hp) {
		return new GoblinStage1(attack_power, hp);
	}

	public Wyrm createWyrm(int attack_power, int hp) {
		return new WyrmStage1(attack_power, hp);
	}

	public Harpy createHarpy(int attack_power, int hp) {
		return new HarpyStage1(attack_power, hp);
	}

}
