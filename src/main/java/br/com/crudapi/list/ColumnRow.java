package br.com.crudapi.list;

public class ColumnRow {
	private Object key;
	private Object value;

	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ColumnRow [key=" + key + ", value=" + value + "]";
	}
}