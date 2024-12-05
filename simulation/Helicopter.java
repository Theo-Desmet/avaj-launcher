package simulation;
import log.Log;


public class Helicopter extends Aircraft {
	public Helicopter(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		String currentWeather = this.weatherTower.getWeather(coordinates);

		switch (currentWeather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "HELICOPTER HELICOPTER !!!!");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "It's rain and I have cockpit so it's ok");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "CRAZY FROG OMG, I'm dyslexia and read frog instead of fog, RATIO !!!");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "MAYDAY MAYDAY, the rotor is freezing, MAYDAY MAYDAY !!!!");
				break;
			default:
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "no weather");
				break;
		}

		if (coordinates.getHeight() > 100) {
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
		} else if (coordinates.getHeight() < 1) {
			weatherTower.unregister(this);
		}
	}
}
