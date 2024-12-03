
import java.nio.file.Path;
import java.nio.file.Paths;

import parsing.ParseFile;

class Main {
	public static void main(String[] args) {
		if (args.length > 1) {
			//handle
			System.err.println("too many args");
			return;
		}
	
		ParseFile inFile = new ParseFile(args[0]);
		WeatherTower weatherTower = new WeatherTower();
		
		// gerer mieux
		String firstline = inFile.readLine();
		long nbIter = 0;
		try {
			nbIter = Integer.parseInt(firstline);			
		} catch (NumberFormatException e) {
			e.getStackTrace();
		}

		AircraftFactory factory = AircraftFactory.geAircraftFactory();
		long idCounter = 0;
		String line;
		while (true) {
			line = inFile.readLine();
			if (line == "")
				break;
			String[] parsed = ParseFile.parseLine(line);
			if (parsed.length != 5) {
				//handle exception
				System.err.println("invalide line in parsing");
			}
			
			Flyable flyable = factory.newAirCraft(parsed[0], parsed[1], idCounter, Integer.parseInt(parsed[2]),Integer.parseInt(parsed[3]), Integer.parseInt(parsed[4]));
			flyable.registerTower(weatherTower);
			idCounter++;
		}

		for (int i = 0; i < nbIter; i++) {
			weatherTower.changeWeather();
		}

	}
}