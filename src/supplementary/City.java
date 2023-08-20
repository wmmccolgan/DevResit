/**
 * Author William McColgan 40397482
 */
package supplementary;

/**
 * 
 * Basic unit CIty, to conatin elements from csv file and be processed throughout
 * 
 * 
 * 
 */
public class City {

	private String CityName;
	private String Country;
	private int population;
	private Status status;
	private int crimes;
	private TimeZone timezone;
	
	
	

	/**
	//Constructor with fields
	Routed through setters to apply validation
	
	 * @param cityName
	 * @param country
	 * @param population
	 * @param status
	 * @param crimes
	 * @param timezone
	 */
	public City(String cityName, String country, int population, Status status, int crimes, TimeZone timezone) {
		

		this.setCityName(cityName); 
		this.setCountry(country); 
		this.setPopulation(population); 
		this.setStatus(status);
		this.setCrimes(crimes); 
		this.setTimezone(timezone);
	}


/// come back and add validation

	/**
	 * Default Constructor
	 */
	public City() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return CityName;
	}




	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) throws IllegalArgumentException {
		
		if(cityName!= null && cityName.length()<=50 && cityName.length()>0) {
		
		CityName = cityName;
	} else {
		throw new IllegalArgumentException("Invalid Name field");
	}
	}




	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}




	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) throws IllegalArgumentException {
		
		if(country!= null && country.length()<=40 && country.length()>0) {
		Country = country;
			} else {
			throw new IllegalArgumentException("Invalid Country field");
		}
	}




	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}




	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) throws IllegalArgumentException{
		if(this.population<1000000) {
		
		this.population = population;
	}else {
		throw new IllegalArgumentException("Invalid population");
	}
	}




	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) throws IllegalArgumentException{
		
//		if(this.status.equals(status.EU)||this.status.equals(status.NON_EU)) {
		
		this.status = status;
		
//	}else {
//		throw new IllegalArgumentException("Invalid population");
//	}

	}


	/**
	 * @return the crimes
	 */
	public int getCrimes() {
		return crimes;
	}




	/**
	 * @param crimes the crimes to set
	 */
	public void setCrimes(int crimes) {
		this.crimes = crimes;
	}




	/**
	 * @return the timezone
	 */
	public TimeZone getTimezone() {
		return timezone;
	}




	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}


	@Override
	public String toString() {
		return "City [CityName=" + CityName + ", Country=" + Country + ", population=" + population + ", status="
				+ status + ", crimes=" + crimes + ", timezone=" + timezone + "]";
	}
	
	
	
	public void printCityName() {
		
		System.out.println(CityName);
			
		}
	
	
	
	
	
	
	
	
	
	
}
