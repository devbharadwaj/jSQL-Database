package edu.buffalo.cse562.visitors;

import java.util.List;

import edu.buffalo.cse562.schema.Schema;

import net.sf.jsqlparser.statement.StatementVisitor;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.drop.Drop;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.replace.Replace;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;

public class MyStatementVisitor implements StatementVisitor {
	
	Schema schema;
	
	@Override
	public void visit(CreateTable arg0) {
		String tableName = arg0.getTable().getName();
		schema = new Schema(tableName);
		List<ColumnDefinition> columnDefinitions = arg0.getColumnDefinitions();
		for (ColumnDefinition columnName : columnDefinitions) {
			schema.addColumns(tableName, columnName.getColumnName(), columnName.getColDataType().toString());
		}
	}

	@Override
	public void visit(Select arg0) {
		SelectBody selectBody = arg0.getSelectBody();
		MySelectVisitor mySelect = new MySelectVisitor(schema);
		selectBody.accept(mySelect);
	}

	@Override
	public void visit(Delete arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void visit(Update arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void visit(Insert arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void visit(Replace arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void visit(Drop arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}

	@Override
	public void visit(Truncate arg0) {
		throw new UnsupportedOperationException("Not supported yet."); 
	}


}
