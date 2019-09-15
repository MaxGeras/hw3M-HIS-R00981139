package modal;

import java.util.HashMap;

/**
 * Report to generate an XML file
 * 
 * @author Max
 *
 */
public class AirlinesDataSetReport {
	private HashMap<String, AirportReport> airportReport;
	private Long totalNumDueToSecurity;
	private Long totalNumDueToCarrier;
	private Long totalNumOfFlights;
	private Long totalNumDueToNas;
	private String airportWithHighestNumberOfDelaysDueToSecurity;
	private String airportWithLowestNumberOfDelaysDueToSecurity;
	private String airportWithTheMostTotalFlights;

	/**
	 * Initialize data
	 */
	public AirlinesDataSetReport() {
		this.airportReport = new HashMap<String, AirportReport>();
		this.totalNumOfFlights = (long) 0;
		this.totalNumDueToSecurity = (long)0;
		this.totalNumDueToCarrier=(long) 0;
		this.totalNumDueToNas =(long) 0;
		this.airportWithHighestNumberOfDelaysDueToSecurity = "";
		this.airportWithLowestNumberOfDelaysDueToSecurity = "";
		this.airportWithTheMostTotalFlights = "";
	}
	
	public HashMap<String, AirportReport> geAirportReport() {
		return airportReport;
	}
	
	public String getAirportWithHighestNumberOfDelaysDueToSecurity() {
		return airportWithHighestNumberOfDelaysDueToSecurity;
	}

	public void setAirportWithHighestNumberOfDelaysDueToSecurity(String airportWithHighestNumberOfDelaysDueToSecurity) {
		this.airportWithHighestNumberOfDelaysDueToSecurity = airportWithHighestNumberOfDelaysDueToSecurity;
	}

	public String getAirportWithLowestNumberOfDelaysDueToSecurity() {
		return airportWithLowestNumberOfDelaysDueToSecurity;
	}

	public void setAirportWithLowestNumberOfDelaysDueToSecurity(String airportWithLowestNumberOfDelaysDueToSecurity) {
		this.airportWithLowestNumberOfDelaysDueToSecurity = airportWithLowestNumberOfDelaysDueToSecurity;
	}

	public String getAirportWithTheMostTotalFlights() {
		return airportWithTheMostTotalFlights;
	}

	public void setAirportWithTheMostTotalFlights(String airportWithTheMostTotalFlights) {
		this.airportWithTheMostTotalFlights = airportWithTheMostTotalFlights;
	}

	public void setAirportReport(HashMap<String, AirportReport> airportReport) {
		this.airportReport = airportReport;
	}
	
	public Long getTotalNumOfFlights() {
		return totalNumOfFlights;
	}
	
	public void setTotalNumOfFlights(Long totalNumOfFlights) {
		this.totalNumOfFlights = totalNumOfFlights;
	}
	

	public Long getTotalNumDueToSecurity() {
		return totalNumDueToSecurity;
	}
	
	public void setTotalNumDueToSecurity(Long totalNumDueToSecurity) {
		this.totalNumDueToSecurity = totalNumDueToSecurity;
	}
	
	public Long getTotalNumDueToCarrier() {
		return totalNumDueToCarrier;
	}
	
	public void setTotalNumDueToCarrier(Long totalNumDueToCarrier) {
		this.totalNumDueToCarrier = totalNumDueToCarrier;
	}
	
	public Long getTotalNumDueToNas() {
		return totalNumDueToNas;
	}
	
	public void setTotalNumDueToNas(Long totalNumDueToNas) {
		this.totalNumDueToNas = totalNumDueToNas;
	}

}
