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
	private Long highestNumberOfDelaysDueToSecurity;
	private Long lowestNumberOfDelaysDueToSecurity;
	private Long numWithTheMostTotalFlights;

	/**
	 * Initialize data
	 */
	public AirlinesDataSetReport() {
		this.airportReport = new HashMap<String, AirportReport>();
		this.totalNumOfFlights = (long) 0;
		this.totalNumDueToSecurity = (long)0;
		this.totalNumDueToCarrier=(long) 0;
		this.totalNumDueToNas =(long) 0;
		this.highestNumberOfDelaysDueToSecurity =(long) 0;
		this.lowestNumberOfDelaysDueToSecurity =(long) 0;
	}
	

	public Long getNumWithTheMostTotalFlights() {
		return numWithTheMostTotalFlights;
	}


	public void setNumWithTheMostTotalFlights(Long numWithTheMostTotalFlights) {
		this.numWithTheMostTotalFlights = numWithTheMostTotalFlights;
	}


	public Long getHighestNumberOfDelaysDueToSecurity() {
		return highestNumberOfDelaysDueToSecurity;
	}

	public void setHighestNumberOfDelaysDueToSecurity(Long highestNumberOfDelaysDueToSecurity) {
		this.highestNumberOfDelaysDueToSecurity = highestNumberOfDelaysDueToSecurity;
	}

	public Long getLowestNumberOfDelaysDueToSecurity() {
		return lowestNumberOfDelaysDueToSecurity;
	}

	public void setLowestNumberOfDelaysDueToSecurity(Long lowestNumberOfDelaysDueToSecurity) {
		this.lowestNumberOfDelaysDueToSecurity = lowestNumberOfDelaysDueToSecurity;
	}

	public HashMap<String, AirportReport> geAirportReport() {
		return airportReport;
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
