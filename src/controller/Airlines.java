package controller;

import service.AirlinesDataService;

/**
 * Process data set and output the calculated data points in an XML schema that I defined
 * @author Max
 *
 */
public class Airlines {

	public static void main(String[] args) {
		// Generate report
		AirlinesDataService airlinesDataService = new AirlinesDataService();
		airlinesDataService.processAirlinesData();
		System.exit(0);
	}
}
