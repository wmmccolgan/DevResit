package supplementary;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Start point for the app. Reads in data from csv file and then presents a menu
 * with several functions - searches and a thread based write to file.
 * 
 * @author << PUT YOUR NAME AND STUDENT NUMBER HERE>>
 *
 */
public class StartApp {

	// container that holds the cities - note this is static


	public static List<City> cities = new ArrayList<City>();

	/**
	 * Start point for app
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		readData();
		showMenu();

		
	}

	/**
	 * Shows the menu and Coordinates the searches and file write
	 * 
	 * @throws Exception
	 */
	public static void showMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();

		int option;

		do {
			System.out.println("1. Display all City data ");
			System.out.println("2. Display all EU cities (descending order)");
			System.out.println("3. Display City name and crime rate by population ");
			System.out.println("4. Display City with highest population ");
			System.out.println("5. Write to file all cities in EET timezone (new thread needed)  ");
			System.out.println("6. Quit");
			System.out.println("Enter option ...");
			try {
				option = scanner.nextInt();
			} catch (Exception exception) {
				// user input issue... default to zero and carry on (would be reasonable to
				// expect the system to recover from this)
				option = 0;
				
				//can modify here if further information about exceptions is required during development/testing
				//eg printing exception messages etc.
				
				// need to flush buffer
				scanner.nextLine();
			}

			// menu options processing
			switch (option) {

			case 1:
				// all city data
				System.out.println("All City data");
				
				AllCityData(cities);
				
				System.out.println();
				break;
			case 2:
				// all EU cities
				System.out.println("All EU cities ");
				CityDatabyStatus(cities,Status.EU);
				
				
				break;
			case 3:
				// crime rate
				
				CrimeRatePerPop(cities);
				
				break;
			case 4:
				// population
				TopCitySortedbyPop(cities);
				break;
			case 5:
				// write to file
				// a bit more to this. Create thread. Also filer for Time Zone.
				WriteToFileThreadCityZone(cities, TimeZone.EET);
				
				
				break;

			case 6:
				System.out.println("Quitting");
				break; // rem. need the break here too !
			default:
				System.out.println("Try options again...");
			}
		} while (option != 6);

		
		scanner.close();
	}
	
	

	/**
	 * Reads in the data from the csv (hard coded path) and maps to the City class
	 * Populates static list of City objects declared at the top of this class
	 * 
	 * @throws Exception
	 */
	public static void readData() {

		System.out.println("Loading data...");
		
		
		
		File file = new File("city_data.csv");
	
		
		try {
			
			FileReader FR = new FileReader(file);
			BufferedReader BR = new BufferedReader(FR);
		
		
			String line = BR.readLine();
			line = BR.readLine(); // As file has header row, this repeat discards the header
			
			while (line != null) {; // continue until EOF
			
			
			String [] parts = line.split(","); // comma seperates element on each line of source file
		
			String CityName = parts[0];
			String Country = parts[1];
			int population = Integer.parseInt(parts[2]);
			
			Status status = Status.EU; // default to EU will be correct for most of data set. Safer assumption
			
				if (parts[3].equals("0")){    // logic to flip status for execptions
					status = Status.NON_EU;
				}
				
					
			int crimes = Integer.parseInt(parts[4]);
			TimeZone timezone = TimeZone.valueOf(parts[5]);  // need to come back and some exception for "Prague problem"
															// Maybe validation on setters will handle?
			
			City Strabane = new City(CityName, Country, population, status, crimes, timezone);
			
			//TODO exception block for failing validation should close here before writing to Collection
			//come back and complete when validation is implemented
			
			cities.add(Strabane);
			
			line = BR.readLine(); //advance to subsequent line in file until EOF
		
		//BR.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	
	/**
	 * @param 
	Pretty straightforward as expected format conforms to "to string"?
		
	 */
	private static void AllCityData(List<City> cities2) {

		int County = 1;
		
		for (City Printy : cities2) {
			System.out.println(County+")");
			System.out.println(Printy.toString());
			System.out.println();
			County++;	
			
		}
		
	}


	/**
	 * @param cities2
	 * @param eu
	 * 
	 * More or less same as above, but filter set for sent status
	 * 
	 * 
	 */
	private static void CityDatabyStatus(List<City> cities2, Status eu) {
		// As prior method, but first create new ArrayList and only add to it 
		//	Sort that ArrayList by City Name Descending ( Amsterdam to Zagreb for our data)
		// Cities which confirm to the sent Status (i.e. excludes London and Oslo from our data)
		
		List<City> OneStatus = new ArrayList<City>();
		
		for (City TryMe : cities2) {
			if(TryMe.getStatus().equals(eu)) {
				OneStatus.add(TryMe);
			}
		}
			Collections.sort(OneStatus, new CompareByCityNameDESC());
		
			int County = 1;
			
			for (City Printy : OneStatus) {
				System.out.println(County+")");
				System.out.println(Printy.toString());
				System.out.println();
				County++;	
				
			}
		
		
		
		
	}
	

	/**
	 * @param cities2
	 *
	 * Wee calculation in this one/
	 *Dublin looks like an outlier for sure. Reasonable. 
	 *Need to validate and Handle the likes of Denmark
	 *Definitely some kind of float for the result
	 *Maybe a printF?
	 */
	private static void CrimeRatePerPop(List<City> cities2) {

		int CityPop = 0;
		int CityCrime = 0;		
		Double CrimeRate = (double) 0;
		
		System.out.println("City\t\tCrime rate (per 1000 of population)");
		
		for (City HowBad : cities2) {
			
			if(HowBad.getPopulation()<1 || HowBad.getCrimes()<1) {
				System.out.println(HowBad.getCityName()+"\t: Data not valid to provide figure");
			}else {
				CrimeRate = (double) (HowBad.getPopulation()/HowBad.getCrimes());
				System.out.print(HowBad.getCityName()+"\t\t\t: ");
				System.out.printf("%.2f%n",CrimeRate);
				
			}
			
			
			
			
		}
		
	}
	

	/**
	 * @param cities2
	
	 * Either Sort the whole list, or just return the max by Pop 
	 */
	
	private static void TopCitySortedbyPop(List<City> cities2) {

		ArrayList <City> PopList = new ArrayList<City>(cities2);
		City BigCity = new City();
				
		BigCity = Collections.max(PopList, new CompareByPopulation());
		
		System.out.print("The City with the largest Populations is : ");
		System.out.println(BigCity.getCityName());
		System.out.println("____________________________");
		System.out.println();
		
	}
	



	/**
	 * @param cities2
	 * @param eet
	 */
	private static void WriteToFileThreadCityZone(List<City> cities2, TimeZone eet) {
		// TODO Auto-generated method stub
		
	
		ArrayList<City> OneZone = new ArrayList<City>();
		
		for (City SameZone : cities2) {
			if(SameZone.getTimezone().equals(eet)) {
				OneZone.add(SameZone);
			}
		}
		
		WriterThread writer = new WriterThread(OneZone);
		Thread thread = new Thread(writer);
		thread.start();
		
	}
	
	
	
}