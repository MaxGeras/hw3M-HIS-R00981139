package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import modal.AirlinesDataSetReport;
import modal.AirportReport;

/**
 * 
 * @author Max
 *
 */
public class SortReportData {
 
	/**
	 * 
	 * @param <K>
	 * @param <V>
	 * @param report
	 * @return
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> reportSortByValue(Map<K, V> report) {
 
		Map<K, V> reportResult = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = report.entrySet().stream();
 
		// comparingByValue() returns a comparator that compares Map.Entry in natural order on value.
		sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> reportResult.put(c.getKey(), c.getValue()));
		return reportResult;
	}
	
	/**
	 * Sort from lowest to highest by numbers of 
	 * delays due to security  
	 * 
	 * @param airlinesReport
	 */
	public static void sortAirportsByDelaysDueToSecurity(AirlinesDataSetReport airlinesReport) {
		final List<Map.Entry<String, AirportReport>> entryList = new ArrayList<Map.Entry<String, AirportReport>>( airlinesReport.geAirportReport().entrySet());
        Collections.sort( entryList, new Comparator<Map.Entry<String, AirportReport>>() {
            @Override
                public int compare(Map.Entry<String, AirportReport> obj1, Map.Entry<String, AirportReport> obj2) {
                    return obj1.getValue().getNumOfDelaysDueToSecurity().compareTo(obj2.getValue().getNumOfDelaysDueToSecurity());
                }
            }
        );

        // We should have data
        assert(entryList == null);
        
		airlinesReport.setAirportWithHighestNumberOfDelaysDueToSecurity(entryList.get(entryList.size() - 1).getValue().getAirportName());
		airlinesReport.setAirportWithLowestNumberOfDelaysDueToSecurity(entryList.get(0).getValue().getAirportName());
	}
	
	/**
	 * Sort from lowest to highest by numbers of 
	 * total flights
	 * 
	 * @param airlinesReport
	 */
	public static void findAirportWithTheMostTotalFlights(AirlinesDataSetReport airlinesReport) {
		final List<Map.Entry<String, AirportReport>> entryList = new ArrayList<Map.Entry<String, AirportReport>>(airlinesReport.geAirportReport().entrySet());
        Collections.sort( entryList, new Comparator<Map.Entry<String, AirportReport>>() {
            @Override
                public int compare(Map.Entry<String, AirportReport> obj1, Map.Entry<String, AirportReport> obj2) {
                    return obj1.getValue().getTotalFlights().compareTo(obj2.getValue().getTotalFlights());
                }
            }
        );
        airlinesReport.setAirportWithTheMostTotalFlights(entryList.get(entryList.size() - 1).getValue().getAirportName());
	}

}
