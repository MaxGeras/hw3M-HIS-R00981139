package modal;

import java.util.Collection;
import java.util.HashMap;

/**
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

	/**
	 * Initialize data
	 */
	public AirlinesDataSetReport() {
		this.airportReport = new HashMap<String, AirportReport>();
		this.totalNumOfFlights = (long) 0;
		this.totalNumDueToSecurity = (long)0;
		this.totalNumDueToCarrier=(long) 0;
		this.totalNumDueToNas =(long) 0;
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
