package model;

import java.util.Date;

public class RentalRecord {
	String rentalId;
	String Customer;
	Property property;
	Date start;
	Date estimatedEnd;
	Date actualEnd;
	Double rentalFee;
	Double lateFee;
	Double totalFee;
	
	public RentalRecord() {
		super();
	}
	
	
	
	@Override
	public String toString() {
		return "R:" + property.getProperty_id() + ":" + start + ":" + estimatedEnd
				+ ":" + actualEnd + ":" + rentalFee + ":" + lateFee + ":"
				+ totalFee;
	}



	public RentalRecord(Property property, String cus, Date start, Date estimatedEnd, Date actualEnd, Double rentalFee,
			Double lateFee, Double totalFee) {
		super();
		this.rentalId = String.format("%s_%s_%s", property.getProperty_id(), cus, start);
		this.property = property;
		this.start = start;
		this.estimatedEnd = estimatedEnd;
		this.actualEnd = actualEnd;
		this.rentalFee = rentalFee;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.Customer = cus;
	}
	public String getRentalId()
	{

		this.rentalId = String.format("%s_%s_%s", property.getProperty_id(), Customer, start);
		return this.rentalId;
	}
	
	public Property getProperty() {
		return property;
	}
	public void setProperty(Property property) {
		this.property = property;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEstimatedEnd() {
		return estimatedEnd;
	}
	public void setEstimatedEnd(Date estimatedEnd) {
		this.estimatedEnd = estimatedEnd;
	}
	public Date getActualEnd() {
		return actualEnd;
	}
	public void setActualEnd(Date actualEnd) {
		this.actualEnd = actualEnd;
	}

	public Double getRentalFee() {
		return rentalFee;
	}

	public void setRentalFee(Double rentalFee) {
		this.rentalFee = rentalFee;
	}

	public Double getLateFee() {
		return lateFee;
	}

	public void setLateFee(Double lateFee) {
		this.lateFee = lateFee;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getCustomer()
	{
		return Customer;
	}
	public void setCustomer(String   cus)
	{
		Customer = cus;
	}
}
