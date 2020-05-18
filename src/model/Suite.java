package model;

public class Suite extends Property {

	int rentalFees;
	int lateFees;
	int suiteGrade;
	
	
	
	public Suite() {
		super();
	}

	public Suite(String property_id, int street_number, String street_name, String suburb, int no_of_bedroom,
			String short_desc, String prop_type, String status, String long_desc, Double fee_per_day,
			String inMaintenance,int rentalFees, int lateFees, int suiteGrade) {
		super(property_id, street_number, street_name, suburb, no_of_bedroom, short_desc, prop_type, status, long_desc,
				fee_per_day, inMaintenance);
		this.rentalFees = rentalFees;
		this.lateFees = lateFees;
		this.suiteGrade = suiteGrade;
	}


	public int getRentalFees() {
		return rentalFees;
	}

	public void setRentalFees(int rentalFees) {
		this.rentalFees = rentalFees;
	}

	public int getLateFees() {
		return lateFees;
	}

	public void setLateFees(int lateFees) {
		this.lateFees = lateFees;
	}

	public int getSuiteGrade() {
		return suiteGrade;
	}

	public void setSuiteGrade(int suiteGrade) {
		this.suiteGrade = suiteGrade;
	}

	public double calculateLateFee(int lateDays ){
		
		return (lateDays*lateFees*suiteGrade);
		
	}
	
	public double calculateEstimatedFee(int rentDays ){
		
		return (rentDays*rentalFees);
		
	}
	
	public double calculateRentalFee(int lateDays ,int rentDays){
		
		return calculateLateFee(lateDays)+calculateEstimatedFee(rentDays);
		
	}
	
}
