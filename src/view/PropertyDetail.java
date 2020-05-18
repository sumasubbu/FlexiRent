package view;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import Services.PropertyService;
import Services.RentalRecordService;
import controller.RentException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Property;
import model.RentalRecord;

public class PropertyDetail {
	
	PropertyService service = new PropertyService();
	RentalRecordService recordService = new RentalRecordService();
	Property property = new Property();
	MenuView menuView;
	Boolean flag;
	
	ObservableList<RentalRecord> obvList;
	public PropertyDetail(MenuView menuView) {
		super();
		this.menuView = menuView;
	}
	
	
	

	public MenuView getMenuView() {
		return menuView;
	}




	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}




	public Scene getPropertyDetail(String propertyId) {
		
		  Property property = service.getProperty(propertyId);
		  this.setProperty(property);
		  
		  
		  MenuBar menu = menuView.getMenu();
		  
	   	  ImageView imageView = this.getPropertyImage(property.getImageUrl());
	      Label suburb = new Label(property.getSuburb()+"\n"+property.getStreet_number()+", "+property.getStreet_name());
	      suburb.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Thousandyard.otf"), 16));
	      Text text = new Text(property.getLong_desc());
	      Label status = new Label("Currently "+property.getStatus());
	      status.setFont(Font.font ("Verdana", 12));
	      Label dollar = new Label("$ "+property.getFee_per_day().toString()+"/- per night.");
	      dollar.setFont(Font.font ("Verdana", 12));
	      
	      Label maintenance = new Label();
	      maintenance.setFont(Font.font ("Verdana", 12));
	      
	      Button toggleMaintence = new Button();
	      
	      flag = false;
	      
	      if(property.getInMaintenance() == "yes"){
	    	  maintenance.setText("Under Maintenance");
	    	  maintenance.setTextFill(Color.ORANGERED);
	    	  toggleMaintence.setText("Complete Maintenance");
	    	  flag = false;
	      }else{
	    	  maintenance.setText("");
	    	  toggleMaintence.setText("Start Maintenance");
	    	  flag = true;
	      }
	      
	      

	      
	      
	      text.setWrappingWidth(180);
	      
	      VBox details = new VBox();
	      details.setPadding(new Insets(10));
	      details.getChildren().add(suburb);
	      details.getChildren().add(status);
	      details.getChildren().add(dollar);
	      details.getChildren().add(text);
	      details.getChildren().add(maintenance);
	      details.getChildren().add(toggleMaintence);
	      VBox records = getRentalRecords();
	      records.setMinWidth(200);
	      details.getChildren().add(records);
	     
	      VBox left = new VBox();
	      left.setPadding(new Insets(10));
	      left.getChildren().add(imageView);
	      
	    	  if(property.getStatus().equals("Available")){
		    	  left.getChildren().add(getRentalPane());
		      }else if(property.getStatus().equals("Rented")){
		    	  left.getChildren().add(getReturnPane());
		      }
	     


	      BorderPane border = new BorderPane();
	      border.setPadding(new Insets(20,10,10,10));	      
	      
	      toggleMaintence.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if(flag){
			    	  maintenance.setText("Under Maintenance");
			    	  maintenance.setTextFill(Color.ORANGERED);
			    	  toggleMaintence.setText("Complete Maintenance");
			    	  flag = false;
			    	  property.setInMaintenance("Yes");
			    	  service.startMaintenance(propertyId);
			    }else{
			    	  maintenance.setText("");
			    	  toggleMaintence.setText("Start Maintenance");
			    	  flag = true;
			    	  property.setInMaintenance("No");
			    	  service.stopMaintenance(propertyId);
			    }
			
				
			      }
		});
	      
	      
	      HBox center = new HBox();
	      center.getChildren().add(left);
	      center.getChildren().add(details);

	      
	      border.setTop(menu);
	      border.setCenter(center);
	      Scene scene = new Scene(border,1000,800);
	      
		return scene;
	      
	}
	
	public Property getProperty() {
		return property;
	}




	public void setProperty(Property property) {
		this.property = property;
	}




	public BorderPane getRentalPane(){
		
		Label title = new Label("\nTo rent this property\n\n\n");
		title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Thousandyard.otf"), 12));
		Label start = new Label("From  ");
		Label end = new Label("To      ");
		Label customerEmail = new Label("Customer ID: ");
		
		DatePicker startDate = new DatePicker();
		DatePicker endDate = new DatePicker();
		TextField emailAddress = new TextField();
		
		HBox startBox = new HBox();
		startBox.getChildren().addAll(start,startDate);
		
		HBox endBox = new HBox();
		endBox.getChildren().addAll(end,endDate);
		
		HBox mailBox = new HBox();
		mailBox.getChildren().addAll(customerEmail,emailAddress);

		Button submit = new Button("Rent");
		
		VBox form = new VBox();
		form.setPadding(new Insets(5,5,5,5));
		form.getChildren().addAll(title,mailBox);
		form.getChildren().addAll(startBox,endBox);
		form.getChildren().add(submit);
		
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20));
		border.setCenter(form);	
		
		submit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				String customerId = emailAddress.getText();
				LocalDate startValue = startDate.getValue();
				LocalDate endValue = endDate.getValue();
				LocalDate yesterday = LocalDate.now().minus(Period.ofDays(1));
				try {
					if(startValue == null || endValue == null || customerId == null || customerId.length()== 0){
						throw new RentException("Fields can't be empty. Please try again with all details.");
					}else if(!startValue.isAfter(yesterday) || !endValue.isAfter(yesterday)){
						throw new RentException("Selected Date can not be in the past!");
					}else if(startValue.isAfter(endValue)){
	
						throw new RentException("End date Should be greater than Start Date");
					}else{
						Instant startinstant = startValue.atStartOfDay().atZone(ZoneId.systemDefault())
						        .toInstant();
						Date begin =  Date.from(startinstant);
						Instant endinstant = endValue.atStartOfDay().atZone(ZoneId.systemDefault())
						            .toInstant();
						Date end =  Date.from(endinstant);
						
						LocalDate futureDate = endValue.plusDays(100);
						Instant futureinstant = futureDate.atStartOfDay().atZone(ZoneId.systemDefault())
					            .toInstant();
					Date future =  Date.from(futureinstant);
						RentalRecord record = new RentalRecord(getProperty(),customerId, begin,  end, future, property.getFee_per_day(), 100.00, 0.00);
						property.setStatus("Rented");
						System.out.println("Adding Rental ->"+record.toString());
						recordService.addRentalRecord(record);
						obvList.add(record);
					}
				} catch (RentException e)
				{
					
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		
		return border;
		
	}
	
	public VBox getRentalRecords(){
		
		List<RentalRecord> rentalRecords = recordService.getRentalRecords(getProperty());
		
		TableView tableView = new TableView();
    	Label title = new Label("\nRental History\n");
		VBox records = new VBox(title);
    	title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Thousandyard.otf"), 12));
    	
    	records.getChildren().add(tableView);
    	
    	TableColumn serialNumberHeader = new TableColumn("ID");
    	serialNumberHeader.setCellValueFactory(new PropertyValueFactory<RentalRecord, String>("rentalId"));
    	serialNumberHeader.setMinWidth(tableView.getMaxWidth()/5);
    	
    	TableColumn customerHeader = new TableColumn("Customer");
    	customerHeader.setCellValueFactory(new PropertyValueFactory<RentalRecord, String>("Customer"));
    	customerHeader.setMinWidth(tableView.getMaxWidth()/5);
    	
    	TableColumn startDateHeader = new TableColumn("Start");
    	startDateHeader.setCellValueFactory(new PropertyValueFactory<RentalRecord, String>("start"));
    	startDateHeader.setMinWidth(tableView.getMaxWidth()/5);
    	
    	TableColumn estimatedDateHeader = new TableColumn("Scheduled End");
    	estimatedDateHeader.setCellValueFactory(new PropertyValueFactory<RentalRecord, String>("estimatedEnd"));
    	estimatedDateHeader.setMinWidth(tableView.getMaxWidth()/5);
    	
    	TableColumn actualDateHeader = new TableColumn("Actual End");
    	actualDateHeader.setCellValueFactory(new PropertyValueFactory<RentalRecord, String>("actualEnd"));
    	actualDateHeader.setMinWidth(tableView.getMaxWidth()/5);

		obvList = FXCollections.observableArrayList();// rentalRecords;
		obvList.addAll(rentalRecords);
		tableView.setItems(obvList);
		
		

		tableView.getColumns().addAll(serialNumberHeader,customerHeader, startDateHeader,estimatedDateHeader,actualDateHeader);
		
        
	
		return records;
		
	}
	
	
	
