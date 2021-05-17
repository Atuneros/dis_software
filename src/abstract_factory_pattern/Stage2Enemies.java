package abstract_factory_pattern;

public class Stage2Enemies implements EnemyFactory{
	public Goblin createGoblin(int attack_power, int hp) {
		return new GoblinStage2(attack_power, hp);
	}

	public Wyrm createWyrm(int attack_power, int hp) {
		return new WyrmStage2(attack_power, hp);
	}

	public Harpy createHarpy(int attack_power, int hp) {
		return new HarpyStage2(attack_power, hp);
	}
}
