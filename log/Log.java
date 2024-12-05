package log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
	private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter("simulation.txt", false));
        } catch (Exception e) {
            System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
        }
    }

	public static void writeLine(String line) {
		try {
			writer.write(line + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();;
		}
	}

	public static void close() {
		try {
			writer.close();
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
