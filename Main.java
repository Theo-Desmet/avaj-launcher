
import parsing.ParseFile;

class Main {
	public static void main(String[] args) {
		if (args.length > 1) {
			//handle
			System.err.println("too many args");
			return;
		}
		
		ParseFile file = new ParseFile(args[0]);
		WeatherTower weatherTower = new WeatherTower();
		
		// gerer mieux
		String firstline = file.readLine();
		System.out.println(firstline);


		AircraftFactory factory = AircraftFactory.geAircraftFactory();
		String line;
		while (true) {
			line = file.readLine();
			if (line == "")
				break;
			String[] parsed = ParseFile.parseLine(line);
			if (parsed.length != 5) {
				//handle exception
				System.err.println("invalide line in parsing");
			}
			
			Flyable flyable = factory.newAirCraft(parsed[0], parsed[1], Integer.parseInt(parsed[2]),Integer.parseInt(parsed[3]), Integer.parseInt(parsed[4]));
			flyable.registerTower(weatherTower);
		}
		// ParseFile file = new ParseFile(args[0]);
		// String line;
		// while (true) {
		// 	line = file.readLine();
		// 	if (line == "") break;
		// 	String[] parsed = ParseFile.parseLine(line);
		// 	for (String string : parsed) {
		// 		System.out.println(string);
		// 	}
		// }
	}
}