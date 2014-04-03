package edu.buffalo.cse562.logicalplan;

import java.util.List;

import edu.buffalo.cse562.schema.Schema;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.PlainSelect;

public class OperatorTree {

	Schema schema;
	FromItem fromItemList;
	Expression whereExpression;
	List selectItems;
	List orderByElements;
	List groupByColumns;
	
	public OperatorTree(Schema schema, PlainSelect plainSelect) {
		this.schema = schema;
		this.fromItemList = plainSelect.getFromItem();
		this.whereExpression = plainSelect.getWhere();
		this.selectItems = plainSelect.getSelectItems();
		this.orderByElements = plainSelect.getOrderByElements();
		this.groupByColumns = plainSelect.getGroupByColumnReferences();
	}
	
	
}
