package modal;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * @author Max
 *
 */
public class NumberOfDelays implements Serializable{
	private static final long serialVersionUID = 5L;
	
	@SerializedName("late aircraft")
	private Long lateAircraft;
	
	@SerializedName("weather")
    private Long weather; 
	
	@SerializedName("security")
	private Long security;
	
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
	
	public void setNationalAviationSystem(Long nationalAviationSystem) {
		this.nationalAviationSystem = nationalAviationSystem;
	}
	
	public void setCarrier(Long carrier) {
		this.carrier = carrier;
	}
	
}
