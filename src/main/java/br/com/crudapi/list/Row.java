package br.com.crudapi.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Rafael de Morais
 *
 */
public class Row {
	private Object pk;
	private Map<String, ColumnRow> columnRows = new HashMap<String, ColumnRow>();
	
	public void addColumnRow(String idCol, ColumnRow cRow){
		this.columnRows.put(idCol, cRow);
	}
	
	public Object getPk() {
		return pk;
	}
	public void setPk(Object pk) {
		this.pk = pk;
	}
	public Map<String, ColumnRow> getColumnRows() {
		return columnRows;
	}

	public void setColumnRows(Map<String, ColumnRow> columnRows) {
		this.columnRows = columnRows;
	}

	@Override
	public String toString() {
		return "Row [pk=" + pk + ", columnRows=" + columnRows + "]";
	}
}
