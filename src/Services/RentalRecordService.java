package Services;

import java.util.List;

import DBAccess.RentalRecordDao;
import model.Property;
import model.RentalRecord;

public class RentalRecordService {
	
	RentalRecordDao rentalDao = new RentalRecordDao();
	
	public List<RentalRecord> getRentalRecords(Property property){
		return rentalDao.getRentalRecords(property.getProperty_id());
	}
	
	public void addRentalRecord(RentalRecord record){
		rentalDao.insertRental(record);
	}
	
	public void returnRentalRecord(String propertyId){
		rentalDao.returnRental(propertyId);
	}

	public void addRentalRecords(List<RentalRecord> recordList){
		for(RentalRecord record:recordList){
			rentalDao.insertRental(record);
		}
	}

}
