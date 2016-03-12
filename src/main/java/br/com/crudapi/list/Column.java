package br.com.crudapi.list;

/**
 * Representa as colunas da lista
 * 
 * @author Rafael de Morais
 *
 */
public class Column {
	private String id;
	private String nameColumn;
	private int ord;
	
	public Column() {
	}
	
	public Column(String id, String nameColumn, int ord) {
		this.id = id;
		this.nameColumn = nameColumn;
		this.ord = ord;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameColumn() {
		return nameColumn;
	}
	public void setNameColumn(String nameColumn) {
		this.nameColumn = nameColumn;
	}
	public int getOrd() {
		return ord;
	}
	public void setOrd(int ord) {
		this.ord = ord;
	}

	@Override
	public String toString() {
		return "Column [id=" + id + ", nameColumn=" + nameColumn + ", ord="
				+ ord + "]";
	}
}