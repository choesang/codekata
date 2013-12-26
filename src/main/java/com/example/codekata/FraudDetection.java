package com.example.codekata;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FraudDetection {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
		int records = scanner.nextInt();
		List<Transaction> transactionsList = new ArrayList<Transaction>();
		
		for (int i = 0; i< records; i++) {
			String record = scanner.next().toLowerCase();
			String[] splitRecord = record.split(",");
			FraudDetection fraudDetection = new FraudDetection();
			Transaction transaction = fraudDetection.new Transaction(splitRecord);
			transactionsList.add(transaction);
		}
		
		fraudDetector(transactionsList);
	}
	


	private static void fraudDetector(List<Transaction> transactionsList) {
		Set<String> fraudsters = new TreeSet<String>();
		for (int i = 0; i < transactionsList.size(); i++) {
			Iterator<Transaction> iterator = transactionsList.iterator();
			while (iterator.hasNext()) {
				Transaction transaction = iterator.next();
				if ( !transactionsList.get(i).equals(transaction) ) {
					if (fraudDetector(transactionsList.get(i), transaction)) {
						fraudsters.add(transactionsList.get(i).getOrderId());
						fraudsters.add(transaction.getOrderId());
					}
				}
			}
		}
		printSet(fraudsters);
	}



	private static void printSet(Set<String> fraudsters) {
		Iterator<String> iterator = fraudsters.iterator();
		if (iterator.hasNext()) {
			System.out.print(iterator.next());
			while (iterator.hasNext()) {
				System.out.print("," + iterator.next());
			}
		}
	}

	private static boolean fraudDetector(Transaction tx1, Transaction tx2) {
		if ( tx1.getDealId().equals(tx2.getDealId()) ) {
			if ( tx1.getAddress().equals(tx2.getAddress()) || tx1.getEmail().equals(tx2.getEmail()) ) {
				return true;
			}
		}
		return false;
	}
	
	public class Address {
		
		private String street;
		private String city;
		private String state;
		private String zip;
		
		public Address(String street, String city, String state, String zip) {
			
			String[] streetArray = street.split(" ");
			String number = streetArray[0];
			String name = streetArray[1];
			String type = autoCorrectionType(streetArray[2]);
			
			this.street = number + " " + name + " " + type;
			this.city = autoCorrectionCity(city.toLowerCase());
			this.state = state;
			this.zip = zip;
		}

		private String autoCorrectionCity(String city) {
			
			if (city.equals("ny") || city.equals("new york")) {
				return "ny";
			} else if (city.equals("il") || city.equals("illinois")) {
				return "il";
			} else if (city.equals("ca") || city.equals("california")) {
				return "ca";
			}
			
			return "";
		}

		private String autoCorrectionType(String type) {
			if (type.equals("st.") || type.equals("street")) {
				return "street";
			} else if(type.equals("rd.") || type.equals("road")) {
				return "road";
			}
			return "";
		}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Address [street=" + street + ", city=" + city + ", state="
					+ state + ", zip=" + zip + "]";
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Address other = (Address) obj;
			if (city == null) {
				if (other.city != null)
					return false;
			} else if (!city.equals(other.city))
				return false;
			if (state == null) {
				if (other.state != null)
					return false;
			} else if (!state.equals(other.state))
				return false;
			if (street == null) {
				if (other.street != null)
					return false;
			} else if (!street.equals(other.street))
				return false;
			if (zip == null) {
				if (other.zip != null)
					return false;
			} else if (!zip.equals(other.zip))
				return false;
			return true;
		}

		
	}
	
	public class Transaction {
		
		private String orderId;
		private String dealId;
		private String email;
		private Address address;
		private String creditCard;
		
		public Transaction(String[] record) {
			this.orderId = record[0];
			this.dealId = record[1];
			this.email = record[2];
			this.address = new Address(record[3].toLowerCase(), record[4], record[5], record[6]);
			this.creditCard = record[7];
		}

		/**
		 * @return the orderId
		 */
		public String getOrderId() {
			return orderId;
		}

		/**
		 * @return the dealId
		 */
		public String getDealId() {
			return dealId;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @return the address
		 */
		public Address getAddress() {
			return address;
		}

		/**
		 * @return the creditCard
		 */
		public String getCreditCard() {
			return creditCard;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Transaction [orderId=" + orderId + ", dealId=" + dealId
					+ ", email=" + email + ", address=" + address
					+ ", creditCard=" + creditCard + "]";
		}
		
	}

}
