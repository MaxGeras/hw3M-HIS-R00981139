package service;

/**
 * 
 * @author Max
 *
 */
public class PercentageCalculator {
	
	/**
	 * 
	 * @param obtained
	 * @param total
	 * @return
	 */
	  public double calculatePercentage(double obtained, double total) {
	        return obtained * 100 / total;
	    }
}
