package parsing;


import java.io.*;

public class ParseFile {
		
	private FileInputStream file;
	String line;

	public ParseFile(String args) {
		try {
			file = new FileInputStream(args);
		} catch(FileNotFoundException e) {
			System.err.println("Invalid access to " + args);
			e.printStackTrace();
			System.exit(1);
		}
	}

	public String readLine() {
		try {
			String line = "";
			int i = file.read();
			while(i != '\n') {
				if (i == -1) {
					file.close();
					return line;
				}
				line += (char)i;
				i = file.read();
			}
			return line;
		} catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public static String[] parseLine(String line){
		String[] parsedLine = line.split(" ");

		return parsedLine;
	}
}
