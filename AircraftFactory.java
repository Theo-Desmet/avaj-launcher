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
		Flyable newFlyable = null;
		try {
			switch (p_type) {
				case "Baloon":
					newFlyable = new Baloon(0, p_name, p_Coordinates);
					break;
				case "Helicopter":
					newFlyable = new Helicopter(0, p_name, p_Coordinates);
					break;
				case "JetPlane":
					newFlyable = new JetPlane(0, p_name, p_Coordinates);
					break;
				default:
					throw new Exception("Invalide type");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			Log.close();
		}

		return newFlyable;
	}

	public Flyable newAirCraft(String p_type, String p_name, long id, int longitude, int latidute, int height) {
		Coordinates coordinates = new Coordinates(longitude, longitude, height);
		Flyable newFlyable = null;
		try {
			switch (p_type) {
				case "Baloon":
					newFlyable = new Baloon(id, p_name, coordinates);
					break;
				case "Helicopter":
					newFlyable = new Helicopter(id, p_name, coordinates);
					break;
				case "JetPlane":
					newFlyable = new JetPlane(id, p_name, coordinates);
					break;
				default:
					throw new Exception("Invalide type: " + p_type);
			}
		} catch (Exception e) {
			System.err.println("at line: " + (id + 1));
			e.printStackTrace();
			System.exit(1);
		}
		return newFlyable;
	}
}
