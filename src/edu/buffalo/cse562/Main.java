package edu.buffalo.cse562;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import net.sf.jsqlparser.parser.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		String dataDir = null;
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
		
		QueryRunner queryRunner = new QueryRunner(dataDir, sqlFiles);
		queryRunner.queryExecute();
		
	}

}
