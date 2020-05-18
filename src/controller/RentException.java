package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RentException  extends Exception{
	public RentException (String s)
	{
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Rent Exception");
        alert.setHeaderText("Exception:");
        alert.setContentText("Renting not permitted - "+s);
 
        alert.showAndWait();
	}

}
