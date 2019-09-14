package modal;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * 
 */
public class Airline implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@SerializedName("airport")
	private Airport airport;
	
	@SerializedName("statistics")
	private Statistics statistics;

	public Airport getAirport() {
		return this.airport;
	}
	
	public Statistics getStatistics() {
		return this.statistics;
	}
	
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}
	
	@Override
	public String toString() {
		return this.airport.getName() + " " + this.statistics.getFlights().getTotal();
	}
	
}
