package modal;

/**
 * Report per airport
 * 
 * @author Max
 */
public class AirportReport {
	private String airportName;
	private Long numOfDelaysDueToSecurity;
	private Long totalFlights;
	
	/**
	 * Initialize data
	 */
	public AirportReport() {
		this.airportName = "";
		this.numOfDelaysDueToSecurity = (long) 0;
		this.totalFlights = (long) 0;
	}
	
	public Long getNumOfDelaysDueToSecurity() {
		return numOfDelaysDueToSecurity;
	}
	public void setNumOfDelaysDueToSecurity(Long numOfDelaysDueToSecurity) {
		this.numOfDelaysDueToSecurity = numOfDelaysDueToSecurity;
	}
	public Long getTotalFlights() {
		return totalFlights;
	}
	public void setTotalFlights(Long totalFlights) {
		this.totalFlights = totalFlights;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
}
