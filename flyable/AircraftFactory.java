package flyable;

import flyable.Aircraft.Coordinates;
import flyable.aircrafts.Baloon;

//singleton class
public class AircraftFactory {
	
	private static AircraftFactory aircraftFactory;

	private AircraftFactory(){

	}

	public static AircraftFactory geAircraftFactory() {
		if (aircraftFactory == null) {
			aircraftFactory = new AircraftFactory();
		}
		return aircraftFactory;
	}

	public Flyable newAirCraft(String p_type, String p_name, Coordinates p_Coordinates) {
		if (p_type.equals("baloon")) {
			Flyable baloon = new Baloon(0, p_name, p_Coordinates);
			return baloon;
		}
		if (p_type.equals("helicopter")) {
			Flyable helicopter = new Baloon(0, p_name, p_Coordinates);
			return helicopter;
		}
		if (p_type.equals("jetplane")) {
			Flyable jetplane = new Baloon(0, p_name, p_Coordinates);
			return jetplane;
		}
		//add exeption
		return null;
	}
}
