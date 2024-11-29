import parsing.ParseFile;

class Main {
	public static void main(String[] args) {

		if (args.length > 1) {
			//handle
			System.err.println("too many args");
			return;
		}

		ParseFile file = new ParseFile(args[0]);
		String line;
		while (true) {
			line = file.readLine();
			if (line == "") break;			
			System.out.println(line);
		}
	}
}