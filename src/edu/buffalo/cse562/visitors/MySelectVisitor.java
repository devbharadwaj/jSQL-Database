package edu.buffalo.cse562.visitors;

import edu.buffalo.cse562.logicalplan.OperatorTree;
import edu.buffalo.cse562.schema.Schema;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectVisitor;
import net.sf.jsqlparser.statement.select.Union;

public class MySelectVisitor implements SelectVisitor {
	
	Schema schema;
	
	public MySelectVisitor(Schema schema) {
		this.schema = schema;
	}

	@Override
	public void visit(PlainSelect plainSelect) {
		OperatorTree opTree = new OperatorTree(schema, plainSelect);
		// Asynchronous Push Operator Tree - multi-threading

	}

	@Override
	public void visit(Union arg0) {
		// TODO Auto-generated method stub

	}

}
