/**
 * Author William McColgan 40397482
 */
package supplementary;

import java.util.Comparator;

/**
 * 
 */
public class CompareByCityNameDESC implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		// Verify taht reversing order of o1 and o2 results in descending (Amsterdam - Zagreb) 
		return (o1.getCityName().compareTo(o2.getCityName()));
	}

}
