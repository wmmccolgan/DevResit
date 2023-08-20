/**
 * 
 */
package supplementary;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Author William McColgan 40397482
 */
public class WriterThread implements Runnable {

	private List<City> CityList;
	
	public WriterThread (List<City> CityList) {
		
		this.CityList = CityList;
		
		
		
	}
	
	
	
	
	@Override
	public void run() {
	
		
		try {
		
		File file = new File ("TimeZoneCities.csv");
		FileWriter FW = new FileWriter(file);
		BufferedWriter BW = new BufferedWriter(FW);
		
		String header =("City_name,Country,Population");
		
			BW.write(header);
			BW.newLine();
			
		
		for (City Fodors : CityList) {
		

			String line = (Fodors.getCityName().toUpperCase()+","+Fodors.getCountry()+","+Fodors.getPopulation());			
			BW.write(line);
			BW.newLine();
			
			
			
			
		}
		
		BW.close();
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
