package view;

import controller.MenuController;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.text.Font;
import javafx.scene.control.Menu;

public class MenuView {
	
	MenuController controller;
	
	public MenuView(MenuController controller){
		this.controller = controller;
	}
	
	public MenuView(){
		
	}
	
	public MenuBar getMenu(){
        MenuBar menuBar = new MenuBar();
        
        Label portalName = new Label("Rent Portal\t\t");
        portalName.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Thousandyard.otf"), 20));
        portalName.setOnMouseClicked(controller.goHomePortal());
        
        Label importName = new Label("Import");
        importName.setFont(Font.font("Sans Serif", 16));
        importName.setOnMouseClicked(controller.importData());
        
        Label exportName = new Label("Export");
        exportName.setFont(Font.font("Sans Serif", 16));
        exportName.setOnMouseClicked(controller.exportData());
        
        Label exitName = new Label("Exit");
        exitName.setFont(Font.font("Sans Serif", 16));
        exitName.setOnMouseClicked(controller.exitPortal());
        
        Menu home = new Menu("", portalName);
        Menu importData = new Menu("",importName);
        Menu exportData = new Menu("",exportName);
        Menu exit = new Menu("",exitName);
        
        menuBar.getMenus().addAll(home,importData,exportData,exit);
        
		return menuBar;	
	}


}
