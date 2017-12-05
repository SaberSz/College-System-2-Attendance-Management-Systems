/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

/**
 *
 * @author dylan
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class AlertBox {

    
    public static void showErrorMessage(Exception ex) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error occured");
        alert.setHeaderText("Error Occured");
        alert.setContentText(ex.getLocalizedMessage());

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }

    public static void display1(String title, String message) {
        Stage window = new Stage();
        //window.initStyle(StageStyle.UNDECORATED);
        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);//tells the compiler that this window cantbhave any interactions with outside world until it is open 
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Okay");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();//waits till an action is performed
    }
    
    public static void notificationWarn(String title,String text){
        Notifications n = Notifications.create()
                .title(title)
                .text(text)
                .graphic(null)
                .hideAfter(Duration.seconds(7))
                .position(Pos.CENTER);
       n.darkStyle();
       n.showWarning();
    }
    public static void notificationInfo(String title,String text){
        Notifications n = Notifications.create()
                .title(title)
                .text(text)
                .graphic(null)
                .hideAfter(Duration.seconds(7))
                .position(Pos.CENTER);
       n.darkStyle();
       n.showInformation();
    }
    public static boolean alertoption(String title,String header,String content)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
alert.setTitle(title);
alert.setHeaderText(header);
alert.setContentText(content);

Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;
    }

}