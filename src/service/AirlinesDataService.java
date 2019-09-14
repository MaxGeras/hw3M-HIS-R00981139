package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import modal.Airline;
import modal.AirlinesDataSetReport;
import modal.Airport;
import modal.AirportReport;

/**
 * 
 * @author Max
 *
 */
public class AirlinesDataService {
	private static String UTF_8 = "UTF-8";
	private static String FILE_PATH = "C:/Users/Maksym/Desktop/airlines";
	private static List<String> XML_ELEMENTS = Collections.unmodifiableList(
			Arrays.asList(
					"totalNumberOfAirports", 
					"totalNumberOfFlights",
					"percentageOfTotalFlightsDelayedBySecurity",
					"percentageOfTotalFlightsDelayedByCarrier",
					"percentageOfTotalFlightsDelayedByNationalAviationSystem",
					"airportWithTheHighestNumberOfDelaysDueToSecurity",
					"airportWithTheLowestNumberOfDelaysDueToSecurity",
					"airportWithTheMostTotalFlights"
			));
	
	private PercentageCalculator percentageCalculator;
	
	
	public AirlinesDataService() {
		this.percentageCalculator = new PercentageCalculator();
	}
	
	/**
	 * Read the data from the file and serialize to Airline java object.
	 */
	public void processAirlinesData() {
		File file = new File(FILE_PATH);
		try(JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), UTF_8))) {
			AirlinesDataSetReport airlinesDataSetReport = new AirlinesDataSetReport();
			Gson gson = new GsonBuilder().create();

		    jsonReader.beginArray();
		    // Read each record at a time
		    while (jsonReader.hasNext()){
		        generateAirlinesReport(gson.fromJson(jsonReader, Airline.class), airlinesDataSetReport);
		    }
		    generateXMLschema(airlinesDataSetReport);
		    
		    System.out.println(airlinesDataSetReport.getTotalNumDueToCarrier());
		    System.out.println(airlinesDataSetReport.getTotalNumDueToNas());
		    System.out.println(airlinesDataSetReport.getTotalNumDueToSecurity());
		    System.out.println(airlinesDataSetReport.getTotalNumOfFlights());
		    System.out.println(airlinesDataSetReport.geAirportReport().size());
		}catch (UnsupportedEncodingException ex) {
		    ex.printStackTrace();
		} catch (FileNotFoundException ex) {
		    ex.printStackTrace();
		} catch (IOException ex) {
		    ex.printStackTrace();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param airline
	 * @param airlinesDataSetReport
	 */
	private void generateAirlinesReport(final Airline airline, AirlinesDataSetReport airlinesReport) {
		try {
			assert(airline != null);
			assert(airlinesReport != null);
			if (airlinesReport != null && airline != null) {
				// Create a new report
				AirportReport newReport = new AirportReport();
				
				// Set an airport name
				if (airline.getAirport() != null) {
					if (airline.getAirport().getName() != null && !airline.getAirport().getName().isEmpty()) {
						newReport.setAirportName(airline.getAirport().getName());
					}
				}
				
				// Calculate statistics
				if (airline.getStatistics() != null) {
					if (airline.getStatistics().getFlights() != null && airline.getStatistics().getFlights().getTotal() > 0) {
						airlinesReport.setTotalNumOfFlights(airlinesReport.getTotalNumOfFlights() + 
								airline.getStatistics().getFlights().getTotal());
						newReport.setTotalFlights(airline.getStatistics().getFlights().getTotal());
					}
					
					if (airline.getStatistics().getNumbersOfDelays() != null) {
						if (airline.getStatistics().getNumbersOfDelays().getCarrier() > 0) {
							airlinesReport.setTotalNumDueToCarrier(airlinesReport.getTotalNumDueToCarrier() + 
									airline.getStatistics().getNumbersOfDelays().getCarrier());
						}
						if (airline.getStatistics().getNumbersOfDelays().getSecurity() > 0) {
							airlinesReport.setTotalNumDueToSecurity(airlinesReport.getTotalNumDueToSecurity() + 
									airline.getStatistics().getNumbersOfDelays().getSecurity());
							newReport.setNumOfDelaysDueToSecurity(airline.getStatistics().getNumbersOfDelays().getSecurity());
						}
						if (airline.getStatistics().getNumbersOfDelays().getNationalAviationSystem() > 0) {
							airlinesReport.setTotalNumDueToNas(airlinesReport.getTotalNumDueToNas() + 
									airline.getStatistics().getNumbersOfDelays().getNationalAviationSystem());
						}
					}
				}
				
				// Insert new report or update an existing report of the airport
				if (airlinesReport.geAirportReport().isEmpty() || !airlinesReport.geAirportReport().containsKey(newReport.getAirportName())) {
					airlinesReport.geAirportReport().put(newReport.getAirportName(), newReport);
				} else {
					AirportReport existingReport = airlinesReport.geAirportReport().get(newReport.getAirportName());
					existingReport.setNumOfDelaysDueToSecurity(existingReport.getNumOfDelaysDueToSecurity() + newReport.getNumOfDelaysDueToSecurity());
					existingReport.setNumOfDelaysDueToSecurity(existingReport.getTotalFlights() + newReport.getTotalFlights());
					
					// Updated successfully
					assert(airlinesReport.geAirportReport().replace(existingReport.getAirportName(), existingReport) != null);
				}
			}
		} catch (Exception ex) {
			  ex.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param airlinesReport
	 */
	private void generateXMLschema(final AirlinesDataSetReport airlinesReport) {
		  try {
		        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		        Document doc = docBuilder.newDocument();
		        // students root element
		        Element rootElement = doc.createElement("airlines");
		        doc.appendChild(rootElement);
		        
		        int index = 0;
		        for (final String xmlElement: XML_ELEMENTS) {
		        	buildXmlElement(xmlElement, rootElement, airlinesReport, doc, ++index);
		        }
		        
		        // Write the content into XML file
		        DOMSource source = new DOMSource(doc);
		        StreamResult result = new StreamResult(new File("students-new.xml"));
		        
		        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        // Beautify the format of the resulted XML
		        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		        transformer.transform(source, result);
		    } catch(Exception ex) {
		        ex.printStackTrace();
		    }
		
	}
	
	private void buildXmlElement(final String xmlElement, Element rootElement, final AirlinesDataSetReport airlinesReport, Document doc, final int index) {
	   Element stat = doc.createElement("stats");
	   Element element = doc.createElement(xmlElement);
    
		switch (xmlElement) {
			case "totalNumberOfAirports":
				element.setTextContent(String.valueOf(airlinesReport.geAirportReport().size()));
				break;
			case "totalNumberOfFlights":
				element.setTextContent(String.valueOf(airlinesReport.getTotalNumOfFlights()));
				break;
			case "percentageOfTotalFlightsDelayedBySecurity":
				element.setTextContent(String.valueOf(percentageCalculator.calculatePercentage(airlinesReport.getTotalNumDueToSecurity(), 
						airlinesReport.getTotalNumOfFlights())));
				break;
			case "percentageOfTotalFlightsDelayedByCarrier":
				element.setTextContent(String.valueOf(percentageCalculator.calculatePercentage(airlinesReport.getTotalNumDueToSecurity(), 
						airlinesReport.getTotalNumOfFlights())));
				break;
			case "percentageOfTotalFlightsDelayedByNationalAviationSystem":
				element.setTextContent(String.valueOf(percentageCalculator.calculatePercentage(airlinesReport.getTotalNumDueToNas(), 
						airlinesReport.getTotalNumOfFlights())));
				break;
			case "airportWithTheHighestNumberOfDelaysDueToSecurity":
				List<Map.Entry<String, AirportReport>> entryLastList = new ArrayList<Map.Entry<String, AirportReport>>( airlinesReport.geAirportReport().entrySet());
	            Collections.sort( entryLastList, new Comparator<Map.Entry<String, AirportReport>>() {
	                @Override
		                public int compare(Map.Entry<String, AirportReport> obj1, Map.Entry<String, AirportReport> obj2) {
		                    return obj1.getValue().getNumOfDelaysDueToSecurity().compareTo(obj2.getValue().getNumOfDelaysDueToSecurity());
		                }
		            }
		        );

				Map.Entry<String,AirportReport> lastEntry = entryLastList.get(entryLastList.size() - 1);
				AirportReport lastReport = lastEntry.getValue();
				element.setTextContent(String.valueOf(lastReport.getNumOfDelaysDueToSecurity()));
				break;
			case "airportWithTheLowestNumberOfDelaysDueToSecurity":
				List<Map.Entry<String, AirportReport>> entryFirstList = new ArrayList<Map.Entry<String, AirportReport>>( airlinesReport.geAirportReport().entrySet());
	            Collections.sort( entryFirstList, new Comparator<Map.Entry<String, AirportReport>>() {
	                @Override
		                public int compare(Map.Entry<String, AirportReport> obj1, Map.Entry<String, AirportReport> obj2) {
		                    return obj1.getValue().getNumOfDelaysDueToSecurity().compareTo(obj2.getValue().getNumOfDelaysDueToSecurity());
		                }
		            }
		        );

				Map.Entry<String,AirportReport> firstEntry = entryFirstList.get(0);
				AirportReport secReport = firstEntry.getValue();
				element.setTextContent(String.valueOf(secReport.getNumOfDelaysDueToSecurity()));
				break;
			case "airportWithTheMostTotalFlights":
				List<Map.Entry<String, AirportReport>> entryList = new ArrayList<Map.Entry<String, AirportReport>>( airlinesReport.geAirportReport().entrySet());
	            Collections.sort( entryList, new Comparator<Map.Entry<String, AirportReport>>() {
	                @Override
		                public int compare(Map.Entry<String, AirportReport> obj1, Map.Entry<String, AirportReport> obj2) {
		                    return obj1.getValue().getTotalFlights().compareTo(obj2.getValue().getTotalFlights());
		                }
		            }
		        );

				Map.Entry<String,AirportReport> entry = entryList.get(entryList.size() - 1);
				AirportReport report = entry.getValue();
				element.setTextContent(String.valueOf(report.getTotalFlights()));
				break;
		}
		
       stat.setAttribute("id", String.valueOf(index));
       stat.appendChild(element);
       
       rootElement.appendChild(stat);
	}
	
	
}
