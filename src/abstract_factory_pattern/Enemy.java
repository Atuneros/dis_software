package abstract_factory_pattern;

import java.util.ArrayList;

public interface Enemy {
	int getAttackPower();
	int getHP();
	void setHP(int n);
	int getBehaviour();
	public ArrayList<Integer> getActionsSequence();
	String getDescription();
}
