package response;

import java.io.Serializable;

public class BookingResponse<T> implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String status;
	private String code;
	private String messaje;
	private T data;
	
	public BookingResponse(String status, String code, String messaje) {
		
		this.status = status;
		this.code = code;
		this.messaje = messaje;
		
	}
	public BookingResponse(String status, String code, String messaje, T data) {
		
		this.status = status;
		this.code = code;
		this.messaje = messaje;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessaje() {
		return messaje;
	}
	public void setMessaje(String messaje) {
		this.messaje = messaje;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
