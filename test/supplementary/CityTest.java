/**
 * Author William McColgan 40397482
 */
package supplementary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class CityTest {

	/**
	 * @throws java.lang.Exception
	
	 *
	 *Test data
	 */
	
	String ValidCityName, InvalidCityName, ValidCountryName, InValidCountryName ;
	int ValidPopulation, InvalidPopulationHigh;
	Status ValidStatus1, ValidStatus2, InvalidStatus;
	int ValidCrimes, InvalidCrimesHigh;
	TimeZone ValidTZ1, ValidTZ2, ValidTZ3, ValidTZ4, InvalidTZ;
	
	
	@BeforeEach
	void setUp() throws Exception {
	
	ValidCityName = "Belfast";
	InvalidCityName = "whethertisnoblerinthemindsofmentosuffertheslingsandarrowsofoutrageousfortune";
	ValidCountryName = "Canada";
	InValidCountryName = "theyfuckyouupyourmumanddadtheydonotmeantobuttheydo";
	ValidPopulation = 1234567;
	InvalidPopulationHigh = 1234567891;
	ValidStatus1 = Status.EU;
	ValidStatus2 = Status.NON_EU;
	InvalidStatus = Status.valueOf("NorthernIreland");
	ValidCrimes = 4654;
	InvalidCrimesHigh = 123456789;
	ValidTZ1 = TimeZone.CET;
	ValidTZ2 = TimeZone.EET;
	ValidTZ3 = TimeZone.GMT;
	ValidTZ4 = TimeZone.WET;
	//InvalidTZ = TimeZone.XCET;
	
	
	}
	/**
	 * Test method for {@link supplementary.City#City(java.lang.String, java.lang.String, int, supplementary.Status, int, supplementary.TimeZone)}.
	 */
	@Test
	void testCityStringStringIntStatusIntTimeZone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#City()}.
	 */
	@Test
	void testCity() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getCityName()}.
	 */
	@Test
	void testGetCityName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setCityName(java.lang.String)}.
	 */
	@Test
	void testSetCityName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getCountry()}.
	 */
	@Test
	void testGetCountry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setCountry(java.lang.String)}.
	 */
	@Test
	void testSetCountry() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getPopulation()}.
	 */
	@Test
	void testGetPopulation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setPopulation(int)}.
	 */
	@Test
	void testSetPopulation() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getStatus()}.
	 */
	@Test
	void testGetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setStatus(supplementary.Status)}.
	 */
	@Test
	void testSetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getCrimes()}.
	 */
	@Test
	void testGetCrimes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setCrimes(int)}.
	 */
	@Test
	void testSetCrimes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#getTimezone()}.
	 */
	@Test
	void testGetTimezone() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link supplementary.City#setTimezone(supplementary.TimeZone)}.
	 */
	@Test
	void testSetTimezone() {
		fail("Not yet implemented");
	}

}
