package model;

public class Apartment extends Property {
	
	double rentalFees;
	double lateFees;
	
	public Apartment() {
		super();
	}


	public Apartment(String property_id, int street_number, String street_name, String suburb, int no_of_bedroom,
			String short_desc, String prop_type, String status, String long_desc, Double fee_per_day,
			String inMaintenance,double rentalFees, double lateFees) {
		super(property_id, street_number, street_name, suburb, no_of_bedroom, short_desc, prop_type, status, long_desc,
				fee_per_day, inMaintenance);
		this.rentalFees = rentalFees;
		this.lateFees = lateFees;
	}


	public double calculateLateFee(int lateDays ){
		
		return (lateDays*lateFees);
		
	}
	
	public double calculateEstimatedFee(int rentDays ){
		
		return (rentDays*rentalFees);
		
	}
	
	public double calculateRentalFee(int lateDays ,int rentDays){
		
		return calculateLateFee(lateDays)+calculateEstimatedFee(rentDays);
		
	}
	
}
