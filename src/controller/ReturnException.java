package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ReturnException  extends Exception{
	ReturnException (String s)
	{
		Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Return Exception");
        alert.setHeaderText("Exception:");
        alert.setContentText("Returning not permitted");
 
        alert.showAndWait();
	}

}
