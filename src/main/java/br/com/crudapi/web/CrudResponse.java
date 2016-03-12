package br.com.crudapi.web;

import java.io.Serializable;

public class CrudResponse implements Serializable {

	private static final long serialVersionUID = 1894947186185567738L;
	
	String msg;
	String status;
	Serializable obj;
	
	private CrudResponse(String msg, String status) {
		this.msg = msg;
		this.status = status;
		this.obj = null;
	}
	
	private CrudResponse(String msg, String status, Serializable obj) {
		this.msg = msg;
		this.status = status;
		this.obj = obj;
	}
	public static CrudResponse ok() {
		return new CrudResponse("Ok", "success");
	}
	
	public static CrudResponse ok(String msg, Serializable obj) {
		return new CrudResponse(msg, "success", obj);
	}
	
	public static CrudResponse ok(Serializable obj) {
		return new CrudResponse("Ok", "success", obj);
	}
	
	public static CrudResponse error(String msg) {
		return new CrudResponse(msg, "error");
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Serializable obj) {
		this.obj = obj;
	}
}
