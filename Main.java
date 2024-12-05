import java.io.File;

import log.Log;
import parsing.ParseFile;
import simulation.AircraftFactory;
import simulation.Flyable;
import simulation.WeatherTower;

class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("too many args");
			System.exit(1);
		}
	
		AircraftFactory factory = AircraftFactory.geAircraftFactory();
		WeatherTower weatherTower = new WeatherTower();
		long idCounter = 0;

		try {
			// File inFile = new File(args[0]);
			// if (!infile.exists()) {
			// 	System.out.println("Scenario file not found: " + args[0]);
			// 	System.exit(1);
			// }
			ParseFile inFile = new ParseFile(args[0]);
			long nbIter = Integer.parseInt(inFile.readLine().trim());
			String line;

			while (true) {
				line = inFile.readLine();
				if (line == "")
					break;
				String[] parsed = ParseFile.parseLine(line);
				if (parsed.length != 5) 
					throw new Exception("Invalide number of arg in line");
				Flyable flyable = factory.newAirCraft(parsed[0], parsed[1], idCounter, Integer.parseInt(parsed[2].trim()),Integer.parseInt(parsed[3].trim()), Integer.parseInt(parsed[4].trim()));
				flyable.registerTower(weatherTower);
				idCounter++;
			}

			for (int i = 0; i < nbIter; i++) {
				weatherTower.changeWeather();
			}
		} catch (Exception e) {
			System.err.println("at line: " + (idCounter + 1) + " in " + args[0]);
			e.printStackTrace();
			System.exit(1);
		} finally {
			Log.close();
		}
	}
}