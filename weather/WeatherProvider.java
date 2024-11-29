package weather;

import flyable.Aircraft.Coordinates;

//singleton class
public class WeatherProvider {

	private static WeatherProvider weatherProvider;

	private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {

	}

	public static WeatherProvider getWeatherProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
		}
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates p_Coordinates) {
		//create algo with coordinate
		return weather[0];
	}
}