package controller;

import java.io.File;

import Services.PropertyService;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuController {
	Stage window;
	Scene homePage;
	PropertyService service;

	public Stage getWindow() {
		return window;
	}


	public void setWindow(Stage window) {
		this.window = window;
	}

	public Scene getHomePage() {
		return homePage;
	}


	public void setHomePage(Scene homePage) {
		this.homePage = homePage;
	}


	public PropertyService getService() {
		return service;
	}


	public void setService(PropertyService service) {
		this.service = service;
	}


	public MenuController(){
		
	}
	

	public MenuController(Stage window, Scene homePage, PropertyService service) {
		super();
		this.window = window;
		this.homePage = homePage;
		this.service = service;
	}

	public EventHandler<MouseEvent> goHomePortal(){
		
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				window.setScene(homePage);
			}
		};
		
	}
	
	public EventHandler<MouseEvent> importData(){
		
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showOpenDialog(window);
                if (null == file)
                {
                	try {
						throw new InvalidException("No  File Chosen");
					} catch (InvalidException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                service.loadFromFile(file.getAbsolutePath());
			}
		};
		
	}
	
	public EventHandler<MouseEvent> exportData(){
		
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {

				FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialFileName("export");
                
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.setSelectedExtensionFilter(extFilter);
                File exportFile = fileChooser.showSaveDialog(window);
                fileChooser.setInitialDirectory(exportFile);
                service.populateExportFile(exportFile);
			}
		};
		
	}
	
	public EventHandler<MouseEvent> exitPortal(){
		
		return new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Exit------------------------------------");
				window.close();
				
			}
		};
		
	}
}
