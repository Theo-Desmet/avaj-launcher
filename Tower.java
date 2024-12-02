import java.util.ArrayList;

public class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		observers.add(p_flyable);
		System.out.println(p_flyable.getId() + p_flyable.getName() + p_flyable.getType());
		
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