package controller;

import DBAccess.PopulateDB;
import Services.PropertyService;
import javafx.application.Application;
import javafx.stage.Stage;
import view.Home;
import view.MenuView;

public class FlexiRent extends Application {
	
	MenuController menuController;
	MenuView menuView;
	Home home;
	Stage window;
	PropertyService service;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
	    window.setTitle("FlexiRent Portal");
	    
	    menuController = new MenuController();
	    menuView = new MenuView(menuController);
	    home = new Home(menuView,window);	   
	    service = new PropertyService();
	    PopulateDB.populateDB(true);
	    menuController.setHomePage(home.getHome());
	    menuController.setWindow(window);
	    menuController.setService(service);
	    
	    window.setScene(home.getHome());
	    window.show();
	      	
	}

   public static void main(String args[]){ 
	      launch(args); 
   } 
}
