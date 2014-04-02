package edu.buffalo.cse562;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String dataDir;
		ArrayList<String> sqlFiles = new ArrayList<>();
		boolean getSqlFiles = false;
		
		for (int i = 0; i < args.length; i++) {
			if (getSqlFiles) {
				sqlFiles.add(args[i]);
			}
			else if (args[i] == "--data") {
				dataDir = args[i+1];
				getSqlFiles = true;
			}
		}
		
		

	}

}
