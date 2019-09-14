package service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

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

}
