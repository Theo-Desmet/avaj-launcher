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
			// System.out.println("baloon create");
			Flyable baloon = new Baloon(0, p_name, p_Coordinates);
			return baloon;
		}
		if (p_type.equals("helicopter")) {
			// System.out.println("helicopter create");
			Flyable helicopter = new Helicopter(0, p_name, p_Coordinates);
			return helicopter;
		}
		if (p_type.equals("jetplane")) {
			// System.out.println("jetplane create");
			Flyable jetplane = new JetPlane(0, p_name, p_Coordinates);
			return jetplane;
		}
		//add exception
		return null;
	}

	public Flyable newAirCraft(String p_type, String p_name, long id, int longitude, int latidute, int height) {
		Coordinates coordinates = new Coordinates(longitude, longitude, height);
		// System.err.println("p_type:" + p_type + " p_name:" + p_name + " coordinate:" + coordinates.getLongitude() + " " + coordinates.getLatitude() + " " + coordinates.getHeight());

		if (p_type.equals("Baloon")) {
			// System.out.println("baloon create");
			Flyable baloon = new Baloon(id, p_name, coordinates);
			return baloon;
		}
		if (p_type.equals("Helicopter")) {
			// System.out.println("helicopter create");
			Flyable helicopter = new Helicopter(id, p_name, coordinates);
			return helicopter;
		}
		if (p_type.equals("JetPlane")) {
			// System.out.println("jetplane create");
			Flyable jetplane = new JetPlane(id, p_name, coordinates);
			return jetplane;
		}

		//add exception
		return null;
	}
}
