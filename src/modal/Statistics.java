package modal;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 3L;
	
	@SerializedName("flights")
	private Flights flights;
	
	@SerializedName("# of delays")
	private NumberOfDelays numberOfDelays;
	
	@SerializedName("minutes delayed")
	private MinutesDelayed minutesDelayed;
	
	public Flights getFlights() {
		return this.flights;
	}
	
	public NumberOfDelays getNumbersOfDelays() {
		return this.numberOfDelays;
	}
	
	public MinutesDelayed getMinutesDelayed() {
		return this.minutesDelayed;
	}
	
	public void setFlights(Flights flights) {
		this.flights = flights;
	}
	
	public void setNumberOfDelays(NumberOfDelays numbersOfDelays) {
		this.numberOfDelays = numbersOfDelays;
	}
	
	public void setMinutesDelayed(MinutesDelayed minutesDelayed) {
		this.minutesDelayed = minutesDelayed;
	}

}
