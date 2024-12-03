import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		Log.writeLine("Tower say: " + p_flyable.getType() + " #" + p_flyable.getName() + " (" + p_flyable.getId() + ") registered to weather tower");
	}

	public void unregister(Flyable p_flyable) {
		observers.remove(p_flyable);
		Log.writeLine("Tower say: " + p_flyable.getType() + " #" + p_flyable.getName() + " (" + p_flyable.getId() + ") unregistered to weather tower");
	}

	protected void conditionChanged() {
		Log.writeLine("");
		Log.writeLine("******************** NEW WEATHER ********************");
		Log.writeLine("");

		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateCondition();
		}
	}
}