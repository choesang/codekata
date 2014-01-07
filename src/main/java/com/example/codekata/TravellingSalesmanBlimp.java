package com.example.codekata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TravellingSalesmanBlimp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numberOfCities = in.nextInt();
		int blimpCostPerMile = in.nextInt();
		double blimpFactorOfDecline = in.nextDouble();
		
		List<City> cities = new ArrayList<City>();
		for (int i = 0; i < numberOfCities; i++) {
			cities.add(new City(in.nextInt(), in.nextInt(), in.nextInt()));
		}
		
		sortByDistanceFromOrigin(cities);
		
		computeMoves(cities, blimpCostPerMile, blimpFactorOfDecline);
	}
	
	private static void computeMoves(List<City> cities, int blimpCostPerMile, double blimpFactorOfDecline) {
		
		int numberOfBlimps = 1;
		
		Iterator<City> iterator = cities.iterator();
		while (iterator.hasNext()) {
			
			City city1 = iterator.next();
			double costOfBlimps1 = costOfBlimps(numberOfBlimps, blimpCostPerMile, city1);
			System.out.println(city1.toString() + " Price-Cost1 " + (city1.initialBlimpPrice-costOfBlimps1) + " numberOfBlimps " + numberOfBlimps);
			
			
			City city2 = iterator.next();
			double costOfBlimps2 = costOfBlimps(numberOfBlimps++, blimpCostPerMile, city2);
			System.out.println(city2.toString() + " Price-Cost2 " + (city2.initialBlimpPrice-costOfBlimps2) + " numberOfBlimps " + numberOfBlimps);
		}
		
	}

	private static double costOfBlimps(int numberOfBlimps, int blimpCostPerMile, City city) {
		double denominator = numberOfBlimps * city.distance;
		return blimpCostPerMile / denominator;
	}

	private static List<City> sortByDistanceFromOrigin(List<City> cities) {
		City origin = new City(0, 0, 0);
		
		Iterator<City> iterator = cities.iterator();
		
		while (iterator.hasNext()) {  
			City city = iterator.next();
			city.distance = computeDistance(origin, city);
			
			if (pruneCostIneffectiveCities(city)) {
				iterator.remove();
			}
		}
		
		orderByDistanceAndPrice(cities);
		
		return cities;
//		printList(cities); 
	}

	private static boolean pruneCostIneffectiveCities(City city) {
		if ( Math.floor(city.initialBlimpPrice / city.distance) == 0 ) {
			return true;
		}
		return false;
	}

	private static void orderByDistanceAndPrice(List<City> cities) {
		Collections.sort(cities, new Comparator<City>() {
			@Override
			public int compare(City c1, City c2) {
				Double d1 = c1.distance;
				Double d2 = c2.distance;
				
				int firstComparision = d1.compareTo(d2);
				
				if (firstComparision != 0) {
					return firstComparision;
				} else {
					Integer p1 = c1.initialBlimpPrice;
					Integer p2 = c2.initialBlimpPrice;
					return p1.compareTo(p2);
				}
			}
		});
	}

	private static void printList(List<City> cities) {
		for (City city : cities) {
			System.out.print("Distance for x:" + city.x + " y:" + city.y + " distance: " + city.distance + " price: " + city.initialBlimpPrice );
			System.out.println(" COST: " + Math.floor(city.initialBlimpPrice / city.distance) );
		}
	}

	private static double computeDistance(City origin, City city) {
		int x = city.x - origin.x;
		int y = city.y - origin.y;
		return Math.sqrt(x*x + y*y);
	}

	static class City{
		int x, y, initialBlimpPrice;
		double distance;

		public City(int x, int y, int initialBlimpPrice) {
			super();
			this.x = x;
			this.y = y;
			this.initialBlimpPrice = initialBlimpPrice;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "City [x=" + x + ", y=" + y + ", initialBlimpPrice="
					+ initialBlimpPrice + ", distance=" + distance + "]";
		}
		
		
	}

}
