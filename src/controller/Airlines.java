package controller;

import service.AirlinesDataService;

/**
 * Process data set and output the calculated data points in an XML schema that I defined
 * @author Max
 *
 */
public class Airlines {

	/**
	 * Run the application
	 * @AirlinesDataService implements the creation of the XML report
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// Generate an XML report
			new AirlinesDataService().processAirlinesData();
		} catch(Exception ex) {
			 ex.printStackTrace();
		}
	
		System.exit(0);
	}
}
