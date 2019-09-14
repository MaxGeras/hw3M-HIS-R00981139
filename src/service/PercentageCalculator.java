package service;

/**
 * 
 * @author Max
 *
 */
public class PercentageCalculator {
	
	/**
	 * Calculate percentage based on the ariline's reports 
	 * 
	 * @param obtained
	 * @param total
	 * @return calculated percent
	 */
	  public double calculatePercentage(final double obtained,final double total) {
	        return obtained * 100 / total;
	    }
}
