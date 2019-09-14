package modal;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Max
 */
public class Airport implements Serializable {
	private static final long serialVersionUID = 2L;
	
	@SerializedName("code")
	private String code;
	
	@SerializedName("name")
	private String name;
	
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	} 
	
}
