package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	//Default Constructor
		public CSVReader() {
			
		}
		
		public static String[][] fileReader(String file) {
			ArrayList<String[]> cSV = new ArrayList<String[]>();
			int width = 0;
			try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
				String line = bufReader.readLine(); 
				width = line.split(",").length;
				
				while (line != null) { 
					cSV.add(line.split(","));
					line = bufReader.readLine();
				}
				
				} catch (IOException e) {
				
			}
			String [][] finalCSV = new String[cSV.size()][width];
			finalCSV = cSV.toArray(finalCSV);
			return finalCSV;
		}
		
}
