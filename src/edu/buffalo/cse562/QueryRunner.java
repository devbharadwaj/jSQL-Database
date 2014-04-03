package edu.buffalo.cse562;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import edu.buffalo.cse562.visitors.MyStatementVisitor;

import net.sf.jsqlparser.parser.CCJSqlParser;
import net.sf.jsqlparser.parser.ParseException;
import net.sf.jsqlparser.statement.Statement;

public class QueryRunner {
	
	String dataDir;
	List<String> sqlFiles;
	
	public QueryRunner(String dataDir, List<String> sqlFiles) {
		if (dataDir != null) {
			this.dataDir = dataDir;
			this.sqlFiles = sqlFiles;
		}
		else {
			throw new NullPointerException("Data Directory not specified");
		}
	}
	
	public void queryExecute() throws FileNotFoundException, ParseException {
		for (String file : sqlFiles) {
			FileReader sqlFile = new FileReader(file);
			CCJSqlParser parser = new CCJSqlParser(sqlFile);
			Statement statement = parser.Statement();
			MyStatementVisitor statementVisitor = new MyStatementVisitor();
			statement.accept(statementVisitor);
		}
	}

}
