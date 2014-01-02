package com.example.codekata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StockPricePredictor {

	/**
	 * @param m
	 * @param k
	 * @param d
	 * @param name
	 * @param owned
	 * @param prices
	 */
	static void printTransactions(double m, int k, int d, String[] name, int[] owned, double[][] prices) {
		Stock stock;
		List<Stock> stockList = new ArrayList<Stock>();
		for (int i=0; i<k; i++) {
			stock = initalizeStock(i, prices[i], name[i], owned[i]);
			stockList.add(stock);
		}
		
		stockList = sortStockList(stockList);
		
		stockList = computeNumberOfStocksToBuy(m, stockList);
		
		printStocksToBuyAndSell(stockList);
	}

	/**
	 * @param stockList
	 */
	private static void printStocksToBuyAndSell(List<Stock> stockList) {
		System.out.println(stockList.size());
		for (Stock stock : stockList) {
			System.out.println(stock.name + " " + stock.transactionType + " " + stock.numberOfStocksForTransaction);
		}
	}

	/**
	 * @param money
	 * @param stockList
	 * @return
	 */
	private static List<Stock> computeNumberOfStocksToBuy(double money, List<Stock> stockList) {
		System.out.println("money: " + money);
		double valuePerStockPoint = computeValuePerStockPoint(money, stockList);
		
		printStocksToBuyAndSell(stockList);
		
		System.out.println("valuePerStockPoint: " + valuePerStockPoint);
		Iterator<Stock> iterator = stockList.iterator();
		while (iterator.hasNext()) {
			Stock stock = iterator.next();
			double currentPrice = stock.currentPrice;

			if (stock.points >= 0) {
//				BUY
				stock.transactionType = "BUY";
				double moneyForTheStock = 0;
				if (stock.points > 0) {
					moneyForTheStock = valuePerStockPoint * stock.points;
				} else {
					if (currentPrice/2 < money) {
						moneyForTheStock = money/2;
					}
				}
				
				int stocksToBuy = (int) (moneyForTheStock/currentPrice);
 				if (stocksToBuy == 0) {
 					iterator.remove();
 				} else {
 					stock.numberOfStocksForTransaction = stocksToBuy;
 					System.out.println("moneyForTheStock: " + moneyForTheStock);
 					money -= moneyForTheStock;
 					System.out.println("money: " + money);
 				}
				
			} else if (stock.numberOfStocksOwned > 0 && stock.points < 0){
//				SELL
				stock.transactionType = "SELL";
				stock.numberOfStocksForTransaction = stock.numberOfStocksOwned;
			} else if (stock.numberOfStocksOwned == 0 && stock.points < 0) {
				iterator.remove();
			}
		}
		
		return stockList;
	}

	/**
	 * @param money
	 * @param stockList
	 */
	private static double computeValuePerStockPoint(double money, List<Stock> stockList) {
		int stockPoints = 0;
		double valuePerStockPoint;
		for (Stock stock : stockList) {
			if (stock.points > 0) {
				stockPoints += stock.points;
			}
		}
		
		if (stockPoints > 1) {
			valuePerStockPoint = money/stockPoints;
		} else {
			valuePerStockPoint = money;
		}
		return valuePerStockPoint;
	}

	/**
	 * @param stockList
	 */
	private static List<Stock> sortStockList(List<Stock> stockList) {
		Collections.sort(stockList, new Comparator<Stock>() {
			@Override
			public int compare(Stock o1, Stock o2) {
				if (o1.points > o2.points) {
					return 1;
				} else if (o1.points < o2.points){
					return -1;
				}
				return 0;
			}
		});
		return stockList;
	}
	
	private static Stock initalizeStock(int i, double[] prices, String name, int stocksOwned) {
		Stock stock = new Stock(name, stocksOwned);
		int average = computeAverage(i, prices);
		
		stock.currentPrice = (int) prices[prices.length - 1];
		stock.points = computePoints(average, stock.currentPrice);
		return stock;
	}

	private static int computePoints(int average, double currentPrice) {
		int sign = -1;
		double nominator;

		if (average > currentPrice) {
			sign = 1;
			nominator = average-currentPrice;
		} else {
			nominator = currentPrice-average;
		}
		
		double points = nominator * 100;
		double divideBy = average * 33;
		return (int) (points/divideBy * sign);
	}

	/**
	 * @param i
	 * @param prices
	 */
	private static int computeAverage(int i, double[] prices) {
		int total = 0;
		int length = prices.length;
		for (int k=0; k<length; k++) {
			total += prices[k];
		}
		return total/length;
	}

	/* Tail starts here */
	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        
	        double _m;
	        _m = in.nextDouble();
	        
	        int _k;
	        _k = in.nextInt();
	        
	        int _d;
	        _d = in.nextInt();
	        
	        String[] _name = new String[_k];
	        int[] _owned = new int[_k];
	        double[][] _prices = new double[_k][5];
	        
	        String _name_item;
	        int _owned_item;
	        double _prices_item_item;
	        
	        for(int _i = 0; _i < _k; _i++) {
	            _name_item = in.next();
	            _name[_i] = _name_item;
	            
	            _owned_item = in.nextInt();
	            _owned[_i] = _owned_item;
	            
	            for(int _j = 0; _j<5; _j++) {
	                _prices_item_item = in.nextDouble();
	                _prices[_i][_j] = _prices_item_item;                
	            }
	        }
	        
	        printTransactions(_m, _k, _d, _name, _owned, _prices);
	        
	    }
	
	public static class Stock {
		private String name;
		private int numberOfStocksOwned;
		private double currentPrice;
		private int points;
		private int numberOfStocksForTransaction;
		private String transactionType;
		
		public Stock(String name, int stocksOwned) {
			super();
			this.name = name;
			this.numberOfStocksOwned = stocksOwned;
		}
		
		
	}
}
