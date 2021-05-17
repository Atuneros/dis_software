package abstract_factory_pattern;

public interface EnemyFactory {
	Goblin createGoblin(int attack_power, int hp);
	Wyrm createWyrm(int attack_power, int hp);
	Harpy createHarpy(int attack_power, int hp);
}
