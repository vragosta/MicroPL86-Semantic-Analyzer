package semantic.analyzer;
import java.io.*;

public class MicroPL86 {
	public static void main(String [] args) throws Exception {
		processCommandLine(args);

		if (filename == null) {
			System.out.println("Usage: MicroPL86 <filename>");
			System.exit(2);
		}

		try {
			SemanticAnalyzer semAnalyzer = new SemanticAnalyzer(filename);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	static void processCommandLine(String [] args) {
		for (int i = 0; i < args.length; i++)
			if (args[i].startsWith("-")) {
			}
			else
				filename = args[i];
	}

	static String filename = null;

}