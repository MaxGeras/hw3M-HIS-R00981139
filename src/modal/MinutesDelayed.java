package modal;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Max
 *
 */
public class MinutesDelayed {
	@SerializedName("late aircraft")
	private Long lateAircraft;
	
	@SerializedName("weather")
    private Long weather; 
	
	@SerializedName("security")
	private Long security;
	
	@SerializedName("total")
	private Long total;
	
	@SerializedName("national aviation system")
	private Long nationalAviationSystem;
	
	@SerializedName("carrier")
	private Long carrier;
	
	public Long getLateAirCraft() {
		return this.lateAircraft;
	}
	
	public Long getWeather() {
		return this.weather;
	}
	
	public Long getSecurity() {
		return this.security;
	}
	
	public Long getTotal() {
		return this.total;
	}
	
	public Long getNationalAviationSystem() {
		return this.nationalAviationSystem;
	}
	
	public Long getCarrier() {
		return this.carrier;
	}
	
	public void setLateAirCraft(Long lateAircraft) {
		this.lateAircraft = lateAircraft;
	}
	
	public void setWeather(Long weather) {
		this.weather = weather;
	}
	
	public void setSecurity(Long security) {
		this.security = security;
	}
	
	public void setTotal(Long total) {
		this.total = total;
	}
	
	public void setNationalAviationSystem(Long nationalAviationSystem) {
		this.nationalAviationSystem = nationalAviationSystem;
	}
	
	public void setCarrier(Long carrier) {
		this.carrier = carrier;
	}
	
}