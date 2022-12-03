package util;

import javafx.scene.control.Alert;

public class AlertDialog {

    public static void SimpleDialog(String title, String description) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION, description);
       if(title.length()>0){
           alerta.setTitle(title);
       }else{
           alerta.setTitle("Alerta");
       }
        alerta.show();
    }
}
