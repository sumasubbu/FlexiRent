package controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import view.MenuView;
import view.PropertyDetail;

public class HomeController {
	Stage window;
	MenuView menuView;
	Scene propertyDetail;
	PropertyDetail propertyDetailView = new PropertyDetail(menuView);
	
	public void goToProperty(){
		
	}
	public Stage getWindow() {
		return window;
	}

	public void setWindow(Stage window) {
		this.window = window;
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	public Scene getPropertyDetail() {
		return propertyDetail;
	}

	public void setPropertyDetail(Scene propertyDetail) {
		this.propertyDetail = propertyDetail;
	}

	public PropertyDetail getPropertyDetailView() {
		return propertyDetailView;
	}

	public void setPropertyDetailView(PropertyDetail propertyDetailView) {
		this.propertyDetailView = propertyDetailView;
	}	
	public EventHandler<MouseEvent> goToPropertyPortal(String propertyId){
			
			return new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					propertyDetailView.setMenuView(menuView);
					propertyDetail = propertyDetailView.getPropertyDetail(propertyId);
					window.setScene(propertyDetail);
				}
			};
			
	}
	
	public void pageRefresh(String propertyId){
		propertyDetailView.setMenuView(menuView);
		propertyDetail = propertyDetailView.getPropertyDetail(propertyId);
		window.setScene(propertyDetail);
	}

}

