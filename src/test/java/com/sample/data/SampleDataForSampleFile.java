package com.sample.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class SampleDataForSampleFile {

	static FileWriter writer;
	static String fileDestintaion = "test-output/sample-files/";

	// SampleFileHeader sampleHeader;

	@Test
	public static void creationColumn() throws IOException {
		writer = new FileWriter("E:/Adobe Campaign/" + "file_sdq.txt");

		List<String> column = new ArrayList<String>();
		column.add("123456");
		column.add("Test Data Purcahse");
		column.add("Test Data");
		column.add("2018-01-19");
		column.add("2018-02-19");
		column.add("2018-03-19");
		column.add("123456789");
		column.add("2018-09-19T17:34:40.000Z");

		int totalColumn = column.size();
		int totalHeader = SampleFileHeader
				.Cosmos_Sephora_Cust_Community_Metrics().size();

		for (int header = 0; header < totalHeader; header++) {
			writer.append(SampleFileHeader
					.Cosmos_Sephora_Cust_Community_Metrics().get(header));
			if (header != totalHeader - 1) {
				writer.append("|");
			}
		}

		writer.write(System.getProperty("line.separator"));
		for (int i = 0; i < totalColumn; i++) {
			writer.append(column.get(i));
			if (i != totalColumn-1) {
				writer.append("|");
			}
		}

		writer.close();
		System.out.println("File Created successfully: ");

	}

	public static void Cosmos_Sephora_Cust_Purchase_Metrics()
			throws IOException {
		String filename = "Cosmos_Sephora_Cust_Purchase_Metrics";
		writer = new FileWriter(fileDestintaion + filename + "_sdq.txt");
		int headerSize = SampleFileHeader
				.Cosmos_Sephora_Cust_Purchase_Metrics().size();
		// Print Header of the file
		for (int col = 0; col < headerSize; col++) {
			writer.append(SampleFileHeader
					.Cosmos_Sephora_Cust_Purchase_Metrics().get(col));
			writer.append("Þ");
		}
		// print sample files
		writer.write(System.getProperty("line.separator"));
		for (int col = 0; col < headerSize; col++) {
			for (int row = 0; row < 1; row++) {

				writer.append("123456" + col);
				writer.append("Þ");
				writer.append("Test Data Purcahse");
				writer.append("Þ");
				writer.append("Test Data");
				writer.append("Þ");
				writer.append("2018-01-19");
				writer.append("Þ");
				writer.append("2018-02-19");
				writer.append("Þ");
				writer.append("2018-03-19");
				writer.append("Þ");
				writer.append("123456789");
				writer.append("Þ");
				writer.append("2018-09-19T17:34:40.000Z");
			}
			writer.write(System.getProperty("line.separator"));
		}
		writer.close();
		System.out.println(filename + "file created successfully");
	}

	public static void Cosmos_Sephora_Cust_Classes_Metrics() throws IOException {
		String fileName = "Cosmos_Sephora_Cust_Classes_Metrics";
		writer = new FileWriter(fileDestintaion + fileName + "_sdq.txt");
		int headerSize = SampleFileHeader.Cosmos_Sephora_Cust_Classes_Metrics()
				.size();
		// Print Header of the file
		for (int col = 0; col < headerSize; col++) {
			writer.append(SampleFileHeader
					.Cosmos_Sephora_Cust_Classes_Metrics().get(col));
			writer.append("Þ");
		}
		writer.write(System.getProperty("line.separator"));
		// Print Sample file values
		for (int col = 0; col < headerSize; col++) {
			for (int row = 0; row < 1; row++) {
				writer.append("123456" + col);
				writer.append("Þ");
				writer.append("Test Data");
				writer.append("Þ");
				writer.append("Test Data");
				writer.append("Þ");
				writer.append("1234567");
				writer.append("Þ");
				writer.append("2018-09-09T17:34:40.000Z");
			}
			writer.write(System.getProperty("line.separator"));
		}
		writer.close();
		System.out.println(fileName + "File created succefully ");
	}

	public static void Cosmos_Sephora_Cust_Campaign_Metrics()
			throws IOException {
		String fileName = "Cosmos_Sephora_Cust_Campaign_Metrics";
		writer = new FileWriter(fileDestintaion + fileName + "_sdq.txt");
		int headerSize = SampleFileHeader.Cosmos_Sephora_Cust_Classes_Metrics()
				.size();
		// Print Header of the file
		for (int col = 0; col < headerSize; col++) {
			writer.append(SampleFileHeader
					.Cosmos_Sephora_Cust_Campaign_Metrics().get(col));
			writer.append("Þ");
		}
		writer.write(System.getProperty("line.separator"));
		// Print Sample file values
		for (int col = 0; col < headerSize; col++) {
			for (int row = 0; row < 1; row++) {
				writer.append("123456" + col);
				writer.append("Þ");
				writer.append("Test Data ");
				writer.append("Þ");
				writer.append("Test Campaign channel");
				writer.append("Þ");
				writer.append("Test Event Type");
				writer.append("Þ");
				writer.append("232");
				writer.append("Þ");
				writer.append("2018-09-09T17:34:40.000Z");
			}
			writer.write(System.getProperty("line.separator"));
		}
		writer.close();
		System.out.println(fileName + "File created succefully ");
	}

	public static void Cosmos_Sephora_Cust_Community_Metrics()
			throws IOException {
		String fileName = "Cosmos_Sephora_Cust_Community_Metrics";
		writer = new FileWriter(fileDestintaion + fileName + "_sdq.txt");
		int headerSize = SampleFileHeader
				.Cosmos_Sephora_Cust_Community_Metrics().size();
		// Print Header of the file
		for (int col = 0; col < headerSize; col++) {
			writer.append(SampleFileHeader
					.Cosmos_Sephora_Cust_Community_Metrics().get(col));
			writer.append("Þ");
		}
		writer.write(System.getProperty("line.separator"));
		// Print Sample file values
		for (int col = 0; col < headerSize; col++) {
			for (int row = 0; row < 1; row++) {
				writer.append("123456" + col);
				writer.append("Þ");
				writer.append("Test Data Reporting peried ");
				writer.append("Þ");
				writer.append("Test Group Name");
				writer.append("Þ");
				writer.append("Test group action type");
				writer.append("Þ");
				writer.append("2018-09-09");
				writer.append("Þ");
				writer.append("11234556");
				writer.append("Þ");
				writer.append("2018-09-09T17:34:40.000Z");
			}
			writer.write(System.getProperty("line.separator"));
		}
		writer.close();
		System.out.println(fileName + "File created succefully ");
	}

}
