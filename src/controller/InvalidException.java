package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InvalidException  extends Exception{
	public InvalidException (String s)
	{
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Invalid Exception");
        alert.setHeaderText("Exception:");
        alert.setContentText("Operation not Permitted - "+s);
 
        alert.showAndWait();
	}

}