package view;

import java.util.List;

import Services.PropertyService;
import controller.HomeController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Property;


public class Home {
	
	PropertyService service = new PropertyService();
	MenuView menuView;
	HomeController controller = new HomeController();

	public Home(MenuView menuView, Stage window) {
		super();
		this.menuView = menuView;
		controller.setMenuView(menuView);
		controller.setWindow(window);
	}
	
   public Scene getHome(){
	      BorderPane outerBorder = new BorderPane();
	      outerBorder.setPadding(new Insets(20, 20, 20, 20));
	      GridPane centerGrid = getPropertiesListView(service.getAllProperties());
	      outerBorder.setTop(menuView.getMenu());
	      outerBorder.setCenter(centerGrid);
	      Scene scene = new Scene(outerBorder, 500, 500);
	   return scene;
   }
   
	
   public GridPane getPropertiesListView(List<Property> allProperties){
	  GridPane centerGrid = new GridPane();
      centerGrid.setPadding(new Insets(20, 20, 20, 20));
      centerGrid.setVgap(20);
      centerGrid.setHgap(20);
      Integer row = 0;
      Integer column = 0;
      
      for(Property property:allProperties){
    	  BorderPane border = getPropertySummaryBox(property.getProperty_id(), property.getSuburb(), property.getShort_desc(), property.getImageUrl());
    	  centerGrid.add(border, row, column, 1, 1);
    	  if(column >= 3){
    		  column = 0;
    		  row += 1;
    	  }else{
    		  column += 1;
    	  }
    	  
      }
	  return centerGrid;
   }

   public BorderPane getPropertySummaryBox(String propertyId, String title, String shortDescription, String imageUrl){
	   	  ImageView imageView = this.getPropertyImage(imageUrl);
	      Button button = new Button("Book");
	      button.setOnMouseClicked(controller.goToPropertyPortal(propertyId));
	      Label label = new Label(title);
	      Text text = new Text(shortDescription);
	      text.setWrappingWidth(180);
	      BorderPane border = new BorderPane();
	      border.setTop(imageView);
	      border.setLeft(label);
	      border.setRight(button);
	      border.setBottom(text);
	      return border;
   }
   
   public ImageView getPropertyImage(String imageUrl){
	  Image image = null;
	  System.out.println(imageUrl);
	  image = new Image(service.getClass().getResourceAsStream(imageUrl));  
      ImageView imageView = new ImageView(image); 
      imageView.setX(50); 
      imageView.setY(25);
      imageView.setFitHeight(150); 
      imageView.setFitWidth(200);  
      return imageView;
   }
	
}
