package edu.buffalo.cse562.schema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schema {

	HashMap<String,List<Pair>> tables;
	
	/*
	 * Create a Schema for a table by giving it a unique name 
	 */
	public Schema(String tableName) {
		ArrayList<Pair> allColumns = new ArrayList<>();
		tables.put(tableName, allColumns);
	}
	
	/*
	 * Add columns to table by giving column name and columnType
	 */
	public void addColumns(String tableName, String columnName, String columnType) {
		Pair<String, String> column = Pair.createPair(columnName, columnType);
		List<Pair> allColumns = tables.get(tableName);
		if (allColumns == null) {
			throw new NullPointerException("Table does not exist.");
		}
		else {
			allColumns.add(column);
		}		

	}
}

/*
 * Pair of Column Name and Column Type
 */

class Pair<K, V> {

    private final K element0;
    private final V element1;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.element0 = element0;
        this.element1 = element1;
    }

    public K getElement0() {
        return element0;
    }

    public V getElement1() {
        return element1;
    }

}