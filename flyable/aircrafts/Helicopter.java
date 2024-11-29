package flyable.aircrafts;

import flyable.Aircraft;

public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		System.out.println("helicoptere helicoptere");
	}
}
