package simulation;

import log.Log;

public class Baloon extends Aircraft {
	public Baloon(long p_id, String p_name, Coordinates p_Coordinates) {
		super(p_id, p_name, p_Coordinates);
	}

	public void updateCondition() {
		String currentWeather = this.weatherTower.getWeather(coordinates);

		switch (currentWeather) {
			case "SUN":
				coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "It's sunny, take picture");
				break;
			case "RAIN":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "It's rain and I don't have cockpit noooooooooo");
				break;
			case "FOG":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "Blind the wind, I see nothing");
				break;
			case "SNOW":
				coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() -15);
				Log.writeLine(getType() + "#" + getName() + "(" + getId() + "): " + "MAYDAY MAYDAY, WE ARE IN A BLIZZARD, MAYDAY MAYDAY !!!!");
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