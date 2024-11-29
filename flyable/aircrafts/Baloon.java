package flyable.aircrafts;

import flyable.Aircraft;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		System.out.println("ballon flying to the moon");
	}
}