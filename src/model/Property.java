package model;

public class Property {
	
	String Property_id;
	int Street_number;
	String  Street_name;
	String Suburb;
	int no_of_bedroom;
	String short_desc;
	String prop_type;
	String status;
	String long_desc;
	Double fee_per_day;
	String inMaintenance;
	String imageUrl;


	@Override
	public String toString() {
		return "P:" + Property_id + ":" + Street_number + ":"
				+ Street_name + ":" + Suburb + ":" + no_of_bedroom + ":" + short_desc
				+ ":" + prop_type + ":" + status + ":" + long_desc + ":"
				+ fee_per_day + ":" + inMaintenance + ":" + imageUrl;
	}

	public Property() {
		super();
	}
	
	public Property(String property_id, int street_number, String street_name, String suburb, int no_of_bedroom,
			String short_desc, String prop_type, String status, String long_desc, Double fee_per_day,
			String inMaintenance) {
		super();
		Property_id = property_id;
		Street_number = street_number;
		Street_name = street_name;
		Suburb = suburb;
		this.no_of_bedroom = no_of_bedroom;
		this.short_desc = short_desc;
		this.prop_type = prop_type;
		this.status = status;
		this.long_desc = long_desc;
		this.fee_per_day = fee_per_day;
		this.inMaintenance = inMaintenance;
	}
	public Property(String propertyId) {
		this.Property_id = propertyId;
	}

	public Double getFee_per_day() {
		return fee_per_day;
	}
	public void setFee_per_day(Double fee_per_day) {
		this.fee_per_day = fee_per_day;
	}
	public String getInMaintenance() {
		return inMaintenance;
	}
	public void setInMaintenance(String inMaintenance) {
		this.inMaintenance = inMaintenance;
	}
	public String getProperty_id() {
		return Property_id;
	}
	public void setProperty_id(String property_id) {
		Property_id = property_id;
	}
	public int getStreet_number() {
		return Street_number;
	}
	public void setStreet_number(int street_number) {
		Street_number = street_number;
	}
	public String getStreet_name() {
		return Street_name;
	}
	public void setStreet_name(String street_name) {
		Street_name = street_name;
	}
	public String getSuburb() {
		return Suburb;
	}
	public void setSuburb(String suburb) {
		Suburb = suburb;
	}
	public int getNo_of_bedroom() {
		return no_of_bedroom;
	}
	public void setNo_of_bedroom(int no_of_bedroom) {
		this.no_of_bedroom = no_of_bedroom;
	}
	public String getShort_desc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getProp_type() {
		return prop_type;
	}
	public void setProp_type(String prop_type) {
		this.prop_type = prop_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLong_desc() {
		return long_desc;
	}
	public void setLong_desc(String long_desc) {
		this.long_desc = long_desc;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
