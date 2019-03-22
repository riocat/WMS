package com.gt.wms.util;

public class JsonResult {

	private JsonResultStatus result;
	private Object data;
	private String message;

	public JsonResult() {
	}

	public JsonResult(JsonResultStatus result, Object data, String message) {
		this.result = result;
		this.data = data;
		this.message = message;
	}

	public JsonResultStatus getResult() {
		return result;
	}

	public void setResult(JsonResultStatus result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
