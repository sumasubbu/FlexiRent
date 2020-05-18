package Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DBAccess.PropertyDao;
import model.Property;
import model.RentalRecord;

public class PropertyService {
	
	PropertyDao propertyDao = new PropertyDao();
	RentalRecordService recordService = new RentalRecordService();
	
	public List<Property> getAllProperties(){
		return propertyDao.getAllProperties();
	}
	
	public Property getProperty(String propertyId){
		return propertyDao.getProperty(propertyId);		
	}
	
	public void addProperty(Property property){
		propertyDao.insertProperty(property);
	}
	
	public void addProperties(List<Property> propertyList){
		for(Property property:propertyList){
			System.out.println("Adding prop "+property.toString());
			propertyDao.insertProperty(property);
		}
	}
	
	public void startMaintenance(String propertyId){
		propertyDao.startMaintenance(propertyId);
	}
	
	public void stopMaintenance(String propertyId){
		propertyDao.endMaintenance(propertyId);
	}
	
	public void populateExportFile(File exportFile){
		try {
			
			FileWriter fwrite = new FileWriter(exportFile);
			
			List<Property> propertyList = new ArrayList<>();
			List<RentalRecord> rentalRecordList = new ArrayList<>();
			
			propertyList = this.getAllProperties();
			
			for(Property property:propertyList){
				System.out.println("Writing"+property.toString());
				fwrite.write(property.toString());
				fwrite.write("\n");
			}
			
			for(Property property:propertyList){
				rentalRecordList.addAll(recordService.getRentalRecords(property));
			}
			
			for(RentalRecord record:rentalRecordList){
				fwrite.write(record.toString());
				fwrite.write("\n");
			}		
		 
			fwrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void loadFromFile(String absolutePath) {
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(absolutePath);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			List<Property> propertyList = new ArrayList<>();
			List<RentalRecord> recordList = new ArrayList<>();
			String strLine;
			while ((strLine = br.readLine()) != null)   {
				String[] data = strLine.split(":");
				if(data.length == 13){
						Property property = new Property();
						property.setProperty_id(data[1]);
						property.setStreet_number(Integer.parseInt(data[2]));
						property.setStreet_name(data[3]);
						property.setSuburb(data[4]);
						property.setNo_of_bedroom(Integer.parseInt(data[5]));
						property.setShort_desc(data[6]);
						property.setProp_type(data[7]);
						property.setStatus(data[8]);
						property.setLong_desc(data[9]);
						property.setFee_per_day(Double.parseDouble(data[10]));
						property.setInMaintenance(data[11]);
						property.setImageUrl(data[12]);
						propertyList.add(property);
						System.out.println(propertyList.size());
					}
					if(data.length == 8){
						RentalRecord record = new RentalRecord();
						record.setProperty(new Property(data[1]));
						try {
							record.setStart(new SimpleDateFormat("yyyy-MM-dd").parse(data[2]));
							record.setEstimatedEnd(new SimpleDateFormat("yyyy-MM-dd").parse(data[3]));
							record.setActualEnd(new SimpleDateFormat("yyyy-MM-dd").parse(data[4]));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						record.setRentalFee(Double.parseDouble(data[5]));
						record.setLateFee(Double.parseDouble(data[6]));
						record.setTotalFee(Double.parseDouble(data[7]));
						recordList.add(record);					
					}
			
			  System.out.println (data.length);
			  

			}
			  this.addProperties(propertyList);
			  recordService.addRentalRecords(recordList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
