package template_pattern;

import java.util.ArrayList;

public abstract class TemplateMethod {
	public final ArrayList<Integer> execTemplate() {
		ArrayList<Integer> sequence = new ArrayList<Integer>();;
		sequence.add(attack());
		sequence.add(custom());
		return sequence;
	}
	
	public abstract int custom();
	
	private final int attack() {
		return 1;
	}
}
