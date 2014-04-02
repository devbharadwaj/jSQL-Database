package edu.buffalo.cse562;

import java.util.List;

public class QueryRunner {
	
	String dataDir;
	List<String> sqlFiles;
	
	public QueryRunner(String dataDir, List<String> sqlFiles) {
		if (dataDir != null) {
			this.dataDir = dataDir;
			this.sqlFiles = sqlFiles;
		}
		else {
			throw new NullPointerException("Data Direcoty not specified");
		}
	}
	
	public void queryExecute() {
		
	}

}
