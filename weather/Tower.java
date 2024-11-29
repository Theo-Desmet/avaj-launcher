package weather;

import java.util.ArrayList;
import flyable.*;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
	}

	protected void conditionChanged() {
		//implement call for change aircraft condition
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateCondition();
		}
	}
}