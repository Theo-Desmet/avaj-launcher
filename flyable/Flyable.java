package flyable;

import weather.WeatherTower;

public abstract class Flyable {
	
	protected WeatherTower weatherTower;

	public abstract void updateCondition();

	public void registerTower(WeatherTower p_tower) {
		this.weatherTower = null;
	}

}