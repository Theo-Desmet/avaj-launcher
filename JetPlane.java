public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		String currentWeather = this.weatherTower.getWeather(coordinates);

		switch (currentWeather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "DO A BARREL ROLL");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "It's rain bro, oh no, anyway");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "With this fog I can't see anything. I hope I will not hit a tower...");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "It's snow time !");
				break;
			default:
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "no weather");
				break;
		}

		if (coordinates.getHeight() > 100) {
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
		} else if (coordinates.getHeight() < 1) {
			weatherTower.unregister(this);
		}	}
}