public BorderPane getReturnPane(){
		
		Label title = new Label("\n Return here!\n");
		title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Thousandyard.otf"), 12));
		Label customerEmail = new Label("Customer ID: ");
		TextField emailAddress = new TextField();
		
		HBox mailBox = new HBox();
		mailBox.getChildren().addAll(customerEmail,emailAddress);

		Button submit = new Button("Return");
		
		VBox form = new VBox();
		form.setPadding(new Insets(5,5,5,5));
		form.getChildren().addAll(title,mailBox);
		form.getChildren().add(submit);
		
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20));
		border.setCenter(form);	
		
		submit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				String customerId = customerEmail.getText();
				if(customerId.length()== 0){
					Alert alert = new Alert(AlertType.ERROR,"Customer Id can't be empty. Please try again.");
					alert.show();
				}else{
					recordService.returnRentalRecord(property.getProperty_id());
					property.setStatus("Available");
					
				}
				
			}
		});
		
		return border;
		
	}
	
  public ImageView getPropertyImage(String imageUrl){
	  Image image = null;
	  System.out.println("Requesting"+imageUrl);
	  image = new Image(getClass().getResourceAsStream(imageUrl));  
      ImageView imageView = new ImageView(image); 
      imageView.setX(50); 
      imageView.setY(25);
      imageView.setFitHeight(300); 
      imageView.setFitWidth(300);  
      return imageView;
   }
}
