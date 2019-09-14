package modal;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Flights implements Serializable{
	private static final long serialVersionUID = 4L;
	
	@SerializedName("cancelled")
	private Long cancelled;
	
	@SerializedName("on time")
    private Long onTime; 
	
	@SerializedName("total")
	private Long total;
	
	@SerializedName("delayed")
	private Long delayed;
	
	@SerializedName("diverted")
	private Long diverted;
	
	public Long getCancelled() {
		return this.cancelled;
	}
	
	public Long getOnTime() {
		return this.onTime;
	}
	
	public Long getTotal() {
		return this.total;
	}
	
	public Long getDelayed() {
		return this.delayed;
	}
	
	public Long getDiverted() {
		return this.diverted;
	}

	public void setCancelled(Long cancelled) {
		this.cancelled = cancelled;
	}
	public void setOnTime(Long onTime) {
		this.onTime = onTime;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public void setDelayed(Long delayed) {
		this.delayed = delayed;
	}
	public void setDiverted(Long diverted) {
		this.diverted = diverted;
	}
}
