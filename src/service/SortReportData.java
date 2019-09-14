package service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SortReportData {
 
	// Let's sort HashMap by Value
	public static <K, V extends Comparable<? super V>> Map<K, V> reportSortByValue(Map<K, V> report) {
 
		Map<K, V> reportResult = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = report.entrySet().stream();
 
		// comparingByValue() returns a comparator that compares Map.Entry in natural order on value.
		sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> reportResult.put(c.getKey(), c.getValue()));
		return reportResult;
	}

}
