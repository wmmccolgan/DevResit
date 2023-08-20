/**
 * 
 */
package supplementary;

import java.util.Comparator;

/**
 * 
 * Author William McColgan 40397482
 * 
 */
public class CompareByPopulation implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		// TODO Auto-generated method stub
		return (o1.getPopulation()- o2.getPopulation());
	}

}
